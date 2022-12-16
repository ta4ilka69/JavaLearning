package Abstract;

public interface Goal {
    default String getGoal(){
        return("Нет цели");
    }
}
