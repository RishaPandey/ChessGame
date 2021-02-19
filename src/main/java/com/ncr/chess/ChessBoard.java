package com.ncr.chess;

/**
 * This class initializes and adds all the chess pieces
 *
 * @author RishaPandey
 */
public class ChessBoard {

	public static int MAX_BOARD_WIDTH = 7;
	public static int MAX_BOARD_HEIGHT = 7;

	static Pieces[][] pieces;

	public ChessBoard() {
		pieces = new Pieces[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
	}

	public static void initialize() {
		Pawn pawnWhite = new Pawn(PieceColor.WHITE);
		Pawn pawnBlack = new Pawn(PieceColor.BLACK);
		for (int i = 0; i < MAX_BOARD_WIDTH; i++) {
			addPiece(pawnWhite, 1, i);
			addPiece(pawnBlack, 6, i);
		}
	}

	/**
	 * Add new elements in chess at its correct position
	 * 
	 * @param Piece
	 * @param xCoordeinate
	 * @param yCoordinate
	 * @return
	 */
	public static void addPiece(Pieces piece, int xCoordinate, int yCoordinate) {
		boolean correctLine = checkInitialPlacement(piece, xCoordinate, yCoordinate);
		switch (piece.getPieceColor()) {
		case BLACK:
			if (correctLine && pieces[xCoordinate][yCoordinate] == null && yCoordinate < MAX_BOARD_WIDTH) {
				piece.setxCoordinate(xCoordinate);
				piece.setyCoordinate(yCoordinate);
				pieces[xCoordinate][yCoordinate] = piece;
			} else {
				piece.setxCoordinate(-1);
				piece.setyCoordinate(-1);
			}
			break;
		case WHITE:
			if (correctLine && pieces[xCoordinate][yCoordinate] == null && yCoordinate < MAX_BOARD_WIDTH) {
				piece.setxCoordinate(xCoordinate);
				piece.setyCoordinate(yCoordinate);
				pieces[xCoordinate][yCoordinate] = piece;
			} else {
				piece.setxCoordinate(-1);
				piece.setyCoordinate(-1);
			}
			break;
		}
	}

	public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
		if (xCoordinate <= MAX_BOARD_WIDTH && xCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT && yCoordinate >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Check the correct row and column for adding different chess elements
	 * 
	 * @param Piece
	 * @param xCoordeinate
	 * @param yCoordinate
	 * @return boolean
	 */
	public static boolean checkInitialPlacement(Pieces piece, int xCoordinate, int yCoordinate) {
		PieceColor pieceColor = piece.getPieceColor();
		PieceName pieceName = piece.getPieceName();
		switch (pieceName) {
		case PAWN:
			if (pieceColor == PieceColor.BLACK) {
				if (xCoordinate == 6) {
					return true;
				} else {
					return false;
				}
			} else {
				if (xCoordinate == 1) {
					return true;
				} else {
					return false;
				}
			}
		case KING:
		case QUEEN:
		case BISHOP:
		case ROOK:
		case KNIGHT:
		}
		return false;
	}
}
