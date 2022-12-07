package com.listagier;

public class GameList {
    public GameList(int number, String gameName, String physicalOrDigital, boolean finished, double price) {
        this.number = number;
        this.gameName = gameName;
        this.physicalOrDigital = physicalOrDigital;
        this.finished = finished;
        this.price = price;
    }

    @Override
    public String toString() {
        return "GameList{" +
                "number=" + number +
                ", gameName='" + gameName + '\'' +
                ", physicalOrDigital='" + physicalOrDigital + '\'' +
                ", finished=" + finished +
                ", price=" + price +
                '}';
    }

    int number = 0;
    String gameName = "null";
    String physicalOrDigital = "null";
    boolean finished = false;
    double price = 0.00;
}
