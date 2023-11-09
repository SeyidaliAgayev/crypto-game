package model;

public class Coin {
    private int id;
    private String type;
    private double currency;

    public Coin(int id, String type, double currency) {
        this.id = id;
        this.type = type;
        this.currency = currency;
    }

    public Coin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", currency=" + currency +
                '}';
    }
}
