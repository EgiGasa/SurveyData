
public class Question {

    private String text;
    private int agreeCount;
    private int slightlyAgreeCount;
    private int disagreeCount;
    private int slightlyDisagreeCount;
    private int unansweredCount;


    public Question(String text) {
        this.text = text;
        this.agreeCount = 0;
        this.slightlyAgreeCount = 0;
        this.disagreeCount = 0;
        this.slightlyDisagreeCount = 0;
        this.unansweredCount = 0;
    }

    public String getText() {

        return text;
    }

    public void recordAnswer(String answer){
        switch(answer){
            case "Agree":
                agreeCount++;
                break;
                case "SlightlyAgree":
                    slightlyAgreeCount++;
                    break;
                    case "Disagree":
                        disagreeCount++;
                        break;
                        case "SlightlyDisagree":
                            slightlyDisagreeCount++;
                            break;
                            case "Unanswered":
                                unansweredCount++;
                                break;
                                default:
        }
    }

    public int getAgreeCount() {
        return agreeCount;
    }
    public int getSlightlyAgreeCount() {
        return slightlyAgreeCount;
    }

    public int getDisagreeCount() {
        return disagreeCount;

    }
    public int getSlightlyDisagreeCount() {
        return slightlyDisagreeCount;

    }
    public int getUnansweredCount() {
        return unansweredCount;

    }

}

