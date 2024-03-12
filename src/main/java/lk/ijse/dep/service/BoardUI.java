package lk.ijse.dep.service;

public interface BoardUI {
    default void update(int col, boolean isHuman){

    }
    default void notifyWinner(Winner winner){

    }

}
