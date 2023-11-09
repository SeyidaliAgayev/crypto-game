package service.impl;
import data.GlobalData;
import model.Client;
import model.Coin;
import model.Wallet;
import service.CryptoService;
import java.util.HashMap;
import static helper.PriceChanger.*;

import static util.InputUtil.*;

public class CryptoServiceImpl implements CryptoService {
    Wallet wallet = new Wallet();
    @Override
    public void buyCoin(Client client) {
        String clientName = inputRequiredString("Enter client's name: ");
        for (Client client1 : GlobalData.clients){
            if (client1.getName().equals(clientName)) {
                String selectedCoin = inputRequiredString("Which coin do you want to buy? ");
                for (Coin coin : GlobalData.coins) {
                    if (coin.getType().equals(selectedCoin)) {
                        int coinQuantity = inputRequiredInt("How many coin do you want to buy? ");
                        if (client.getWallet().getAmount() > coin.getCurrency()) {
                            priceChangerWhenBuy(coinQuantity, coin);
                            client.getWallet().setAmount(client.getWallet().getAmount() - (coin.getCurrency() * coinQuantity) );
                            System.out.println("Your wallet amount after bought: " + client.getWallet().getAmount());
                            GlobalData.coinInteger.put(coin, coinQuantity);
                        } else {
                            System.err.println("Amount is not enough!");
                        }

                    }
                }
            }
        }
    }

    @Override
    public void sellCoin(Client client) {
        String clientName = inputRequiredString("Enter client's name: ");
        for (Client client1 : GlobalData.clients) {
            if (client1.getName().equals(clientName)) {
                seeMyCoins();
                String sellCoin = inputRequiredString("Which coin do you want to sell? ");
                for (Coin coin : GlobalData.coins) {
                    if (coin.getType().equals(sellCoin)) {
                        int sellQuantity = inputRequiredInt("How many coin do you want to sell? ");
                        priceChangerWhenSell(sellQuantity, coin);
                        GlobalData.coinInteger.remove(sellCoin, sellQuantity);
                    }
                }
            }
        }
    }

    @Override
    public void seeCurrency() {
        for (Coin coin : GlobalData.coins) {
            System.out.println("Coin Name -> " + coin.getType() + "  Coin Currency -> " + coin.getCurrency());
        }
    }

    @Override
    public HashMap<Coin, Integer> seeMyCoins() {
        String clientName = inputRequiredString("Enter client's name: ");
        for (Client client : GlobalData.clients) {
            if (client.getName().equals(clientName)) {
                for (Coin coin : GlobalData.coinInteger.keySet()) {
                    int quantity = GlobalData.coinInteger.get(coin);
                    System.out.println("Coin: " + coin.getType() + "\n" + "Quantity: " + quantity);
                }
            }
        }
        return null;
    }
}