package lk.ijse.dep.service;

public class Player implements Board {
    protected Board board;

    public Player() {
    }

    public Player(Board board) {
        this.board = board;
    }


    public void movePiece(int col) {

    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }
}