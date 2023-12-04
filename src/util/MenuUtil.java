package util;
import static util.InputUtil.*;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("""
                           [1] --> Buy Coin
                           [2] --> Sell Coin
                           [3] --> See Currency
                           [4] --> See My Coins
                           [5] --> See Other Client's Coins
                           """);
        return inputRequiredInt("Choose an option: ");
    }
}
