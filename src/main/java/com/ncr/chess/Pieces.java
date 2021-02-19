package com.ncr.chess;

/**
 * This class is a parent for all chess elements.
 *
 * @author RishaPandey
 */
public abstract class Pieces extends Coordinate {

	PieceColor pieceColor;
	PieceName pieceName;

	public Pieces(int x, int y, PieceColor pieceColor, PieceName pieceName) {
		super(x, y);
		this.pieceColor = pieceColor;
		this.pieceName = pieceName;
	}

	public PieceColor getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	public PieceName getPieceName() {
		return pieceName;
	}

	public void setPieceName(PieceName pieceName) {
		this.pieceName = pieceName;
	}

	public abstract void move(int x, int y, MovementType movementType);

}
