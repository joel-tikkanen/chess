import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import chess.Board;
import chess.Move;

public class MoveGenerationTest {

    Board board = new Board("8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 1 0");

    public long MoveGeneration(int depth) {
        if (depth == 0) {
            return 1;
        }
        long k = 0;
        for (Move move : board.getLegalMoves()) {
            board.makeMove(move);
            k += MoveGeneration(depth - 1);
            board.unmakeMove();            
        }
       
        return k;
    }


    public void peft(int depth){
        Map<String, Long> movesPerft = new HashMap<>();

        for (Move move : board.getLegalMoves()) {
            board.makeMove(move);
            long nodes = MoveGeneration(depth - 1);
            movesPerft.put(move.toString(), nodes);
            board.unmakeMove();
        }

        for (Map.Entry<String, Long> entry : movesPerft.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        long totalNodes = movesPerft.values().stream().mapToLong(Long::longValue).sum();
        System.out.println("\nTotal nodes: " + totalNodes);
    }

    /*
     * Positions and results from here: https://www.chessprogramming.org/Perft_Results
    */

    /*
     * Takes up to 10 minutes :D
     */
    @Test
    public void moveGenerationTest1() {
        board.setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        long movesD1 = MoveGeneration(1);
        assertEquals(20, movesD1);
        long movesD3 = MoveGeneration(3);
        assertEquals(8902, movesD3);
        long movesD4 = MoveGeneration(4);
        assertEquals(197281, movesD4);
        long movesD7 = MoveGeneration(7);
        assertEquals(3195901860L, movesD7);
    }


    // Position 2
    @Test
    public void moveGenerationTest2(){
        board.setFen("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 0");
        long movesD1 = MoveGeneration(1);
        assertEquals(48, movesD1);
        long movesD3 = MoveGeneration(3);
        assertEquals(97862, movesD3);
        long movesD4 = MoveGeneration(4);
        assertEquals(4085603, movesD4);
    }

    // Position 6
    @Test
    public void moveGenerationTest3(){
        board.setFen("r4rk1/1pp1qppp/p1np1n2/2b1p1B1/2B1P1b1/P1NP1N2/1PP1QPPP/R4RK1 w - - 0 10");
        long movesD1 = MoveGeneration(1);
        assertEquals(46, movesD1);
        long movesD3 = MoveGeneration(3);
        assertEquals(89890, movesD3);
        long movesD4 = MoveGeneration(4);
        assertEquals(3894594, movesD4);
    }

    @Test
    public void moveGenerationTest4(){
        board.setFen("8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 1 0");
        long movesD1 = MoveGeneration(1);
        assertEquals(14, movesD1);
        long movesD3 = MoveGeneration(3);
        assertEquals(2812, movesD3);
        long movesD4 = MoveGeneration(4);
        assertEquals(43238, movesD4);
        long movesD5 = MoveGeneration(5);
        assertEquals(674624, movesD5); // doesnt pass
    }




}
