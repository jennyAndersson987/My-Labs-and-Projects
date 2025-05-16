package se.liu.jeand987.tetris;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private Point fallingPos = new Point();
    private int width;
    private int height;

    private boolean gameOver = false;
    public final static Random RND = new Random();

    private List<BoardListener> listeners = new ArrayList<>();

    private TetrominoMaker tetrominoMaker = new TetrominoMaker();
    private Poly falling = null;
    private int MARGIN;

    private int DOUBLE_MARGIN;


    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public boolean isGameOver() {
	return gameOver;
    }

    public Board(final int width, final int height) {
	this.MARGIN=2;
	this.DOUBLE_MARGIN=2*MARGIN;
	this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	this.width = width;
	this.height = height;
	int indexOffset = 1;
	for (int y = 0; y < height + DOUBLE_MARGIN; y++) {
	    for (int x = 0; x < width + DOUBLE_MARGIN; x++) {
		if((y < MARGIN || y > height + MARGIN - indexOffset) || (x < MARGIN || x > width + MARGIN - indexOffset)){
		    squares[y][x] = SquareType.OUTSIDE;
		}
		else{
		    squares[y][x] = SquareType.EMPTY;
		}
	    }
	}
    }

    public SquareType getSquareType(int x, int y) {
	return squares[y + MARGIN][x + MARGIN];
    }

    public void addBoardListener(BoardListener bl){
	listeners.add(bl);
    }

    public void notifyListeners(){
	listeners.forEach(BoardListener::boardChanged);

    }

    public void createRandomPoly(){
	int polys = tetrominoMaker.getNumberOfTypes();
	int randomInt = RND.nextInt(polys);

	Poly newPoly = tetrominoMaker.getPoly(randomInt);
	setFalling(newPoly);

    }

    public void randomSquares() {
	for (int y = 0; y < height; y++) {
	    for (int x = 0; x < width; x++) {
		int random = RND.nextInt(SquareType.values().length);
		squares[y + MARGIN][x + MARGIN] = SquareType.values()[random];
		notifyListeners();
	    }
	}
    }
    public void setFalling(Poly poly){
	falling = poly;
	int middle = ((getWidth()-1)/2 );
	fallingPos.setLocation(middle, 0);
	notifyListeners();
    }

    public void moveFalling(){
	int oldPosY = fallingPos.y;
	fallingPos.setLocation(fallingPos.x, fallingPos.y +1);

	if (hasCollision()){
	    fallingPos.setLocation(fallingPos.x, oldPosY);
	    saveFalling();
	    checkRows();
	    falling = null;
	}

	notifyListeners();
    }

    public void saveFalling(){
	int x2 = fallingPos.x + (falling.getWidth()) -1;
	int y2 = fallingPos.y + (falling.getHeight()) -1;

	for (int y = 0; y < falling.getHeight(); y++) {
	    for (int x = 0; x < falling.getWidth(); x++) {
		if(falling.getPolySquare(x,y) != SquareType.EMPTY) {
		    setSquare(x + fallingPos.x, y + fallingPos.y, falling.getPolySquare(x,y));
		}
	    }
	}
    }

    public void setSquare(int x, int y, SquareType squareType){
	squares[y + MARGIN][x + MARGIN] = squareType;
    }

    public void rotate(Direction direction){
	if(falling == null){
	    return;
	}

	Poly oldFalling = falling;

	if(direction == Direction.UP){
	    falling = falling.rotateRight();
	}

	else if(direction == Direction.DOWN){
	    falling = falling.rotateLeft();
	}

	if (hasCollision()){
	    falling = oldFalling;
	}
	notifyListeners();
    }

    public void move(Direction direction){
	int oldPosX = fallingPos.x;
	int oldPosY = fallingPos.y;

	if(direction == Direction.LEFT){
	    fallingPos.setLocation(fallingPos.x -1, fallingPos.y);
	}
	else{
	    fallingPos.setLocation(fallingPos.x +1, fallingPos.y);
	}
	if(hasCollision()){
	    fallingPos.setLocation(oldPosX, oldPosY);
	}

	notifyListeners();
    }

    public boolean hasCollision(){
	if (falling == null){
	    return false;
	}

	int x2 = fallingPos.x + (falling.getWidth());
	int y2 = fallingPos.y + (falling.getHeight());

	for (int y = fallingPos.y; y <= y2; y++) {
	    for (int x = fallingPos.x; x <= x2; x++) {
		SquareType square = falling.getPolySquare(x- fallingPos.x ,y - fallingPos.y);
		if(square == SquareType.EMPTY){
		    continue;
		}
		if (x > getWidth()-1 || y > getHeight() -1){
		    return true;
		}
		else if(getSquareType(x,y) != SquareType.EMPTY){
		    return true;
		}
	    }
	}
	return false;
    }

    public void tick(){

	if (falling == null){
	    createRandomPoly();
	    if(hasCollision()){
		gameOver = true;
	    }
	}
	else{
	    this.moveFalling();
	}
	notifyListeners();
    }

    public void checkRows(){
        for (int y = 0; y < height; y++) {
	    boolean rowFull = true;
	    for (int x = 0; x < width; x++) {
		if(getSquareType(x, y) == SquareType.EMPTY){
		    rowFull = false;

		}
	    }
	if(rowFull){
	    deleteRow(y);
	}
	}
        notifyListeners();
    }

    public void deleteRow(int row){
	for (int x = 0; x < width; x++) {
	    squares[row + MARGIN][x + MARGIN] = SquareType.EMPTY;
	}
	moveRow(row);
	notifyListeners();
    }


    public boolean isRowEmpty(int row){
	for (int x = 0; x < width; x++) {
	    if(getSquareType(x, row) != SquareType.EMPTY){
	        return false;
	    }
	}
	System.out.println("raden var tom!");
	return true;

    }

    public void moveRow(int deletedRow){
	for (int y = deletedRow; y > 0; y--) {
	    for (int x = 0; x < width; x++) {
		squares[y + MARGIN][x + MARGIN] = squares[y - 1 + MARGIN][x + MARGIN];
	    }
	}

	// Clear the top row to ensure there are no leftover squares
	for (int x = 0; x < width; x++) {
	    squares[0 + MARGIN][x + MARGIN] = SquareType.EMPTY;
	}
    }


    public SquareType getVisibleSquareAt(int x, int y) {
	if(falling == null){
	    return getSquareType(x,y);
	}

	int fallingX = (int) fallingPos.getX();
	int fallingY = (int) fallingPos.getY();

	int x2 = fallingX + (falling.getWidth()) -1;
	int y2 = fallingY + (falling.getHeight()) -1;

	if ((x < fallingX || x > x2) || (y < fallingY || y > y2)){
	    return getSquareType(x,y);
	}
	else if(falling.getPolySquare( x -fallingX, y -fallingY) == SquareType.EMPTY){
	    return getSquareType(x,y);
	}
	else{
	    return falling.getPolySquare(x-fallingX,y-fallingY);
	}

    }
}