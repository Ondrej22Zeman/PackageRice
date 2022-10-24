public class Bags {
    private int OneKiloBags = 0;

    private int fiveKiloBags = 0;

    public Bags() {
    }

    public int getOneKiloBags() {
        return OneKiloBags;
    }

    public void setOneKiloBags(int oneKiloBags) {
        OneKiloBags = oneKiloBags;
    }

    public int getFiveKiloBags() {
        return fiveKiloBags;
    }

    public void setFiveKiloBags(int fiveKiloBags) {
        this.fiveKiloBags = fiveKiloBags;
    }

    @Override
    public String toString() {
        return "Bags : " +
                "OneKiloBags = " + OneKiloBags +
                ", fiveKiloBags = " + fiveKiloBags;
    }

    public void addOneToFiveKgBags() {
        setFiveKiloBags(getFiveKiloBags()+1);
    }

    public void addOneKgBags(int amount) {
        setOneKiloBags(getOneKiloBags()+amount);
    }
}
