import java.util.List;

public class SurveyApp {
    public static void main(String[] args) {
        // create a survey
        Survey survey = new Survey("CustomerSatisfaction", "Feedback", "Surveys for the feedback");

        //add questions to the survey
        for(int i = 1; i <= 11; i++){
            survey.addQuestion(new Question("Question " +i));
        }
        //add candidates to the survey
        Candidate candidate1 = new Candidate("Marc", "Dey", "marc@gmail.com", "0681234566");
        Candidate candidate2 = new Candidate("Mar", "Dey", "mar@gmail.com", "0681234567");

        survey.addCandidate(candidate1);
        survey.addCandidate(candidate2);

        //simulate candidates taking the surveys and recording answers
        survey.recordAnswer(candidate1, survey.getQuestions().get(0), "Agree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(1), "Slightly Agree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(2), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(3), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(4), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(5), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(6), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(7), "Disagree");
        survey.recordAnswer(candidate1, survey.getQuestions().get(8), "Disagree");


        survey.recordAnswer(candidate2, survey.getQuestions().get(0), "Slightly Agree");
        survey.recordAnswer(candidate2, survey.getQuestions().get(1), "Agree");

        //print survey result
        System.out.println("Survey Results: ");
        survey.printSurveyResponses();

        //find the most given answer in the survey
        System.out.println("Most given answer: "+survey.findMostGivenAnswer());

        //find answers given by candidate 1

        System.out.println("\nAnswers given by " + candidate1.getFirstName() + ":");

        List<String> candidate1Answers = survey.getCandidateAnswers(candidate1);
        for (String answer : candidate1Answers) {
            System.out.println(answer);
        }

        //find answers given by candidate 2

        System.out.println("\nAnswers given by " + candidate2.getFirstName() + ":");
        List<String> candidate2Answers = survey.getCandidateAnswers(candidate2);
        for (String answer : candidate2Answers) {
            System.out.println(answer);
        }

        // Find the candidate who has taken the most surveys
        Candidate mostSurveysCandidate = survey.candidateWithMostSurveys();
        System.out.println("\nCandidate with most surveys: " + mostSurveysCandidate.getFirstName());

        // Check and remove questions answered by less than 50% of candidates
        System.out.println("\nChecking and removing unanswered questions...");
        survey.checkAndRemoveUnansweredQuestions();

        // Print updated survey responses
        System.out.println("\nUpdated Survey Responses:");
        survey.printSurveyResponses();

        // Validate the survey
        System.out.println("\nValidating survey...");
        if (survey.validateSurvey()) {
            System.out.println("Survey is valid.");
        } else {
            System.out.println("Survey is invalid.");
        }
    }
    }

