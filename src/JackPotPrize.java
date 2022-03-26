public class JackPotPrize implements Prize {

    private SpinWheel spinner;
    private Player player;

    public JackPotPrize(SpinWheel spinner, Player player) {
        this.player = player;
        this.spinner = spinner;
    }

    @Override
    public void givePrize() {
        int money = this.spinner.resetMoney();
        this.player.addBalance(money);
    }

    @Override
    public boolean check() {
        Fruit[] result = this.spinner.getResult();

        if (result.length <= 0) {
            return false;
        }

        Fruit firstSlot = result[0];
        if (firstSlot == null) {
            return false;
        }

        for (int i = 1; i < result.length; i++) {
            if (firstSlot != result[i]) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return "JackPot!";
    }

}
