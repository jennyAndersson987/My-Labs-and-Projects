package se.liu.jeand987.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class KeyHandler
{
    private JFrame frame;

    private Direction direction;
    private Board board;

    public KeyHandler(final JFrame frame, final Direction direction, final Board board) {
	this.frame = frame;
	this.direction = direction;
	this.board = board;

	JComponent pane = frame.getRootPane();
	final InputMap inputMap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	inputMap.put(KeyStroke.getKeyStroke("LEFT"),"LEFT");
	inputMap.put(KeyStroke.getKeyStroke("RIGHT"),"RIGHT");
	inputMap.put(KeyStroke.getKeyStroke("UP"),"UP");
	inputMap.put(KeyStroke.getKeyStroke("DOWN"),"DOWN");

	final ActionMap actionMap = pane.getActionMap();
	actionMap.put("LEFT", new MoveAction(Direction.LEFT));
	actionMap.put("RIGHT", new MoveAction(Direction.RIGHT));
	actionMap.put("UP", new MoveAction(Direction.UP));
	actionMap.put("DOWN", new MoveAction(Direction.DOWN));

    }

    private class MoveAction extends AbstractAction{
	private Direction direction;

	public MoveAction(final Direction direction)
	{
	    this.direction = direction;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    if (direction == Direction.LEFT || direction == Direction.RIGHT){
		board.move(direction);
	    }
	    if (direction == Direction.UP || direction == Direction.DOWN){
		board.rotate(direction);
	    }

	}
    }


}
