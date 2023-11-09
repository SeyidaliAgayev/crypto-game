package service.impl;

import model.Client;
import model.Wallet;
import service.CryptoService;
import service.ManagementService;


import static data.GlobalData.client;
import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementService {
   private final CryptoService cryptoService = new CryptoServiceImpl();

    @Override
    public void manageClient() {
        Thread thread = manageOtherClients();
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
                default:
                    System.err.println("Invalid Option!");
            }
        }
    }

    @Override
    public Thread manageOtherClients() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {
                        throw new RuntimeException(exception);
                    }
                    cryptoService.buyCoin(client);
                }
            }
        });
    }
}
