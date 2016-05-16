/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 13
 * Class/Program: Life Game
 * File: LifePanel.java
 * Description: This is a program that simulates the Life Game.
 * @author Rubén Labrador Páez
 * @version 1.0.0 14/05/2016
 **/

package life;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LifePanel extends JPanel {
	private static int CELLS = 150;
	private int xCells;
	private int yCells;
	private Board board;
	private Rules rules = new Rules();
	private int hGap;
	boolean init = false;

	// Clear panel method
	public void clear() {
		for (int y = 0; y < board.getSizeY(); y++) {
			for (int x = 0; x < board.getSizeX(); x++) {
				board.cells[x][y].setState(false);
				board.cells[x][y].setNextState(false);
			}
		}
	}
	
	// Add cell method
	public void addCell(int x, int y) {
		int posX = (int) (Math.floor(x / hGap));
		int posY = (int) (Math.floor(y / hGap));
		if (!board.cells[posX][posY].getState()) {
			board.cells[posX][posY].setState(true);
		} else {
			board.cells[posX][posY].setState(false);
		}
	}

	// Method to refresh cells states
	public void step() {
		for (int y = 0; y < yCells; y++) {
			for (int x = 0; x < xCells; x++) {
				rules.lookAhead(board, board.cells[x][y]);
			}
		}
		for (int y = 0; y < board.getSizeY(); y++) {
			for (int x = 0; x < board.getSizeX(); x++) {
				board.cells[x][y].setState(board.cells[x][y].getNextState());
			}
		}
	}

	// PaintComponent method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		boardLines(g);
		g.setColor(Color.BLACK);
		for (int x = 0; x < board.getSizeX(); x++) {
			for (int y = 0; y < board.getSizeY(); y++) {
				if (board.cells[x][y].getState()) {
					g.fillRect(x * hGap + 1, y * hGap + 1, hGap - 1, hGap - 1);
				}
			}
		}
	}

	// Method to draw board lines
	public void boardLines(Graphics g) {
	  
		hGap = getWidth() / CELLS;

		g.setColor(Color.GRAY.brighter());

		xCells = 0;
		for (int i = 0; i < getWidth(); i+=hGap) {
			g.drawLine(i, 0, i , getHeight());
			xCells++;
		}
		yCells = 0;
		for (int i = 0; i < getHeight(); i+=hGap) {
			g.drawLine(0, i , getWidth(), i );
			yCells++;
		}
		if (!init) {
			board = new Board(xCells+20, yCells+20);
			init = true;
		}
	}
}
