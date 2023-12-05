package service.impl;
import data.GlobalData;
import model.Client;
import model.Coin;
import service.CryptoService;



import java.util.HashMap;



import static data.GlobalData.client;
import static helper.PriceChanger.*;

import static util.InputUtil.*;

public class CryptoServiceImpl implements CryptoService {
    @Override
    public void buyCoin(Client client) {
        System.out.println("==========================================");
        for (Coin coin : GlobalData.coins) {
            System.out.println("Coin Type: " + coin.getType() + "\n" +
                    "Coin Currency: " + coin.getCurrency());
        }
        System.out.println("==========================================");
        String clientName = inputRequiredString("Enter client's name: ");
        for (Client client1 : GlobalData.clients){
            if (client1.getName().equals(clientName)) {
                String selectedCoin = inputRequiredString("Which coin do you want to buy? ");
                for (Coin coin : GlobalData.coins) {
                    if (coin.getType().equalsIgnoreCase(selectedCoin)) {
                        int coinQuantity = inputRequiredInt("How many coin do you want to buy? ");
                        if (client.getWallet().getAmount() > coin.getCurrency() * coinQuantity) {
                            priceChangerWhenBuy(coinQuantity, coin);
                            client.getWallet().setAmount(client.getWallet().getAmount() - (coin.getCurrency() * coinQuantity));
                            System.out.println("Your wallet amount after bought: " + client.getWallet().getAmount());
                            GlobalData.coinInteger.put(coin, coinQuantity);
                            client.setHasCoin(true);
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
//                seeMyCoins();
                String sellCoin = inputRequiredString("Which coin do you want to sell? ");
                for (Coin coin : GlobalData.coins) {
                    if (coin.getType().equals(sellCoin.toLowerCase())) {
                        int sellQuantity = inputRequiredInt("How many coin do you want to sell? ");
                        if (sellQuantity > 6) {
                            System.err.println("You can not sell more than 6 coins!!!");
                        }
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

    public void seeOtherClientsCoins() {
        for (Client allClients : GlobalData.clients) {
            System.out.println("All clients: " + allClients);
            String clientName = inputRequiredString("Enter client's name: ");

            if (allClients.getName().equals(clientName)) {
                for (String threadName : GlobalData.threadClients.keySet()) {
                    Client threadClient = GlobalData.threadClients.get(threadName);

                    System.out.println("Thread Name: " + threadName);
                    System.out.println("Client ID: " + client.getId());
                    System.out.println("Client Name: " + client.getName());
                    System.out.println("Coin type: " + threadClient.getWallet().getCoins());
                    System.out.println("Quantity: " + threadClient.getWallet().getAmount());
                }

            }
        }
    }

    @Override
    public HashMap<Coin, Integer> seeMyCoins() {
        String clientName = inputRequiredString("Enter client's name: ");
        for (Client client : GlobalData.clients) {
            if (client.isHasCoin()) {
                if (client.getName().equals(clientName)) {
                    for (Coin coin : GlobalData.coinInteger.keySet()) {
                        int quantity = GlobalData.coinInteger.get(coin);
                        System.out.println("Coin: " + coin.getType() + "\n" + "Quantity: " + quantity);
                    }
                }
            } else {
                System.err.println("There is no any coin in your account yet!!!");
            }
        }
        return null;
    }
}
