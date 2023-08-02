package com.xoff.ia.chess;

import com.xoff.ia.common.AlphaBeta;
import com.xoff.ia.common.Eval;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessAlphaBetaTest {
    @Test
    @DisplayName("basic test AlphaBeta")
    public void testAlphaBeta() {
        GameStateChess gameStateChess = GameStateChessBuilder.build3Moves();
        long start = System.currentTimeMillis();

        Eval e = AlphaBeta.alphabeta(gameStateChess, 4, true, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("elasped time " + timeElapsed / 1000.); // 0.06ss
        assertEquals(0.0, e.getScore(), 0.0f);
    }

    @Test
    @DisplayName("basic test testGameAB")
    public void testGameAB() {
        GameStateChess gameStateChess = new GameStateChess();
        for (int i = 0; i < 10; i++) {
            Eval e = AlphaBeta.alphabeta(gameStateChess, 4, true, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);

            System.out.println(i + " eval " + e);
            gameStateChess = gameStateChess.play(e.getBestMove());

        }
        System.out.println(gameStateChess.toString());
    }
}
