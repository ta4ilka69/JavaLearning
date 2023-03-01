package ElementClasses;

public enum WeaponType {
    AXE(1),
    RIFLE(30),
    MACHINE_GUN(100);
    public final int damage;
    WeaponType(int i) {
        this.damage = i;
    }
}