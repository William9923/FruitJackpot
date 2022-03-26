import java.util.List;
import java.util.Scanner;

public class Game {

    private Player player;
    private SpinWheel spinner;
    private List<Prize> prizes;

    public Game(Player player, SpinWheel spinner, List<Prize> prizes) {
        this.player = player;
        this.spinner = spinner;
        this.prizes = prizes;
    }

    public void run(Scanner scanner) {
        boolean cont = true;
        System.out.println("Welcome to the world of Healthy Fruit Jackpot!");

        while (this.canSpin() && cont) {
            System.out.println(this.spinner);
            this.spin();

            Fruit[] results = this.spinner.getResult();
            System.out.println("Spin Results!");
            System.out.println(results);
            // Print the name from the list....
            for(Fruit fruit : results) {
                System.out.print(fruit.toString() + " | ");
            }

            System.out.println("Checking Prize...");
            this.checkPrize();
            System.out.println(this.player);
            System.out.println("Continue? [y|n] ...");
            boolean askUserInput = true;
            while (askUserInput) {
                char command = scanner.nextLine().charAt(0);
                switch (command) {
                    case 'y':
                        askUserInput = false;
                        cont = true;
                        break;
                    case 'n':
                        askUserInput = false;
                        cont = false;
                        break;
                }
            }
            this.reset();
        }
        System.out.println("Game Over!");
    }

    private void checkPrize() {
        prizes.forEach(
                (prize) -> {
                    if (prize.check()) {
                        System.out.println(prize);
                        prize.givePrize();
                    }
                });
    }

    private void reset() {
        this.spinner.reset();
    }

    private boolean canSpin() {
        int cost = this.spinner.getCost();
        return this.player.getCoupon() > 0 || this.player.getBalance() >= cost;
    }

    private void spin() {
        if (this.player.useCoupon()) {
            return;
        }

        int cost = this.spinner.getCost();
        this.player.spend(cost);
        this.spinner.spin();
    }
}
