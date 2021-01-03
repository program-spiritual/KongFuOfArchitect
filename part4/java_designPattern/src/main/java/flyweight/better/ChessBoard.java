package flyweight.better;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieceMap = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieceMap.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieceMap.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
