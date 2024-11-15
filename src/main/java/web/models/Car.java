package web.models;

public class Car {
    private String brend;
    private String county;
    private int yom;

    public Car(String brend, String county, int yom) {
        this.brend=brend;
        this.county= county;
        this.yom=yom;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getYom() {
        return yom;
    }

    public void setYom(int yom) {
        this.yom = yom;
    }
}
