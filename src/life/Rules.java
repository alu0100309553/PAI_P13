/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 13
 * Class/Program: Life Game
 * File: Rules.java
 * Description: This is a program that simulates the Life Game.
 * @author Rubén Labrador Páez
 * @version 1.0.0 14/05/2016
 **/

package life;

public class Rules {
  
  // Method to count live cells around the object and modify the state
  void lookAhead(Board universe, Cell cell) {
    int live = 0;
    
    // Cells count
    if (cell.posX == 0) {
      if (cell.posY == 0) {                                               //x = 0, y = 0
        if (universe.cells[cell.posX][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY + 1].getState())
          live ++;
      }
      else {                                                              //x = 0, y > 0
        if (universe.cells[cell.posX][cell.posY - 1].getState())
          live ++;
        if (universe.cells[cell.posX][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY - 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY + 1].getState())
          live ++;
      }
    }
    else {
      if (cell.posY == 0) {                                               //x > 0, y = 0
        if (universe.cells[cell.posX - 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX - 1][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY + 1].getState())
          live ++;
      }
      else {                                                              //x > 0, y > 0
        if (universe.cells[cell.posX - 1][cell.posY - 1].getState())
          live ++;
        if (universe.cells[cell.posX - 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX - 1][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX][cell.posY - 1].getState())
          live ++;
        if (universe.cells[cell.posX][cell.posY + 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY - 1].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY].getState())
          live ++;
        if (universe.cells[cell.posX + 1][cell.posY + 1].getState())
          live ++;
      }
    }
    

    
    if (cell.getState()) {  // if cell is alive
      underPop(live, cell);
      normalPop(live, cell);
      overPop(live, cell);
    }
    else {                  // if cell is die
      reproduction(live, cell);
    }
  }
  
  void underPop(int live, Cell cell) {      //Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    if (live < 2) {
      cell.setNextState(false);
    }
  }
  
  void normalPop(int live, Cell cell) {     //Any live cell with two or three live neighbours lives on to the next generation.
    if (live == 2 || live == 3) {
      cell.setNextState(true);
    }
  }
  
  void overPop(int live, Cell cell) {       //Any live cell with more than three live neighbours dies, as if by overcrowding.
    if (live > 3) {
      cell.setNextState(false);
    }
  }
  
  void reproduction(int live, Cell cell) {  //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    if (live == 3) {
      cell.setNextState(true);
    }
  }
  
  
  
  
  
  

}