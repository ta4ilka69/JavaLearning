package Abstract;

public enum AliveType {
    MagicAlive("Неживой объект с сознанием"),
    Alive("Живой"),
    Lifeless("Неживой"),
    Substance("Субстанция");
    private final String type;

    AliveType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}