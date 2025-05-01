package SubTasks;

public class Qestions {
private String qestion;
private String goodAnswer;


    public Qestions(String qestion, String answer) {
        this.qestion = qestion;
        this.goodAnswer = answer;
    }

    public String getQestion() {
        return qestion;
    }

    public void setQestion(String qestion) {
        this.qestion = qestion;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }
}
