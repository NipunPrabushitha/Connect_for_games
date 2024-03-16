package lk.ijse.dep.service;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.Player;

public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        super();
    }

    public AiPlayer() {
        super();
    }

    @Override
    public void movePiece(int col){
        if (board.isLegalMove(col)){
            board.updateMove(col,Piece.GREEN);
            board.getBoardUI().update(col,true);
            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)){
                if(board.existLegalMove()){
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }else {
                board.getBoardUI().notifyWinner(board.findWinner());
            }
        }
    }
}