
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

public class PA3_ExtraCredit extends Application{
  private final int GRID_SIZE = 3;
  private Label player1Score = new Label();
  private Label player2Score = new Label();
  private Board board;
  private int step;

  public void start(Stage primaryStage){
    setUpPane(primaryStage);
    this.board = new Board(GRID_SIZE);
    this.step = 1;

  }

  public void setUpPane(Stage primaryStage){
    BorderPane back = new BorderPane();

    Scene scene = new Scene(back);

    primaryStage.setScene(scene);

    //Set up header
    GridPane header = new GridPane();
    header.setAlignment(Pos.CENTER);
    header.setHgap(50);
    header.setPadding(new Insets(20, 10, 10, 10));

    //Title in header
    Text title = new Text("Tic-Tac-Toc");
    title.setFont(Font.font ("Verdana", 32));
    header.add(title, 0, 0);

    // Scoreboard in header
    GridPane scoreboard = new GridPane();
    Text player1 = new Text("PLAYER1");
    Text player2 = new Text("PLAYER2");
    Text vs = new Text(" : ");

    scoreboard.add(player1, 0, 0);
    scoreboard.add(player2, 2, 0);
    scoreboard.add(player1Score, 0, 1);
    scoreboard.add(vs, 1, 1);
    scoreboard.add(player2Score, 2, 1);

    scoreboard.setAlignment(Pos.CENTER);

    this.updateScore1(0);
    this.updateScore2(0);

    header.add(scoreboard, 1, 0);

    back.setTop(header);


    // Playground for tic tac toe
    GridPane playGround = new GridPane();
    back.setCenter(playGround);




    // Show the stage
    primaryStage.setTitle("Tic-Tac-Toc");
    primaryStage.setHeight(800);
    primaryStage.setWidth(600);
    primaryStage.show();
  }

  public void updateScore1(int score){
    String s = Integer.toString(score);
    this.player1Score.setText(s);
  }

  public void updateScore2(int score){
    String s = Integer.toString(score);
    this.player2Score.setText(s);
  }
}

class Board{
  private int[][] ground;
  private final int GRID_SIZE;

  // Initialize the class
  public Board(int size){
    this.GRID_SIZE = size;
    ground = new int[GRID_SIZE][GRID_SIZE];
  }


}
