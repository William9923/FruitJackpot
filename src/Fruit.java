public enum Fruit {
    BLACK("⚫"),
    WHITE("⚪"),
    GREEN("🟢"),
    YELLOW("🟡");

    private String value;

    private Fruit(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
