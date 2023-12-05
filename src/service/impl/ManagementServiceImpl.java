package service.impl;

import data.GlobalData;
import model.Client;
import model.Coin;
import service.CryptoService;
import service.ManagementService;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static data.GlobalData.*;
import static helper.RandomCoinGenerator.*;
import static helper.PriceChanger.*;


import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementService {
   private final CryptoService cryptoService = new CryptoServiceImpl();
    public void manageClient() {
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
    }
}
