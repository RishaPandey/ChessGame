package com.ncr.chess;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.Pawn;
import com.ncr.chess.PieceColor;

public class ChessBoardTest extends TestCase {

	private ChessBoard testSubject;

	@Before
	public void setUp() throws Exception {
		testSubject = new ChessBoard();
	}

	@Test
	public void testHas_MaxBoardWidth_of_7() {
		assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
	}

	@Test
	public void testHas_MaxBoardHeight_of_7() {
		assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
	}

	@Test
	public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(0, 0);
		assertTrue(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(5, 5);
		Assert.assertTrue(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(11, 5);
		// changes from assertTrue to assertFalse
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(0, 9);
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(11, 0);
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(5, -1);
		Assert.assertFalse(isValidPosition);
	}

	@Test
	public void testAvoids_Duplicate_Positioning() {
		Pawn firstPawn = new Pawn(PieceColor.BLACK);
		Pawn secondPawn = new Pawn(PieceColor.BLACK);
		testSubject.addPiece(firstPawn, 6, 3);
		testSubject.addPiece(secondPawn, 6, 3);
		assertEquals(6, firstPawn.getxCoordinate());
		assertEquals(3, firstPawn.getyCoordinate());
		assertEquals(-1, secondPawn.getxCoordinate());
		assertEquals(-1, secondPawn.getyCoordinate());
	}

	@Test
	public void testLimits_The_Number_Of_Pawns() {
		for (int i = 0; i < 10; i++) {
			Pawn pawn = new Pawn(PieceColor.BLACK);
			int row = i / ChessBoard.MAX_BOARD_WIDTH;
			testSubject.addPiece(pawn, 6 + row, i % ChessBoard.MAX_BOARD_WIDTH);
			if (row < 1) {
				assertEquals(6 + row, pawn.getxCoordinate());
				assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getyCoordinate());
			} else {
				assertEquals(-1, pawn.getxCoordinate());
				Assert.assertEquals(-1, pawn.getyCoordinate());
			}
		}
	}

	/// NEW TEST CASES

	@Test
	public void testAvoids_IrrelevantAddition() {
		Pawn firstPawn = new Pawn(PieceColor.BLACK);
		Pawn secondPawn = new Pawn(PieceColor.WHITE);
		testSubject.addPiece(firstPawn, 7, 3);
		testSubject.addPiece(secondPawn, 0, 3);
		assertEquals(-1, firstPawn.getxCoordinate());
		assertEquals(-1, firstPawn.getyCoordinate());
		assertEquals(-1, secondPawn.getxCoordinate());
		assertEquals(-1, secondPawn.getyCoordinate());
	}
}