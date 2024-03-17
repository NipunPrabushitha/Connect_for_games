package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece [][]pieces ;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }


    @Override
    public BoardUI getBoardUI() {

        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if (findNextAvailableSpot(col) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        for(int i = 0; i < NUM_OF_COLS;i++){
            for(int j = 0; j < NUM_OF_ROWS;j++){
                if(pieces[i][j] == Piece.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                pieces[col][i] = move;
                break;
            }
        }
    }

    @Override
    public Winner findWinner() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (pieces[i][1] == Piece.BLUE) {

                    if (((pieces[i][1] == pieces[i][2]) && (pieces[i][3] == pieces[i][2])) && (pieces[i][1] == pieces[i][0])) {
                        return (new Winner(Piece.BLUE, i, 0, i, 3));
                    } else if (((pieces[i][1] == pieces[i][2]) && (pieces[i][3] == pieces[i][2])) && (pieces[i][1] == pieces[i][4])) {
                        return new Winner(Piece.BLUE, i, 1, i, 4);
                    }

                }

                if (pieces[i][1] == Piece.GREEN) {

                    if (((pieces[i][1] == pieces[i][2]) && (pieces[i][3] == pieces[i][2])) && (pieces[i][1] == pieces[i][0])) {
                        return new Winner(Piece.GREEN, i, 0, i, 3);
                    } else if (((pieces[i][1] == pieces[i][2]) && (pieces[i][3] == pieces[i][2])) && (pieces[i][1] == pieces[i][4])) {
                        return new Winner(Piece.GREEN, i, 1, i, 4);
                    }

                }

                if (pieces[2][j] == Piece.BLUE) {

                    if (((pieces[2][j] == pieces[3][j]) && (pieces[2][j] == pieces[1][j])) && (pieces[1][j] == pieces[0][j])) {
                        return new Winner(Piece.BLUE, 0, j, 3, j);
                    } else if (((pieces[2][j] == pieces[3][j]) && (pieces[3][j] == pieces[4][j])) && (pieces[2][j] == pieces[1][j])) {
                        return new Winner(Piece.BLUE, 1, j, 4, j);
                    } else if (((pieces[2][j] == pieces[3][j]) && (pieces[3][j] == pieces[4][j])) && (pieces[4][j] == pieces[5][j])) {
                        return new Winner(Piece.BLUE, 2, j, 5, j);
                    }
                }
                if (pieces[2][j] == Piece.GREEN) {

                    if (((pieces[2][j] == pieces[3][j]) && (pieces[2][j] == pieces[1][j])) && (pieces[1][j] == pieces[0][j])) {
                        return new Winner(Piece.GREEN, 0, j, 3, j);
                    } else if (((pieces[2][j] == pieces[3][j]) && (pieces[3][j] == pieces[4][j])) && (pieces[2][j] == pieces[1][j])) {
                        return new Winner(Piece.GREEN, 1, j, 4, j);
                    } else if (((pieces[2][j] == pieces[3][j]) && (pieces[3][j] == pieces[4][j])) && (pieces[4][j] == pieces[5][j])) {
                        return new Winner(Piece.GREEN, 2, j, 5, j);
                    }
                }
            }
        }
        return new Winner(Piece.EMPTY);
    }


    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }
}