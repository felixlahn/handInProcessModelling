package at.fhv;

import javax.annotation.PostConstruct;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;

@SpringBootApplication
@EnableProcessApplication
public class Application {

  public static void main(String... args) {
    // Avoid resetting URL stream handler factory
    TomcatURLStreamHandlerFactory.disable();
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  protected ProcessEngine processEngine;

  @PostConstruct
  public void deployInvoice() {
    // enable metric reporting
    ProcessEngineConfigurationImpl processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngine
        .getProcessEngineConfiguration();
    processEngineConfiguration.setDbMetricsReporterActivate(false);
    // processEngineConfiguration.getDbMetricsReporter().setReporterId("REPORTER");

    ClassLoader classLoader = Application.class.getClassLoader();

    if (processEngine.getIdentityService().createUserQuery().list().isEmpty()) {
      processEngine.getRepositoryService()
          .createDeployment()
          .addInputStream("abgabe.bpmn", classLoader.getResourceAsStream("abgabe.bpmn"))
          .addInputStream("abgabeerinnerung.bpmn", classLoader.getResourceAsStream("abgabeerinnerung.bpmn"))
          .addInputStream("createAssignment.bpmn", classLoader.getResourceAsStream("createAssignment.bpmn"))
          .addInputStream("createStudent.bpmn", classLoader.getResourceAsStream("createStudent.bpmn"))
          .deploy();
    }
  }
}
