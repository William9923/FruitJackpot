import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Init Dependencies
        Player player = new Player(50);
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(Fruit.YELLOW);
        fruits.add(Fruit.GREEN);
        fruits.add(Fruit.WHITE);
        fruits.add(Fruit.BLACK);

        Scanner sc = new Scanner(System.in);

        // Init the game configuration
        int numOfSlots = 4;
        int cost = 10;
        int initialMoney = 50;

        SpinWheel spinner = new SpinWheel(numOfSlots, fruits, cost, initialMoney);

        // Make prize list...
        Prize jackpotPrize = new JackPotPrize(spinner, player);
        Prize flushJackpotPrize = new FlushJackPotPrize(spinner, player);
        List<Prize> prizes = new ArrayList<Prize>();
        prizes.add(jackpotPrize);
        prizes.add(flushJackpotPrize);
        // Build Game
        Game game = new Game(
                player,
                spinner,
                prizes);

        // Run the game
        game.run(sc);
    }
}
