package service.impl;

import data.GlobalData;
import model.Coin;
import service.CryptoService;
import service.ManagementService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static helper.RandomCoinGenerator.*;
import static helper.PriceChanger.*;


import static data.GlobalData.client;
import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementService {
   private final CryptoService cryptoService = new CryptoServiceImpl();
   private final ExecutorService executorService = Executors.newFixedThreadPool(3);


    public void manageClient() {
        executorService.submit(() -> {
            while (true) {
                int option = entryMenu();
                switch (option) {
                    case 1:
                        cryptoService.buyCoin(client);
                        break;
                    case 2:
                        cryptoService.sellCoin(client);
                        break;
                    case 3:
                        cryptoService.seeCurrency();
                        break;
                    case 4:
                        cryptoService.seeMyCoins();
                        break;
                    case 5:
                        cryptoService.seeOtherClientsCoins();
                        break;
                    default:
                        System.err.println("Invalid Option!");
                }
            }
        });
    }

    public void manageBuyByOtherAutomatedClients() {
        executorService.submit(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Coin randomBuyCoin = getRandomCoin();
                int randomBuyQuantity = getRandomQuantity();
                if (randomBuyQuantity >= 5) {
                    priceChangerWhenBuy(randomBuyQuantity, randomBuyCoin);
                }
                GlobalData.coinIntegerByOtherClients.put(randomBuyCoin, randomBuyQuantity);
            }
        });
    }

    public void manageSellByOtherAutomatedClients() {
        executorService.submit(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Coin randomSellCoin = getRandomCoin();
                int randomSellQuantity = getRandomQuantity();
                if (randomSellQuantity >= 5) {
                    priceChangerWhenSell(randomSellQuantity, randomSellCoin);
                }
                GlobalData.coinIntegerByOtherClients.remove(randomSellCoin, randomSellQuantity);
            }
        });
    }

    @Override
    public void shutdownExecutorService() {
        executorService.shutdown();
    }


}
