import chess.Board;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board("rnbq1k1r/pp1Pbppp/2p5/8/2B5/8/PPP1NnPP/RNBQK2R w KQ - 1 8");
        board.setFen("8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 1 0");
        MoveGenerationTest mgt = new MoveGenerationTest();

        mgt.moveGenerationTest4();
        
    }

    

}
