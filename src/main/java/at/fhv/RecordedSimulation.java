package at.fhv;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:8080")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "application/json, text/plain, */*");
    headers_0.put("Accept-Encoding", "gzip, deflate, br");
    headers_0.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_0.put("Sec-Fetch-Dest", "empty");
    headers_0.put("Sec-Fetch-Mode", "cors");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("X-Authorized-Engine", "default");
    headers_0.put("X-XSRF-TOKEN", "F763341B990453B79654E6FE00B28989");
    headers_0.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Accept", "application/json, text/plain, */*");
    headers_1.put("Accept-Encoding", "gzip, deflate, br");
    headers_1.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_1.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
    headers_1.put("Origin", "http://localhost:8080");
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("X-XSRF-TOKEN", "F763341B990453B79654E6FE00B28989");
    headers_1.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Accept", "application/hal+json, application/json; q=0.5");
    headers_3.put("Accept-Encoding", "gzip, deflate, br");
    headers_3.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("X-XSRF-TOKEN", "1D9A90DD1D5D5A3C3688CAE4E891D19F");
    headers_3.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Accept", "application/hal+json, application/json; q=0.5");
    headers_6.put("Accept-Encoding", "gzip, deflate, br");
    headers_6.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_6.put("Content-Type", "application/json");
    headers_6.put("Origin", "http://localhost:8080");
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("X-XSRF-TOKEN", "1D9A90DD1D5D5A3C3688CAE4E891D19F");
    headers_6.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_8.put("Accept-Encoding", "gzip, deflate, br");
    headers_8.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_8.put("Sec-Fetch-Dest", "document");
    headers_8.put("Sec-Fetch-Mode", "navigate");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("Sec-Fetch-User", "?1");
    headers_8.put("Upgrade-Insecure-Requests", "1");
    headers_8.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Accept", "text/css,*/*;q=0.1");
    headers_9.put("Accept-Encoding", "gzip, deflate, br");
    headers_9.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_9.put("Sec-Fetch-Dest", "style");
    headers_9.put("Sec-Fetch-Mode", "no-cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_12 = new HashMap<>();
    headers_12.put("Accept", "*/*");
    headers_12.put("Accept-Encoding", "gzip, deflate, br");
    headers_12.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_12.put("Sec-Fetch-Dest", "script");
    headers_12.put("Sec-Fetch-Mode", "no-cors");
    headers_12.put("Sec-Fetch-Site", "same-origin");
    headers_12.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_12.put("sec-ch-ua-mobile", "?0");
    headers_12.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_13 = new HashMap<>();
    headers_13.put("Accept", "*/*");
    headers_13.put("Accept-Encoding", "gzip, deflate, br");
    headers_13.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_13.put("Origin", "http://localhost:8080");
    headers_13.put("Sec-Fetch-Dest", "script");
    headers_13.put("Sec-Fetch-Mode", "cors");
    headers_13.put("Sec-Fetch-Site", "same-origin");
    headers_13.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_13.put("sec-ch-ua-mobile", "?0");
    headers_13.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_18 = new HashMap<>();
    headers_18.put("Accept", "application/json, text/plain, */*");
    headers_18.put("Accept-Encoding", "gzip, deflate, br");
    headers_18.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_18.put("Sec-Fetch-Dest", "empty");
    headers_18.put("Sec-Fetch-Mode", "cors");
    headers_18.put("Sec-Fetch-Site", "same-origin");
    headers_18.put("X-Authorized-Engine", "default");
    headers_18.put("X-XSRF-TOKEN", "1D9A90DD1D5D5A3C3688CAE4E891D19F");
    headers_18.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_18.put("sec-ch-ua-mobile", "?0");
    headers_18.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_22 = new HashMap<>();
    headers_22.put("Accept", "application/json");
    headers_22.put("Accept-Encoding", "gzip, deflate, br");
    headers_22.put("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_22.put("Origin", "http://localhost:8080");
    headers_22.put("Sec-Fetch-Dest", "empty");
    headers_22.put("Sec-Fetch-Mode", "cors");
    headers_22.put("Sec-Fetch-Site", "same-origin");
    headers_22.put("X-XSRF-TOKEN", "1D9A90DD1D5D5A3C3688CAE4E891D19F");
    headers_22.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_22.put("sec-ch-ua-mobile", "?0");
    headers_22.put("sec-ch-ua-platform", "Windows");


    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("login to camunda")
          .get("/camunda/api/engine/engine/")
          .headers(headers_0)
          .resources(
            http("request_1")
              .post("/camunda/api/admin/auth/user/default/login/welcome")
              .headers(headers_1)
              .formParam("username", "admin")
              .formParam("password", "admin"),
            http("request_2")
              .get("/camunda/api/engine/engine/")
              .headers(headers_0),
            http("request_3")
              .get("/camunda/api/engine/engine/default/telemetry/configuration")
              .headers(headers_3),
            http("request_4")
              .get("/camunda/api/engine/engine/default/identity/password-policy")
              .headers(headers_3)
              .check(status().is(404)),
            http("request_5")
              .get("/camunda/api/engine/engine/default/group/count?member=admin")
              .headers(headers_3),
            http("request_6")
              .post("/camunda/api/engine/engine/default/group?maxResults=25&firstResult=0")
              .headers(headers_6)
              .body(RawFileBody("at/fhv/recordedsimulation/0006_request.json")),
            http("request_7")
              .get("/camunda/api/engine/engine/default/user/admin/profile")
              .headers(headers_3)
          )
      )
      .pause(8)
      .exec(
        http("see tasklist")
          .get("/camunda/app/tasklist/default/")
          .headers(headers_8)
          .resources(
            http("request_9")
              .get("/camunda/app/tasklist/styles/user-styles.css?bust=7.18.0")
              .headers(headers_9),
            http("request_10")
              .get("/camunda/app/tasklist/styles/styles.css?bust=7.18.0")
              .headers(headers_9),
            http("request_11")
              .get("/camunda/lib/deps.js?bust=7.18.0")
              .headers(headers_11),
            http("request_12")
              .get("/camunda/app/tasklist/camunda-tasklist-bootstrap.js?bust=7.18.0")
              .headers(headers_12),
            http("request_13")
              .get("/camunda/app/tasklist/scripts/config.js?bust=1686821827348")
              .headers(headers_13),
            http("request_14")
              .get("/camunda/app/tasklist/scripts/camunda-tasklist-ui.js?bust=7.18.0")
              .headers(headers_12),
            http("request_15")
              .get("/camunda/lib/globalize.js?bust=7.18.0")
              .headers(headers_11),
            http("request_16")
              .get("/camunda/lib/ngDefine.js?bust=7.18.0")
              .headers(headers_11),
            http("request_17")
              .get("/camunda/api/tasklist/plugin/tasklistPlugins/static/app/plugin.js?bust=7.18.0")
              .headers(headers_12),
            http("request_18")
              .get("/camunda/app/tasklist/locales/en.json?_=1686821827599")
              .headers(headers_18),
            http("request_19")
              .get("/camunda/api/engine/engine/")
              .headers(headers_18),
            http("request_20")
              .get("/camunda/api/admin/auth/user/default")
              .headers(headers_18),
            http("request_21")
              .get("/camunda/api/engine/engine/default/user/admin/profile")
              .headers(headers_3),
            http("request_22")
              .options("/camunda/api/engine/engine/default/filter")
              .headers(headers_22),
            http("request_23")
              .get("/camunda/api/engine/engine/default/filter/count?itemCount=false&resourceType=Task")
              .headers(headers_3),
            http("request_24")
              .get("/camunda/api/engine/engine/default/filter?firstResult=0&maxResults=2000&itemCount=false&resourceType=Task")
              .headers(headers_3),
            http("request_25")
              .post("/camunda/api/engine/engine/default/filter/0a4cfbd2-0b5f-11ee-b04f-1a1dea8653f8/list?firstResult=0&maxResults=15")
              .headers(headers_6)
              .body(RawFileBody("at/fhv/recordedsimulation/0025_request.dat")),
            http("request_26")
              .post("/camunda/api/engine/engine/default/filter/0a4cfbd2-0b5f-11ee-b04f-1a1dea8653f8/list?firstResult=0&maxResults=15")
              .headers(headers_6)
              .body(RawFileBody("at/fhv/recordedsimulation/0026_request.dat"))
          )
      )
      .pause(2)
      .exec(
        http("list Processes")
          .get("/camunda/api/engine/engine/default/process-definition/count?latest=true&active=true&startableInTasklist=true&startablePermissionCheck=true&firstResult=0&maxResults=15")
          .headers(headers_3)
          .resources(
            http("request_28")
              .get("/camunda/api/engine/engine/default/process-definition?latest=true&active=true&startableInTasklist=true&startablePermissionCheck=true&firstResult=0&maxResults=15")
              .headers(headers_3)
          )
      )
      .pause(1)
      .exec(
        http("select createStudent Process")
          .get("/camunda/api/engine/engine/default/process-definition/createStudentProcess:1:0b643840-0b5f-11ee-b04f-1a1dea8653f8/startForm")
          .headers(headers_3)
      )
      .pause(1)
      .exec(
        http("start createStudent Process")
          .post("/camunda/api/engine/engine/default/process-definition/createStudentProcess:1:0b643840-0b5f-11ee-b04f-1a1dea8653f8/submit-form")
          .headers(headers_6)
          .body(RawFileBody("at/fhv/recordedsimulation/0030_request.json"))
          .resources(
            http("request_31")
              .get("/camunda/api/engine/engine/default/task?assignee=admin&processInstanceId=35531f80-0b60-11ee-b04f-1a1dea8653f8&maxResults=15")
              .headers(headers_3)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
