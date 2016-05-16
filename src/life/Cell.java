/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 13
 * Class/Program: Life Game
 * File: Cell.java
 * Description: This is a program that simulates the Life Game.
 * @author Rubén Labrador Páez
 * @version 1.0.0 14/05/2016
 **/

package life;

public class Cell {
	protected int posX;
	protected int posY;
	private boolean state;
	private boolean nextState;
	
	// Class Constructor
	public Cell(int posX, int posY, boolean state) {
		this.posX = posX;
		this.posY = posY;
		this.state = state;
	}
	
	 // Default class Constructor
	public Cell() {
		this.state = false;
	}

	// Getters and setters
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public void setNextState(boolean next) {
		this.nextState = next;
	}
	
	public boolean getNextState() {
		return this.nextState;
	}
}


