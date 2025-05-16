package se.liu.jeand987.tetris;

public class TestTetrisViewer {
    public static void main(String[] args) {
	Board board = new Board(6, 15);
	BoardToTextConverter text = new BoardToTextConverter();
	TetrisViewer viewer = new TetrisViewer(board);
	viewer.show();
	System.out.println(board.hasCollision());
    }
}
