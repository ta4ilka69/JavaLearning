package ElementClasses;

/**
 * Enum for type of weapon. String as name and int as damage.
 */
public enum WeaponType {
    /**
     * The best solution for begginer survivalist.
     */
    AXE(1, "AXE"),
    /**
     * Old but proven AK-47.
     */
    RIFLE(30, "RIFLE"),
    /**
     *The very thing for the most repulsed killers.
     */
    MACHINE_GUN(100, "MACHINE_GUN");
    /**
     * Damage. Nothing to say here.
     */
    public final int damage;
    /**
     * Not so important when damage is high.
     */
    public final String name;

    /**
     * Sets new weapon type.
     * @param i as damage.
     * @param s as weapon name.
     */
    WeaponType(int i, String s) {
        this.damage = i;
        this.name = s;
    }

    /**
     * @return name of type.
     */
    public String toString() {
        return this.name;
    }

}