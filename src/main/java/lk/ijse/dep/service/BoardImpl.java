package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

public class BoardImpl implements Board {
    private final Piece[][] piece;
    private final BoardUI boardUI;
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        piece = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public int findNextAvailableSpot() {
        return 0;
    }

    @Override
    public int isLegalMove(int col) {
        return 0;
    }

    @Override
    public boolean existLegalMove() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }
}
