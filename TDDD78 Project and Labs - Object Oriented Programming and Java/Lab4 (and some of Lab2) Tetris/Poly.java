package se.liu.jeand987.tetris;

public class Poly {
    private SquareType[][] polySquares;

    public Poly(final SquareType[][] polySquares) {
        this.polySquares = polySquares;
    }

    public Poly rotateRight() {
        int size = getWidth();
        Poly newPoly = new Poly(new SquareType[size][size]);

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    newPoly.polySquares[c][size - 1 - r] = this.polySquares[r][c];
                }
            }
        return newPoly;
    }

    public Poly rotateLeft(){
        int size = getWidth();
        Poly newPoly = new Poly(new SquareType[size][size]);

        for (int i = 0; i <= 3; i++) {
            newPoly = rotateRight();
        }
        return newPoly;
    }



    public SquareType getPolySquare(int x, int y) {
        if(getWidth() <= x || getHeight() <= y){
            return SquareType.EMPTY;
        }

        return polySquares[y][x];
    }

    public int getHeight() {
        return polySquares.length;
    }

    public int getWidth() {
        return polySquares[0].length;
    }

    public static int randomizePoly(){
        return Board.RND.nextInt(SquareType.values().length-1) +1;
    }
}
