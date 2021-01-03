package flyweight.basic;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private final Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(1, "車", Color.BLACK, 0, 0));
        chessPieces.put(2, new ChessPiece(2, "馬", Color.BLACK, 0, 1));
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
    }
}
