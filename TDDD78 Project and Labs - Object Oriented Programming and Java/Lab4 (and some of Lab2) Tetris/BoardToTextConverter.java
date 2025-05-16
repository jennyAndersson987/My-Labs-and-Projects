package se.liu.jeand987.tetris;

public class BoardToTextConverter
{
    public String convertToText(Board board){
	StringBuilder builder = new StringBuilder();
	for (int y = 0; y < board.getHeight(); y++) {
	    for (int x = 0; x < board.getWidth(); x++) {
		SquareType currentSquare = board.getVisibleSquareAt(x,y);

		switch(currentSquare){
		    case I -> builder.append("I");
		    case J -> builder.append("J");
		    case L ->  builder.append("L");
		    case O ->  builder.append("O");
		    case S ->  builder.append("S");
		    case T ->  builder.append("T");
		    case Z ->  builder.append("Z");
		    case OUTSIDE -> builder.append("OUT");
		    default -> builder.append(" ");
		}

	    }
	    builder.append("\n");
	}
	return builder.toString();
    }
}
