package com.ncr.chess;

import org.junit.Before;
import org.junit.Test;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.MovementType;
import com.ncr.chess.Pawn;
import com.ncr.chess.PieceColor;

import static org.junit.Assert.*;

public class PawnTest {

	private ChessBoard chessBoard;
	private Pieces testSubject;
	private Pieces testSubjectWhite;

	@Before
	public void setUp() {
		this.chessBoard = new ChessBoard();
		this.testSubject = new Pawn(PieceColor.BLACK);
		this.testSubjectWhite = new Pawn(PieceColor.WHITE);
	}

	@Test
	public void testChessBoard_Add_Sets_XCoordinate() {
		this.chessBoard.addPiece(testSubject, 6, 3);
		assertEquals(6, testSubject.getxCoordinate());
	}

	@Test
	public void testChessBoard_Add_Sets_YCoordinate() {
		this.chessBoard.addPiece(testSubject, 6, 3);
		assertEquals(3, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 3);
		testSubject.move(6, 4, MovementType.MOVE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(3, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 3);
		testSubject.move(6, 2, MovementType.MOVE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(3, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
		chessBoard.addPiece(testSubject, 6, 2);
		testSubject.move(5, 2, MovementType.MOVE);
		assertEquals(5, testSubject.getxCoordinate());
		assertEquals(2, testSubject.getyCoordinate());
	}
//NEW TEST CASES

	@Test
	public void testPawn_Capture_LegalCoordinates_Right_Capture() {
		chessBoard.addPiece(testSubject, 6, 2);
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(3, 3, MovementType.MOVE);
		testSubjectWhite.move(4, 3, MovementType.MOVE);
		testSubjectWhite.move(5, 3, MovementType.MOVE);
		testSubject.move(5, 3, MovementType.CAPTURE);
		assertEquals(5, testSubject.getxCoordinate());
		assertEquals(3, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_LegalCoordinates_Left_Capture() {
		chessBoard.addPiece(testSubject, 6, 2);
		chessBoard.addPiece(testSubjectWhite, 1, 1);
		testSubjectWhite.move(3, 1, MovementType.MOVE);
		testSubjectWhite.move(4, 1, MovementType.MOVE);
		testSubjectWhite.move(5, 1, MovementType.MOVE);
		testSubject.move(5, 1, MovementType.CAPTURE);
		assertEquals(5, testSubject.getxCoordinate());
		assertEquals(1, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_LegalCoordinates_Left_Capture_ByWhite() {
		chessBoard.addPiece(testSubject, 6, 2);
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubject.move(4, 2, MovementType.MOVE);
		testSubject.move(3, 2, MovementType.MOVE);
		testSubject.move(2, 2, MovementType.MOVE);
		testSubjectWhite.move(2, 2, MovementType.CAPTURE);
		assertEquals(2, testSubjectWhite.getxCoordinate());
		assertEquals(2, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_LegalCoordinates_Right_Capture_ByWhite() {
		chessBoard.addPiece(testSubject, 6, 2);
		chessBoard.addPiece(testSubjectWhite, 1, 1);
		testSubject.move(4, 2, MovementType.MOVE);
		testSubject.move(3, 2, MovementType.MOVE);
		testSubject.move(2, 2, MovementType.MOVE);
		testSubjectWhite.move(2, 2, MovementType.CAPTURE);
		assertEquals(2, testSubjectWhite.getxCoordinate());
		assertEquals(2, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_IllegalCoordinates_Right_NotCapture() {
		chessBoard.addPiece(testSubject, 6, 2);
		Pawn testSubjectBlack = new Pawn(PieceColor.BLACK);
		chessBoard.addPiece(testSubjectBlack, 6, 3);
		testSubjectBlack.move(5, 3, MovementType.MOVE);
		testSubject.move(5, 3, MovementType.CAPTURE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(2, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_IllegalCoordinates_Left_NotCapture() {
		chessBoard.addPiece(testSubject, 6, 2);
		Pawn testSubjectBlack = new Pawn(PieceColor.BLACK);
		chessBoard.addPiece(testSubjectBlack, 6, 1);
		testSubjectBlack.move(5, 1, MovementType.MOVE);
		testSubject.move(5, 3, MovementType.CAPTURE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(2, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_IllegalCoordinates_Right_NotCapture_ByWhite() {
		chessBoard.addPiece(testSubjectWhite, 1, 2);
		Pawn testSubjectWhiteSecond = new Pawn(PieceColor.WHITE);
		chessBoard.addPiece(testSubjectWhiteSecond, 1, 3);
		testSubjectWhiteSecond.move(2, 3, MovementType.MOVE);
		testSubjectWhite.move(2, 3, MovementType.CAPTURE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(2, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Capture_IllegalCoordinates_Left_NotCapture_ByWhite() {
		chessBoard.addPiece(testSubjectWhite, 1, 2);
		Pawn testSubjectWhiteSecond = new Pawn(PieceColor.WHITE);
		chessBoard.addPiece(testSubjectWhiteSecond, 1, 1);
		testSubjectWhiteSecond.move(2, 1, MovementType.MOVE);
		testSubjectWhite.move(2, 1, MovementType.CAPTURE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(2, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Backward_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 2);
		testSubject.move(7, 2, MovementType.MOVE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(2, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 2);
		testSubject.move(8, 2, MovementType.MOVE);
		assertEquals(6, testSubject.getxCoordinate());
		assertEquals(2, testSubject.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(1, 4, MovementType.MOVE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(3, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(1, 2, MovementType.MOVE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(3, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(2, 3, MovementType.MOVE);
		assertEquals(2, testSubjectWhite.getxCoordinate());
		assertEquals(3, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Backward_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(0, 3, MovementType.MOVE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(3, testSubjectWhite.getyCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 3);
		testSubjectWhite.move(8, 3, MovementType.MOVE);
		assertEquals(1, testSubjectWhite.getxCoordinate());
		assertEquals(3, testSubjectWhite.getyCoordinate());
	}

}