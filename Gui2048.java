/*
 * @author Abena Bonsu (and Liz Izhikevich) + adapted by Carlos Mattoso
 * @date February 12, 2018
 * File: Gui2048.java
 *
 * This program is used to construct a new GUI board game that can be
 * used in the game play of 2048.
 */

import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;


public class Gui2048 extends Application {

	// Main Instance variables
	private GridPane pane = new GridPane();
	private int GRID_SIZE = 4;
	private Label scoreNum = new Label();

	// Create myKeyHandler Object
	private MyKeyHandler keyHandler = new MyKeyHandler();

	// Create Board object
	private Board board;

	// ================================ PART 1 ==================================

	/*
	 * Name: start(Stage primaryStage)
	 * The purpose of this method is to construct the initial state of the board using GUI.
	 * This method will be called on once, and thus it only initializes the board to its beginning state.
	 * Return: void
	 */
	public void start(Stage primaryStage) {
		// Prepare the stage for our game
		setUpPane(primaryStage);


		// TODO:  1. Initialize the model of the game board - i.e.
		// call the constructor for the `board` variable
		Random r = new Random();
		board = new Board(r, GRID_SIZE);

		// TODO:  2. Update the visualization of the board - i.e.
		// call `updateBoard`
		this.updateBoard();

	}

	/*
	 * Name: updateScore(Stage primaryStage)
	 * This method will simply update the value of the scoreNum label to the value in score
	 * Return: void
	 */
	void updateScore(int score) {
		// TODO:  1. Convert `score` to a String
		String s = Integer.toString(score);

		// TODO:  2. Update the text of `scoreNum`.
		this.scoreNum.setText("Score: " + s);


	}

	/*
	 * Name: setUpPane(Stage primaryStage)
	 * The method setUpPane(Stage primaryStage) is used to set the foundation for the GUI itself.
	 * This is where elements such as the GridPane and Scene are created.
	 * Return: void
	 */
	public void setUpPane(Stage primaryStage) {
		// Set up top level pane
		BorderPane topPane = new BorderPane();

		// TODO:  1. Set up scene associated to topPane
		Scene scene = new Scene(topPane); // !! ATTN: Change this to constructor call


		// TODO:  2. Set up properties of primaryStage (window title, scene, width and height)
		primaryStage.setScene(scene);
		primaryStage.setTitle("2048");


		// TODO:  3. Add "2048" title to the header of the game
		GridPane header = new GridPane();
		header.setPadding(new Insets(20, 10, 10, 10));
		header.setAlignment(Pos.CENTER);
		header.setHgap(100);

		StackPane title_b = new StackPane();
		Rectangle title_s = new Rectangle();
		title_s.setWidth(160);
		title_s.setHeight(160);
		title_s.setArcWidth(15);
		title_s.setArcHeight(15);
		title_s.setFill(Color.rgb(237, 194, 46));

		Text title = new Text("2048");
		title.setFont(Font.font ("Verdana", 42));
		title.setFill(Color.WHITE);

		title_b.getChildren().addAll(title_s , title);
		header.add(title_b, 0, 0);
		header.add(scoreNum, 1, 0);

		scoreNum.setFont(Font.font ("Verdana", 36));
		topPane.setTop(header);


		// TODO:  4. Add score to the header of the game - i.e. place `scoreNum` there
		// Make sure to also call `updateScore(0)`
		this.updateScore(0);

		// TODO:  5. Add tiles to the visualization of the game grid
		// - i.e. `pane`, the GridPane that we use to show the board
		StackPane panel = new StackPane();
		Rectangle bg = new Rectangle();
		bg.setHeight(550);
		bg.setWidth(550);
		bg.setArcHeight(30);
		bg.setArcWidth(30);
		bg.setFill(Color.rgb(187, 173, 160));
		panel.getChildren().add(bg);

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setPadding(new Insets(20, 20, 20, 20));
		panel.getChildren().add(pane);
		topPane.setCenter(panel);

		// TODO:  6. Call for key actions --
		// !! ATTN:	Uncomment the following line after you set up `scene` in step 1 above:
		scene.setOnKeyPressed(keyHandler);


		/* No need to change the following code */
		GridPane b = new GridPane();
		Button btn = createUndoButton(topPane);
		Button reset = restButton(topPane);

		b.add(btn,0,0);
		b.add(reset,1,0);
		b.setAlignment(Pos.CENTER);
		b.setHgap(25);
		b.setPadding(new Insets(20, 20, 20, 20));

		topPane.setBottom(b);

		// Display stage
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(680);
		primaryStage.setWidth(800);
		primaryStage.setHeight(900);
		primaryStage.setMaxWidth(1200);
		primaryStage.setMaxHeight(1200);
		primaryStage.show();
	}

	// ============================= End of PART 1 ==============================

	// 																	(ノ^o^)ノ

	// Go to Part 2 first. It's in GameTile.java


	// ================================ PART 3 ==================================

	/*
	 * Name: updateBoard()
	 *
	 * TODO: COMPLETE THIS METHOD (AND HEADER)
	 *
	 */
	private void updateBoard() {
		// TODO:  1. Update the score label i.e. make a call to updateScore
		// To get the current score call `getScore()` on the `board`.
		int s = board.getScore();
		this.updateScore(s);

		// TODO:  2. Get rid of all of the current game tiles to make new ones
		//this.pane.getChildren().clear();
		// TODO:  2. Get rid of all of the current game tiles to make new ones
		pane.getChildren().clear();


		// TODO:  3. Update board by reinitializing it to the grid
		for(int i = 0; i < GRID_SIZE; i++){
			for(int j = 0; j < GRID_SIZE; j++){
				int value = board.getTileValue(i,j);
				GameTile g = new GameTile(value);
				pane.add(g, j, i);
			}
		}

	}

	// ============================= End of PART 3 ==============================

	// Almost done. You'll find Part 4 in Board.java: finish all the canMove methods.
	//
	//																〈( ^.^)ノ



	// ================================ PART 5 ==================================

	/*
	 * Name: createUndoButton()
	 *
	 * TODO: COMPLETE THIS METHOD (AND HEADER)
	 *
	 */
	Button createUndoButton(BorderPane topPane) {
		Button btn = new Button();

		// TODO:  1. Make the button text be "Undo!"
		btn.setText("Undo!");

		// TODO:  2. Place button at the bottom of `topPane`


		// TODO:  3. Add action handler for the button which calls `board.undo()`.
		// Don't forget to call `updateBoard` after calling `board.undo()`
		//   in the action handler...
		btn.setOnAction((event) -> {
    board.undo();
		this.updateBoard();

		});


		return btn;
	}

	//Extra
	Button restButton(BorderPane topPane){
		Button b = new Button();

		b.setText("Reset!");
		b.setOnAction((event) -> {
			Random r = new Random();
			board = new Board(r, GRID_SIZE);
			this.updateBoard();

		});

		return b;
	}

	// ============================= End of PART 5 ==============================

	// 	Good job! Ship it.
	// 		.  o ..
  // 		o . o o.o
  //      		...oo
  //      		 __[]__
  //     		__|_o_o_o\__
  //   		  \""""""""""/
  //   		   \. ..  . /
  // 	^^^^^^^^^^^^^^^^^^^^^^^^^


	/** MyKeyHandler is an inner class to handle key events
	 * and pass them to the Board object to make the appropriate move.
	 * @author Prof. Christine Alvarado
	 *
	 */
	class MyKeyHandler implements EventHandler<KeyEvent> {

		/*
		 * Name: handle(KeyEvent e)
		 *
		 * Purpose: The purpose of this method is to handle the keys pressed by the
		 * user of the game.
		 *
		 * Parameters: KeyEvent e - The key event that the user enters - in other
		 * words the directional arrows that the user can choose, or the "Q" key for
		 * quitting the game
		 *
		 * Return: void
		 */
		public void handle(KeyEvent e) {

			Direction direction = null;

			// if user hits up arrow
			if (e.getCode() == KeyCode.UP) {
				direction = Direction.UP;
				System.out.println("Moving UP");
			}

			// if user hits down arrow
			else if (e.getCode() == KeyCode.DOWN) {
				System.out.println("Moving DOWN");
				direction = Direction.DOWN;
			}

			// If user hits left arrow
			else if (e.getCode() == KeyCode.LEFT) {
				System.out.println("Moving LEFT");
				direction = Direction.LEFT;
			}

			// If user hits right arrow
			else if (e.getCode() == KeyCode.RIGHT) {
				System.out.println("Moving RIGHT");
				direction = Direction.RIGHT;
			}

			boolean success = board.move(direction);
			if (success) {
				board.addRandomTile();
				updateBoard();
			}

		}

	}

	/**
	 * This main method is needed for running in eclipse
	 * @param args
	 */
	public static void main(String [] args)
	{
		Application.launch(args);
	}


}
