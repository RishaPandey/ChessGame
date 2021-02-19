package com.ncr.chess;

import java.util.ArrayList;

/**
 * This PAWN class, used for movement/capturing of pawns in Chess Game.
 *
 * @author RishaPandey
 */
public class Pawn extends Pieces {

	private ChessBoard chessBoard;

	public Pawn(int xCoordinate, int yCoordinate, PieceColor pieceColor) {
		super(xCoordinate, yCoordinate, pieceColor, PieceName.PAWN);
	}

	public Pawn(PieceColor pieceColor) {
		super(0, 0, pieceColor, PieceName.PAWN);
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	/**
	 * Creates list of valid moves for PAWN and MOVE/CAPTURE it if possible.
	 * 
	 * @param newX
	 * @param newY
	 * @param movementType
	 * @return
	 */
	@Override
	public void move(int newX, int newY, MovementType movementType) {
		int currentX = this.getxCoordinate();
		int currentY = this.getyCoordinate();
		ArrayList<Coordinate> validCoordinates = new ArrayList<Coordinate>();
		if (movementType == MovementType.MOVE && newX <= 6 && newY <= 6) {
			switch (this.pieceColor) {
			case BLACK:
				if (currentX == 6) {
					if (chessBoard.pieces[currentX - 1][currentY] == null) {
						validCoordinates.add(new Coordinate(currentX - 1, currentY));
						if (chessBoard.pieces[currentX - 2][currentY] == null) {
							validCoordinates.add(new Coordinate(currentX - 2, currentY));
						}
					}
				} else {
					if (currentX > 0) {
						if (chessBoard.pieces[currentX - 1][currentY] == null) {
							validCoordinates.add(new Coordinate(currentX - 1, currentY));
						}
					}
				}
				break;
			case WHITE:
				if (currentX == 1) {
					if (chessBoard.pieces[currentX + 1][currentY] == null) {
						validCoordinates.add(new Coordinate(currentX + 1, currentY));
						if (chessBoard.pieces[currentX + 2][currentY] == null) {
							validCoordinates.add(new Coordinate(currentX + 2, currentY));
						}
					}
				} else {
					if (currentX < 7) {
						if (chessBoard.pieces[currentX + 1][currentY] == null) {
							validCoordinates.add(new Coordinate(currentX + 1, currentY));
						}
					}
				}
			}
		} else if (movementType == MovementType.CAPTURE && newX <= 6 && newY <= 6) {
			switch (this.pieceColor) {
			case BLACK:
				if (chessBoard.pieces[currentX - 1][currentY - 1] != null
						&& (chessBoard.pieces[currentX - 1][currentY - 1]).getPieceColor() == PieceColor.WHITE) {
					validCoordinates.add(new Coordinate(currentX - 1, currentY - 1));
				}
				if (chessBoard.pieces[currentX - 1][currentY + 1] != null
						&& (chessBoard.pieces[currentX - 1][currentY + 1]).getPieceColor() == PieceColor.WHITE) {
					validCoordinates.add(new Coordinate(currentX - 1, currentY + 1));
				}
				break;
			case WHITE:
				if (chessBoard.pieces[currentX + 1][currentY - 1] != null
						&& (chessBoard.pieces[currentX + 1][currentY - 1]).getPieceColor() == PieceColor.BLACK) {
					validCoordinates.add(new Coordinate(currentX + 1, currentY - 1));
				}
				if (chessBoard.pieces[currentX + 1][currentY + 1] != null
						&& (chessBoard.pieces[currentX + 1][currentY + 1]).getPieceColor() == PieceColor.BLACK) {
					validCoordinates.add(new Coordinate(currentX + 1, currentY + 1));
				}
			}
		}

		if (validCoordinates.contains(new Coordinate(newX, newY))) {
			this.setxCoordinate(newX);
			this.setyCoordinate(newY);
			chessBoard.pieces[newX][newY] = this;
			chessBoard.pieces[currentX][currentY] = null;
		}
	}

	@Override
	public String toString() {
		return getCurrentPositionAsString();
	}

	protected String getCurrentPositionAsString() {
		String eol = System.lineSeparator();
		return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, this.getxCoordinate(),
				this.getyCoordinate(), pieceColor);
	}
}
