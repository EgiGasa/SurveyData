public class SurveyResponse {
     private Candidate candidate;
     private Question question;
     private String answer;

     public SurveyResponse(Candidate candidate, Question question, String answer) {
         this.candidate = candidate;
         this.question = question;
         this.answer = answer;
     }

     public Candidate getCandidate() {
         return candidate;
     }

     public Question getQuestion() {
         return question;
     }
     public String getAnswer() {
         return answer;
     }

}
