package helper;

import data.GlobalData;
import model.Coin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCoinGenerator {
    public static Coin getRandomCoin() {
        List<Coin> coinList = new ArrayList<>(GlobalData.coins);
        Random random = new Random();
        return coinList.get(random.nextInt(coinList.size()));
    }

    public static int getRandomQuantity() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}
