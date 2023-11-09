package model;

import java.util.HashMap;

public class Wallet {
    private HashMap<Coin, Integer> coins = new HashMap<>();

    public HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public void setCoins(HashMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    private double amount = 30000;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
