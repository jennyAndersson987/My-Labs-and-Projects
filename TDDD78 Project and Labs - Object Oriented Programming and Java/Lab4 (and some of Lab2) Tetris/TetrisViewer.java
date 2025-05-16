package se.liu.jeand987.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class TetrisViewer
{
    private Board board = null;
    private Direction direction;

    public TetrisViewer(Board board) {
	this.board = board;

    }
    public void show(){
	JFrame frame = new JFrame("Tetris");
	TetrisComponent component = new TetrisComponent(board);
	KeyHandler keyHandler = new KeyHandler(frame, direction, board);



	frame.setLayout(new BorderLayout());
	frame.add(component, BorderLayout.CENTER);


	frame.pack();
	frame.setVisible(true);

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		if(!board.isGameOver()){
		    board.tick();
		}
	    }
	};

	final Timer clockTimer = new Timer(200, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }
}
