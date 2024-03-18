package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        super(newBoard);




    }

    @Override
    public void movePiece(int col) {


        int x = colChosser();
        if (x== -1){


            do {

                //  Random rand = new Random();
                //  col = rand.nextInt(6);
                int range = 6;
                col = (int)(Math.random()*range);

            }while (!board.isLegalMove(col));
        }else {

            col = x;
        }




        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        if(board.findWinner().getWinningPiece()!=(Piece.EMPTY)) {
            board.getBoardUI().notifyWinner(board.findWinner());






        }else {

            if (!board.existLegalMoves())  board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));


        }




    }

    private int colChosser() {

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.GREEN);
                if (board.findWinner().getWinningPiece() == Piece.GREEN) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);


                }



            }

        }

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.BLUE);
                if (board.findWinner().getWinningPiece() == Piece.BLUE) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);


                }



            }

        }
        return -1;
    }

}