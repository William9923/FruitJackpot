import java.util.Collections;
import java.util.List;

public class SpinWheel {
    private int numOfSlots;
    private List<Fruit> fruits;
    private Fruit[] results;
    private boolean isSpinned;
    private int cost;
    private int floats;

    public SpinWheel(int numOfSlots, List<Fruit> fruits, int cost, int initialMoney) {
        this.numOfSlots = numOfSlots;
        this.fruits = fruits;
        this.results = new Fruit[numOfSlots]; // empty array as dummy obj
        this.isSpinned = false;
        this.cost = cost;
        this.floats = initialMoney;
    }

    public int getCost() {
        return this.cost;
    }

    public void spin() {
        // simulating shufle from all slots.
        for (int i=0; i < this.numOfSlots; i++) {
            Collections.shuffle(this.fruits);
            this.results[i] = this.fruits.get(this.fruits.size() - 1);
        }  
        this.isSpinned = true; 
    }

    public Fruit[] getResult() {
        if (!this.isSpinned) {
            return new Fruit[this.numOfSlots];
        }
        return this.results;
    }

    public void reset() {
        this.isSpinned = false;
        this.results = new Fruit[this.numOfSlots];
    }

    public int resetMoney() {
        int money = this.floats;
        this.floats = 0;
        return money;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            this.floats += amount;
        }
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        return String.join(newLine,
                "Spin Wheel Stats",
                String.format("Rewards Remaining: %d", this.floats),
                String.format("Slots: %d", this.numOfSlots));
    }
}
