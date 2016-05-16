/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 13
 * Class/Program: Life Game
 * File: Board.java
 * Description: This is a program that simulates the Life Game.
 * @author Rubén Labrador Páez
 * @version 1.0.0 14/05/2016
 **/

package life;

public class Board {
	public Cell[][] cells;
	private int sizeX;
	private int sizeY;

	// Class constructor
	public Board(int sizeX, int sizeY) {
		cells = new Cell[sizeX][sizeY];
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				cells[x][y] = new Cell(x, y, false);
			}
		}
	}

	// Getters and setters
	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
}
