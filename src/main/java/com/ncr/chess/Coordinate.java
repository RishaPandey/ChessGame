package com.ncr.chess;

/**
 * This class has uniquely identified coordinates, i.e. both xCoordinate and
 * yCoordinate are unique
 *
 * @author RishaPandey
 */
public class Coordinate {

	private int xCoordinate;
	private int yCoordinate;

	public Coordinate(int xCoordinate, int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	/**
	 * returns a distinct integer for every unique integer pair (i, j)
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	public final static int keyCode(int i, int j) {
		return (i + j) * (i + j + 1) / 2 + j;
	}

	@Override
	public synchronized boolean equals(Object o) {
		if (o instanceof Coordinate) {
			Coordinate otherCoord = (Coordinate) o;
			return getxCoordinate() == otherCoord.getxCoordinate() && getyCoordinate() == otherCoord.getyCoordinate();
		}
		return false;
	}

	@Override
	public synchronized int hashCode() {
		return keyCode(getxCoordinate(), getyCoordinate());
	}

}
