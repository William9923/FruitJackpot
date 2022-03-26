import java.util.HashSet;
import java.util.Set;

public class FlushJackPotPrize implements Prize {

    private SpinWheel spinner;
    private Player player;

    public FlushJackPotPrize(SpinWheel spinner, Player player) {
        this.player = player;
        this.spinner = spinner;
    }

    @Override
    public void givePrize() {
        int money = this.spinner.resetMoney();
        int cost = this.spinner.getCost();

        // check money
        int coupon, amount;
        boolean isEnough = 5*cost <= money; 
        if (isEnough) {
            coupon = 0;
            amount = 5*cost;
        } else {
            amount = money;
            coupon = calculateCoupon(cost, (5*cost - money));
        }
        this.spinner.addMoney(money-amount);
        this.player.addBalance(amount);
        this.player.addCoupon(coupon);
    }

    @Override
    public boolean check() {
        Fruit[] result = this.spinner.getResult();

        if (result.length <= 0) {
            return false;
        }

        Fruit prev = result[0];
        if (prev == null) {
            return false;
        }
        Set<Fruit> set = new HashSet<Fruit>();
        set.add(prev);
        for (int i = 1; i < result.length; i++) {
            if (set.contains(result[i])) {
                return false;
            }
            set.add(result[i]);
        }

        return true;
    }

    private int calculateCoupon(int cost, int remainingMoney) {
        return (remainingMoney / cost) + 1;
    }

    public String toString() {
        return "FlushJackPot";
    }

}
