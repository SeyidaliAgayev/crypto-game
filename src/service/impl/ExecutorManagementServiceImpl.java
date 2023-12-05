package service.impl;

import data.GlobalData;
import data.GlobalValues;
import model.Client;
import model.Coin;
import model.Wallet;
import service.ExecutorManagementService;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static data.GlobalData.client;
import static data.GlobalData.coinIntegerByOtherClients;
import static helper.PriceChanger.priceChangerWhenBuy;
import static helper.PriceChanger.priceChangerWhenSell;
import static helper.RandomCoinGenerator.getRandomCoin;
import static helper.RandomCoinGenerator.getRandomQuantity;
import static helper.RandomCoinGenerator.getRandomClient;

public class ExecutorManagementServiceImpl implements ExecutorManagementService {
    @Override
    public String executorManagement() {
        ExecutorService executorService = Executors.newFixedThreadPool(GlobalValues.NUMBER_OF_THREADS);
        for (int i = 0; i < GlobalValues.NUMBER_OF_THREADS; i++) {
            executorService.submit(myRunnable);
        }
            executorService.shutdown();
        return Thread.currentThread().getName();
    }


    Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            AtomicInteger clientId = new AtomicInteger();
            Wallet wallet = new Wallet();
            int currentClientId = clientId.getAndIncrement();

            String threadName = "Client " + getRandomClient().getName();
            Thread.currentThread().setName(threadName);
            Client client = new Client(currentClientId,threadName, wallet);
            GlobalData.clients.add(client);

            while (!Thread.interrupted()) {
                Coin randomBuyCoin = getRandomCoin();
                int randomBuyQuantity = getRandomQuantity();
                if (randomBuyQuantity >= 5) {
                    priceChangerWhenBuy(randomBuyQuantity, randomBuyCoin);
                }
                GlobalData.coinIntegerByOtherClients.put(randomBuyCoin, randomBuyQuantity);
                client.getWallet().setCoins(coinIntegerByOtherClients);
                client.getWallet().setAmount(client.getWallet().getAmount() - (randomBuyCoin.getCurrency() * randomBuyQuantity));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Coin randomSellCoin = getRandomCoin();
                int randomSellQuantity = getRandomQuantity();
                if (randomSellQuantity >= 5) {
                    priceChangerWhenSell(randomSellQuantity, randomSellCoin);
                }
                GlobalData.coinIntegerByOtherClients.put(randomSellCoin, randomSellQuantity);
                client.getWallet().setCoins(coinIntegerByOtherClients);
                client.getWallet().setAmount(client.getWallet().getAmount() + (randomBuyCoin.getCurrency() * randomBuyQuantity));

            }
            GlobalData.threadDataMap.put(threadName, coinIntegerByOtherClients);
            GlobalData.threadClients.put(threadName, client);

        }
    };
}
