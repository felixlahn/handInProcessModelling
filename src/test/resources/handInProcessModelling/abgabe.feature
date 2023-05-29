Feature: Has the student handed in?

    Scenario: student has not handed in yet
        Given there is an assingment assigend to the student
        When the assignments deadline is within three days
        Then the student should get be notified
    
    Scenario: student has handed in an assignment
        Given there is an assingment assigend to the student with enough time to deadline
        When Student handed in this assignment
        Then the studentassignment should be marked as handed in