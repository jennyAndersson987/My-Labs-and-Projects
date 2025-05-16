package se.liu.jeand987.tetris;


public class TetrominoMaker {

    public int getNumberOfTypes() {
	return SquareType.values().length -2;
    }

    public Poly getPoly(int n) {
	SquareType[][] polySquares = new SquareType[2][2];

	switch (n) {
	    case 0:
		SquareType[][] squaresI = 	{
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY },
			{ SquareType.I, SquareType.I, SquareType.I, SquareType.I },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }
		};

		Poly polyI = new Poly(squaresI);
		return polyI;

	    case 1:
		SquareType[][] squaresJ = 	{
			{ SquareType.J, SquareType.EMPTY, SquareType.EMPTY },
			{ SquareType.J, SquareType.J, SquareType.J },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }
		};

		Poly polyJ = new Poly(squaresJ);
		return polyJ;

	    case 2:
		SquareType[][] squaresL = 	{
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.L },
			{ SquareType.L, SquareType.L, SquareType.L },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }
		};
		Poly polyL = new Poly(squaresL);
		return polyL;

	    case 3:
		SquareType[][] squaresO = 	{
			{ SquareType.O, SquareType.O },
			{ SquareType.O, SquareType.O }
		};

		Poly polyO = new Poly(squaresO);
		return polyO;

	    case 4:
		SquareType[][] squaresS = 	{
			{ SquareType.S, SquareType.EMPTY, SquareType.EMPTY },
			{ SquareType.S, SquareType.S, SquareType.EMPTY },
			{ SquareType.EMPTY, SquareType.S, SquareType.EMPTY }
		};

		Poly polyS = new Poly(squaresS);
		return polyS;

	    case 5:
		SquareType[][] squaresT = 	{
			{ SquareType.EMPTY, SquareType.T, SquareType.EMPTY },
			{ SquareType.T, SquareType.T, SquareType.T },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }
		};

		Poly polyT = new Poly(squaresT);
		return polyT;

	    case 6:
		SquareType[][] squaresZ = 	{
			{ SquareType.Z, SquareType.Z, SquareType.EMPTY },
			{ SquareType.EMPTY, SquareType.Z, SquareType.Z },
			{ SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }
		};

		Poly polyZ = new Poly(squaresZ);
		return polyZ;

	    default:
		throw new IllegalArgumentException("Invalid index: " + n);

	}
    }

}
