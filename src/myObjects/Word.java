package myObjects;

public class Word {

    private String polish;
    private String spanish;


    public Word(String polish, String spanish) {
        this.polish = polish;
        this.spanish = spanish;
    }

    public String getPolish() {
        return polish;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }
}
