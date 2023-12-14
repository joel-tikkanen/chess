import chess.Board;
import chess.Flag;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();

        // Fool's Mate
        board.makeMove("e2e4", Flag.PP);
        board.makeMove("g7g5", Flag.PP);
        board.makeMove("b1c3", Flag.QUIET);
        board.makeMove("f7f5", Flag.PP);
        board.makeMove("d1h5", Flag.QUIET);

        System.out.println(board);

        System.out.println(board.getLegalMoves().size());

    }

    

}
