package helper;

import model.Coin;

public class PriceChanger {
    public static void priceChangerWhenBuy(int numberOfBuyingCoins, Coin coin) {
        if (coin.getCurrency() < 5000 && numberOfBuyingCoins > 5) {
            coin.setCurrency(coin.getCurrency() + (coin.getCurrency() * 22) / 100);
        } else if (coin.getCurrency() < 10000 && coin.getCurrency() > 5000 && numberOfBuyingCoins > 5) {
            coin.setCurrency(coin.getCurrency() + (coin.getCurrency() * 12) / 100);
        } else if (coin.getCurrency() < 20000 && coin.getCurrency() > 10000 && numberOfBuyingCoins > 5) {
            coin.setCurrency(coin.getCurrency() + (coin.getCurrency() * 6) / 100);
        } else if (coin.getCurrency() > 20000 && numberOfBuyingCoins > 5)  {
            coin.setCurrency(coin.getCurrency() + (coin.getCurrency() * 2) / 100);
        }
    }

    public static void priceChangerWhenSell(int numberOfSellCoins, Coin coin) {
        if (coin.getCurrency() < 5000 && numberOfSellCoins > 5) {
            coin.setCurrency(coin.getCurrency() - (coin.getCurrency() * 18) / 100);
        } else if (coin.getCurrency() < 10000 && coin.getCurrency() > 5000 && numberOfSellCoins > 5) {
            coin.setCurrency(coin.getCurrency() - (coin.getCurrency() * 10) / 100);
        } else if (coin.getCurrency() < 20000 && coin.getCurrency() > 10000 && numberOfSellCoins > 5) {
            coin.setCurrency(coin.getCurrency() - (coin.getCurrency() * 5) / 100);
        } else if (coin.getCurrency() > 20000 && numberOfSellCoins > 5)  {
            coin.setCurrency(coin.getCurrency() - (coin.getCurrency() * 1) / 100);
        }
    }
}
