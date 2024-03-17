package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {

        do {
            col = (int) (Math.random() * 6);


        } while (!board.isLegalMove(col));

        if (board.isLegalMove(col)) {
            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, false);

            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
                if (!board.existLegalMoves()) {
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            } else {
                board.getBoardUI().notifyWinner(board.findWinner());
            }
        }

      /* if (board.isLegalMove(col)){
            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, true);

            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)){
                if (!board.existLegalMoves()){
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }else {
                board.getBoardUI().notifyWinner(board.findWinner());
            }
        }
    }*/
    }
}