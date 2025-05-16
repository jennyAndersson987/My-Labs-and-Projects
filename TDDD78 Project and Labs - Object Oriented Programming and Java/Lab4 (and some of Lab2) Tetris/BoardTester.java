package se.liu.jeand987.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester
{

    public static void main(String[] args) {
	Board board = new Board(10,20);
	BoardToTextConverter boardText = new BoardToTextConverter();


	TetrisViewer tetrisViewer = new TetrisViewer(board);
	tetrisViewer.show();

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		board.tick();

	    }
	};

	final Timer clockTimer = new Timer(200, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }
}
