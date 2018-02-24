import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.*;

public class GameTile extends StackPane {
	//Hashmap that uses tilevalue as the key to access appropriate color
	//Check out the populateColors method that populates the HashMap
	static HashMap<Integer, Color> colors = new HashMap<Integer, Color>();


	// ================================ PART 2 ==================================

	/* TODO: Fill in the constructor */
	public GameTile(int tileValue) {


				/*TODO:  1. Create a new object to represent the tile
				 * (it can be a Rectangle, etc)
				 *
				 * Dont forget to set the width and height of the object
				 */
				 Rectangle r = new Rectangle();
				 r.setWidth(115);
				 r.setHeight(115);
				 r.setArcHeight(15);
    		 r.setArcWidth(15);


				/* TODO:  2. Set the value of the tile (assign to a text object)
				 * Dont forget to setText, setFont, and setFill
				 *
				 * ALSO, to be consistent with the game, if tileValue 0,
				 * make the tile not print out the tileValue (Keep it blank)
				 */
				 String s = Integer.toString(tileValue);
				 Text text = new Text();
				 if(tileValue == 0){
					 text.setText("");
				 }
				 else{
					 text.setText(s);
				 }

				 text.setFont(Font.font ("Verdana", 36));
				 if(tileValue > 4)
				 		text.setFill(Color.WHITE);
				 else
				 		text.setFill(Color.rgb(58,47,36));

				/* TODO:  3. Index into Hashmap with the tile value in order to set
				 * the color of the GameTile being constructed
				 */
				// this prepares the colors hash map
				populateColors();
				r.setFill(colors.get(tileValue));


				/* TODO:  4. Add tile object and value of tile to the children of
				 * this game tile. That effectively adds them to the board.
				 * Hint: Look into the getChildren method
				 */
				 this.getChildren().addAll(r,text);


	}
	// ============================= End of PART 2 ==============================

	// Now return to Gui2048.java to complete Part 3: the `updateBoard` method.


	/*
	 * Returns a new `GameTile` of value `tileValue`.
	 *
	 * @param tileValue Value of the tile to be made.
	 */
	public static GameTile makeNewTile(int tileValue) {
		return new GameTile(tileValue);
	}

	/* Name: populateColors()
	 *
	 * Purpose: The purpose of this method is to populate the HashMap
	 * with RGB values pertaining to certain tileValues. For example,
	 * the tileValue 2 has an RGB value of (238, 228, 218). Therefore,
	 * if we want to access the color of tileValue 2 from the hashmap,
	 * we would say colors.get(2) and it would return the color object
	 * Color.rgb(238, 228, 218)
	 *
	 * Parameters: None
	 *
	 * Return: None
	 */
	public static void populateColors() {
		colors.put(0,Color.rgb(238, 228, 218, 0.35)); //empty tile
		colors.put(2, Color.rgb(238, 228, 218));
		colors.put(4, Color.rgb(237, 224, 200));
		colors.put(8,Color.rgb(242, 177, 121));
		colors.put(16, Color.rgb(245, 149, 99));
		colors.put(32,Color.rgb(246, 124, 95));
		colors.put(64,Color.rgb(246, 94, 59));
		colors.put(128,Color.rgb(237, 207, 114));
		colors.put(256,Color.rgb(237, 204, 97));
		colors.put(512,Color.rgb(237, 200, 80));
		colors.put(1024,Color.rgb(237, 197, 63));
		colors.put(2048,Color.rgb(237, 194, 46));
		colors.put(4096,Color.rgb(237, 194, 46));
		colors.put(8192,Color.rgb(237, 194, 46));

	}



}
