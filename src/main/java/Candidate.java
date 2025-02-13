public class Candidate {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int candidateSurveysTaken;


    public Candidate (String firstName, String lastName, String email,
                    String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.candidateSurveysTaken = 0;

    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public int getCandidateSurveysTaken() {
        return candidateSurveysTaken;
    }

    public void incrementCandidateSurveysTaken(){
        candidateSurveysTaken++;

    }
}
