package se.liu.jeand987.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private int tileSize = 30;

    private final static EnumMap<SquareType, Color> SQUARE_COLORS = createColorMap();

    public TetrisComponent(final Board board) {
	this.board = board;
	board.addBoardListener(this);
    }
    public Dimension getPreferredSize(){
	return new Dimension(tileSize * board.getWidth(), tileSize * board.getHeight());
    }



    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;


	for (int y = 0; y<board.getHeight(); y++){
	     for (int x = 0; x < board.getWidth(); x++) {
		g2d.setColor(SQUARE_COLORS.get(board.getVisibleSquareAt(x,y)));
		g2d.fillRect(x*tileSize, y*tileSize, tileSize-1, tileSize-1);

	    }
	}
    }
    private static EnumMap<SquareType, Color> createColorMap() {
	EnumMap<SquareType, Color> squareColorMap = new EnumMap<>(SquareType.class);
	    squareColorMap.put(SquareType.EMPTY, Color.PINK);
	    squareColorMap.put(SquareType.I, Color.BLUE);
	    squareColorMap.put(SquareType.J, Color.RED);
	    squareColorMap.put(SquareType.L, Color.YELLOW);
	    squareColorMap.put(SquareType.Z, Color.GREEN);
	    squareColorMap.put(SquareType.S, Color.ORANGE);
	    squareColorMap.put(SquareType.O, Color.YELLOW);
	    squareColorMap.put(SquareType.T, Color.CYAN);

	return squareColorMap;
    }

    @Override
    public void boardChanged() {
	this.repaint();
    }
}


