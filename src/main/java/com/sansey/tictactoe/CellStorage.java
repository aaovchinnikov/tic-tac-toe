package com.sansey.tictactoe;

/**
 * Represents a storing backend for {@link Field} 
 * @author Alexander Ovchinnikov
 *
 */
public interface CellStorage {
  CellMatrix matrix(); 
  CellStorage withFigureAt(int row, int column, CellFigure figure); 
}
