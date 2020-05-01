package sample;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Board {

    private int[][] board_matrix;
    private int board_size;
    private int win_length;

    public Board(int board_size, int win_length) {
        this.board_matrix = new int[board_size][board_size];
        this.board_size = board_size;
        this.win_length = win_length;

        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                this.board_matrix[i][j] = 0;
            }
        }
    }

    private final int BOARD_SIZE = 15;

    public Parent createBoard() {
        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(755, 755);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {

                Rectangle tile = new Rectangle(50, 50);
                tile.setFill(Color.BURLYWOOD);
                tile.setStroke(Color.BLACK);

                Text text = new Text();
                text.setFont(Font.font(40));


                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);

                gameBoard.getChildren().addAll(tile, text);
            }
        }
        return gameBoard;
    }

    /*public Board checkNeighbourhood(int thisPosX, int thisPosY) {

        int startPosX = (thisPosX - 1 < MIN_X) ? thisPosX : thisPosX-1;
        int startPosY = (thisPosY - 1 < MIN_Y) ? thisPosY : thisPosY-1;
        int endPosX =   (thisPosX + 1 > MAX_X) ? thisPosX : thisPosX+1;
        int endPosY =   (thisPosY + 1 > MAX_Y) ? thisPosY : thisPosY+1;


        // See how many are alive
        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                // All the neighbors will be grid[rowNum][colNum]
            }
        }

        return grid[rowNum][colNum];
    }*/

}
