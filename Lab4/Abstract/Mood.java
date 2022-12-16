package Abstract;

public enum Mood {
    Neutral("нейтральным"),
    Happy("весёлым"),
    Dreamy("задумчивым"),
    Lively("заводным"),
    Worry("волнующимся"),
    Silent("молчаливым");

    private final String mood;

    Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return this.mood;
    }
}
