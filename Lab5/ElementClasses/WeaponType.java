package ElementClasses;

public enum WeaponType {
    AXE(1,"AXE"),
    RIFLE(30,"RIFLE"),
    MACHINE_GUN(100,"MACHINE_GUN");
    public final int damage;
    public final String name;
    WeaponType(int i,String s) {
        this.damage = i;
        this.name = s;
    }
    public String toString(){
        return this.name;
    }

}