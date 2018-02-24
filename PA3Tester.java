//------------------------------------------------------------------//
// PA3Tester.java                                                   //
//                                                                  //
// Simple Tester for students to use while doing PA3  (2048)        //
//                                                                  //
// Author:  Gustavo Umbelino, Heitor Schueroff	                    //
// Last modified by: Carlos Mattoso                                 //
// Date:    2/12/18                                                 //
//------------------------------------------------------------------//

import java.util.Arrays;
import java.util.Random;

public class PA3Tester {

    // Seed passed to random generator to match the expected output
    private static int SEED = 2017;

    // All these test boards are based off the SEED 2017
    private static int[][][] testGrid = {{
            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 0
            {0, 2, 0, 0},
            {0, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 1
            {2, 2, 0, 0},
            {0, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 2
            {2, 2, 0, 0},
            {2, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 3
            {2, 2, 0, 0},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 4
            {2, 2, 0, 2},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 2}, // Grid 5
            {2, 2, 0, 2},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 2}, // Grid 6
            {2, 2, 2, 2},
            {2, 0, 0, 2}}};

    public static void main(String[] args) throws Exception {
        System.out.println("****************** Testing PA3 *******************");

        int score = 0;
        score += testCanMove();

        System.out.println("***************************************************\n");
        if (score > 0) {
            System.out.println("*************** Passed! :D ***************");
            System.out.println(
                    "NOTE: This DOES NOT guarantee full credit in the PA!!!");
        }
        else
            System.out.println("*************** FAILED :'( ***************");


        System.out.println("\n***************************************************");
    }

    /************************ TEST CAN MOVE ************************/

    private static int testCanMove() throws Exception {
        System.out.print("Testing canMove method......................");

        try {
            Board board = new Board(new Random(SEED), new int[][]{
                    {0, 0, 0, 4},
                    {0, 0, 0, 4},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}});

            if (board.canMove(Direction.UP) && !board.canMove(Direction.RIGHT) &&
                    board.canMove(Direction.DOWN) && board.canMove(Direction.LEFT)) {
                System.out.println("Passed!");
                return 1;
            }

            System.out.println("FAILED!");
            if (!board.canMove(Direction.UP)) {
                System.out.println("Board should be able to move UP!");
            }
            if (board.canMove(Direction.RIGHT)) {
                System.out.println("Board should NOT be able to move RIGHT!");
            }
            if (!board.canMove(Direction.DOWN)) {
                System.out.println("Board should be able to move DOWN!");
            }
            if (!board.canMove(Direction.LEFT)) {
                System.out.println("Board should be able to move LEFT!");
            }

            return 0;

        } catch (Exception e) {
            System.out.println("FAILED!");
            System.out.println("Exception was thrown while trying to" +
                    "run the canMove Method");
            e.printStackTrace();
            return 0;
        }

    }

    // Creates int[][] given a board object
    private static int[][] boardToArray(Board board) {
        if (board == null) {
            return null;
        }
        int[][] array = new int[board.GRID_SIZE][board.GRID_SIZE];
        for (int r = 0; r < board.GRID_SIZE; r++) {
            for (int c = 0; c < board.GRID_SIZE; c++) {
                array[r][c] = board.getTileValue(r, c);
            }
        }
        return array;
    }

    // Prints matrix
    private static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
    }

}
