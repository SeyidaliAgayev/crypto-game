package service;

import model.Client;
import model.Coin;
import util.InputUtil;

import java.util.HashMap;

public interface CryptoService {
    void buyCoin(Client client);
    void sellCoin(Client client);
    void seeCurrency();
    HashMap<Coin, Integer> seeMyCoins();
}
