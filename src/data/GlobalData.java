package data;

import model.Client;
import model.Coin;
import model.Wallet;
import service.ExecutorManagementService;
import service.impl.ExecutorManagementServiceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalData {
    public static HashMap<Coin, Integer> coinInteger = new HashMap<>();
    public static HashMap<Coin, Integer> coinIntegerByOtherClients = new HashMap<>();
    public static HashMap<String, HashMap<Coin, Integer>> threadDataMap = new HashMap<>();
    public static HashMap<String, Client> threadClients = new HashMap<>();

    public static Set<Coin> coins;
    public static Set<Client> clients = new HashSet<>();
    static Wallet wallet = new Wallet();
    public static Client client = new Client(1, "Ali", wallet);


    static {
        clients.add(client);
    }

    static {
        coins = Set.of(
                new Coin(1, "BITCOIN", 58000),
                new Coin(2, "ETHEREUM", 34000),
                new Coin(3, "CARDANO", 1800),
                new Coin(4,"TONCOIN", 99),
                new Coin(5, "FILECOIN", 198),
                new Coin(6, "EOS", 9),
                new Coin(7, "TETHER", 120),
                new Coin(8, "SOLANA", 12560)
                        );
    }
}
