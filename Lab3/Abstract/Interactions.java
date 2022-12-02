package Abstract;

public interface Interactions {
    default void Interact(){
        System.out.println("Что-то взаимодействует с чем-то");
    }
}
