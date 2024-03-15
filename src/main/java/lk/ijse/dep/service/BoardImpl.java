package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUI;
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY){
                    return  i;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean existLegalMove() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY){
                    return  true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        pieces[col][findNextAvailableSpot(col)] = move;
        if (pieces[col][findNextAvailableSpot(col)] == Piece.EMPTY){
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY){
                        break;
                    }
                }

            }
        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (pieces[i][1].equals(Piece.BLUE)){
                    if ((pieces[i][1].equals(pieces[i][2])) && (pieces[i][2].equals(pieces[i][3])) && (pieces[i][0].equals(pieces[i][1]))){
                        return new Winner(Piece.BLUE,i,0,i,3);
                    }else if ((pieces[i][1].equals(pieces[i][2])) && (pieces[i][2].equals(pieces[i][3])) && (pieces[i][3].equals(pieces[i][4]))){
                        return new Winner(Piece.BLUE,i,0,i,4);
                    }
                }
                    if (pieces[i][1].equals(Piece.GREEN)){
                        if ((pieces[i][1].equals(pieces[i][2])) && (pieces[i][2].equals(pieces[i][3])) && (pieces[i][0].equals(pieces[i][1]))){
                            return new Winner(Piece.GREEN,i,0,i,3);
                        }else if ((pieces[i][1].equals(pieces[i][2])) && (pieces[i][2].equals(pieces[i][3])) && (pieces[i][3].equals(pieces[i][4]))){
                            return new Winner(Piece.GREEN,i,0,i,4);
                        }
                    }
                    if (pieces[2][j].equals(Piece.BLUE)){
                        if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[1][j].equals(pieces[2][j])) && (pieces[0][j].equals(pieces[1][j]))){
                            return new Winner(Piece.BLUE,2,j,1,j);
                        }else if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[1][j].equals(pieces[2][j])) && (pieces[4][j].equals(pieces[3][j]))){
                            return new Winner(Piece.BLUE,2,j,4,j);
                        }else if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[4][j].equals(pieces[3][j])) && (pieces[5][j].equals(pieces[4][j]))){
                            return new Winner(Piece.BLUE,2,j,5,j);
                        }
                    }
                if (pieces[2][j].equals(Piece.GREEN)){
                    if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[1][j].equals(pieces[2][j])) && (pieces[0][j].equals(pieces[1][j]))){
                        return new Winner(Piece.GREEN,2,j,1,j);
                    }else if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[1][j].equals(pieces[2][j])) && (pieces[4][j].equals(pieces[3][j]))){
                        return new Winner(Piece.GREEN,2,j,4,j);
                    }else if ((pieces[2][j].equals(pieces[3][j])) &&(pieces[4][j].equals(pieces[3][j])) && (pieces[5][j].equals(pieces[4][j]))){
                        return new Winner(Piece.GREEN,2,j,5,j);
                    }
                }
            }

        }
        return new Winner(Piece.EMPTY);
    }
}
