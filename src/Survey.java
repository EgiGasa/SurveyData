import java.util.ArrayList;
import java.util.List;

//import list to define the type and array list to create the actual list

public class Survey {

    private String title;
    private String description;
    private String topic;
    private List<Question> questions;
    private List<Candidate> candidates;
    private List<SurveyResponse> responses;

    public Survey(String title, String description, String topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
        this.responses = new ArrayList<>();

    }

    public void addQuestion(Question question) {
        if (questions.size() >= 40) {
            System.out.println("Question limit reached");
            return;
        }
        else if (questions.contains(question)) {
            System.out.println("Question already exists");
        }
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void recordAnswer(Candidate candidate, Question question, String answer) {
        if (candidates.contains(candidate) && questions.contains(question)) {
            responses.add(new SurveyResponse(candidate, question, answer));
            question.recordAnswer(answer);
            candidate.incrementCandidateSurveysTaken(); //tracks surveys taken
        }
    }

    public String findMostGivenAnswer() {
        int agreeCount = 0;
        int slightlyAgreeCount = 0;
        int disagreeCount = 0;
        int slightlyDisagreeCount = 0;

        for (Question question : questions) {
            agreeCount += question.getAgreeCount();
            slightlyAgreeCount += question.getSlightlyAgreeCount();
            disagreeCount += question.getDisagreeCount();
            slightlyDisagreeCount += question.getSlightlyDisagreeCount();
        }
        String mostGivenAnswer = "Agree";
        int maxCount = agreeCount;
        if (slightlyAgreeCount > maxCount) {
            mostGivenAnswer = "SlightlyAgree";
            maxCount = slightlyAgreeCount;
        }
        if (slightlyDisagreeCount > maxCount) {
            mostGivenAnswer = "SlightlyDisagreeCount";
            maxCount = slightlyDisagreeCount;
        }
        if (disagreeCount > maxCount) {
            mostGivenAnswer = "DisagreeCount";
        }
        return mostGivenAnswer;
    }

    public void printSurveyResponses() {
        for (Question question : questions) {
            System.out.println("Question: " + question.getText());
            System.out.println("AgreeCount: " + question.getAgreeCount());
            System.out.println("SlightlyAgreeCount: " + question.getSlightlyAgreeCount());
            System.out.println("DisagreeCount: " + question.getDisagreeCount());
            System.out.println("SlightlyDisagreeCount: " + question.getSlightlyDisagreeCount());
            System.out.println("Unanswered" + question.getUnansweredCount());
            System.out.println();

        }

    }

    public List<String> getCandidateAnswers(Candidate candidate) {
        List<String> candidateAnswers = new ArrayList<>();
        for (SurveyResponse response : responses) {
            if (response.getCandidate().equals(candidate)) {
                candidateAnswers.add(response.getAnswer());
            }
        }

        return candidateAnswers;

    }

    public Candidate candidateWithMostSurveys() {
        Candidate mostSurveys = null;
        int maxSurveys = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateSurveysTaken() > maxSurveys) {
                mostSurveys = candidate;
                maxSurveys = candidate.getCandidateSurveysTaken();
            }
        }
        return mostSurveys;

    }

    public void checkAndRemoveUnansweredQuestions() {
        List<Question> questionsToRemove = new ArrayList<>();
        for (Question question : questions) {
            int answeredCount = question.getAgreeCount() + question.getSlightlyAgreeCount() + question.getDisagreeCount()
                    + question.getDisagreeCount() + question.getSlightlyDisagreeCount();
            if (answeredCount < candidates.size() / 2) {
                questionsToRemove.add(question);
            }
        }
        for (Question question : questionsToRemove) {
            removeQuestion(question);
        }
    }

    public boolean validateSurvey() {
        if (questions.size() < 10 || questions.size() > 40) {
            System.out.println("Question limit reached");
            return false;
        }

        //checks if all the questions are unique
        for(int i = 0; i < questions.size(); i++){
            for(int j = 0; j < questions.size(); j++){
                if(questions.get(i).getText().equals(questions.get(j).getText())){
                    System.out.println("Question already exists" + questions.get(i).getText());
                    return false;
                }
            }
        }
        return true;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
