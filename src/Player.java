public class Player {

    private int balance;
    private int coupon;

    public Player(int initialBalance) {
        this.balance = initialBalance;
        this.coupon = 0;
    }

    public boolean spend(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void addBalance(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public int getCoupon() {
        return this.coupon;
    }

    public boolean useCoupon() {
        if (this.coupon > 0) {
            this.coupon--;
            return true;
        }
        return false;
    }

    public void addCoupon(int amount) {
        if (amount > 0) {
            this.coupon += amount;
        }
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        return String.join(newLine,
                "Player Stats",
                String.format("Coupon: %d", this.coupon),
                String.format("Money: %d", this.balance));
    }

}
