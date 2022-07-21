
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class hextris extends Application {
	// we set our var here 
	public static final int move_size = 25;
	public static final int size_item = 25;
	public static final int X_grid = 15;
	public static final int Y_grid = 21;
	public static final int extrnal_page_for_information = 150;

	// our grid size and we meke our grid with that sizes
	public static int width_grid =  X_grid * size_item ;
	public static int height_grid = Y_grid * size_item ;
	public static int[][] grid = new int[width_grid / size_item][height_grid / size_item];

	public static Pane group = new Pane();
	private static block my_block;
	private static Scene scene = new Scene(group, width_grid + extrnal_page_for_information, height_grid);


	private static block next_block = new block();

	public static int score = 0;
	private static int top = 0;
	private static boolean gaming = true;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		for ( int[] q : grid ) {
			Arrays.fill( q, 0 );
		}

		Line vertical_line = new Line(width_grid, 0, width_grid, height_grid);
		vertical_line.setFill(Color.GREEN);

		Text about_programmer = new Text("\n Hamid Reza Zehtab \n\n 9912762541");
		about_programmer.setFill(Color.GREEN);
		about_programmer.setStyle("-fx-font: 12 arial;");
		about_programmer.setY(11);
		about_programmer.setX(width_grid + 5);

		Line horizontal_line = new Line(width_grid,150,width_grid+extrnal_page_for_information,150);
		horizontal_line.setFill(Color.GREEN);

		Text score_board = new Text("your score : ");
		score_board.setFill(Color.DARKGREEN);
		score_board.setStyle("-fx-font: 20 arial;");
		score_board.setY(181);
		score_board.setX(width_grid + 5);

		group.getChildren().addAll(about_programmer,score_board, vertical_line,horizontal_line);

		block a = next_block;
		group.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPress(a);
		my_block = a;
		next_block = new block();
		stage.setScene(scene);
		stage.setTitle("Hamid Reza Zehtab 9912762541");
		stage.show();

		// set timer -> 3 step in 1 second (333 meili second)
		Timer timer_step = new Timer();
		TimerTask timer_task = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (my_block.get_XY("ay") == 0 || my_block.get_XY("by") == 0 || my_block.get_XY("cy") == 0
								|| my_block.get_XY("dy") == 0)
							top++;
						else
							top = 0;

						if (top == 2) {
							// losting game
							Text losting_game_text = new Text("YOU LOST THE GAME");
							losting_game_text.setFill(Color.ORANGERED);
							losting_game_text.setStyle("-fx-font: 40 arial;");
							losting_game_text.setY(height_grid/2);
							losting_game_text.setX(20);
							group.getChildren().add(losting_game_text);
							gaming = false;
						}
						
						if (gaming) {
							// if game does not finish so our block go down one step 
							move_it_down(my_block);

							// show your score in score board
							score_board.setText("your score : " + Integer.toString(score));
						}


					}
				});
			}
		};
		timer_step.schedule(timer_task, 0, 333);

	}

	private void moveOnKeyPress(block block) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				KeyCode keyCode = event.getCode();
				// key code 
				// d go right 
				// s go down 
				// a go left 
				// w go top 
				if(keyCode.equals(KeyCode.D)){
					move_it_right(block);
				}
				if(keyCode.equals(KeyCode.S)) {
					move_it_down(block);
				}
				if(keyCode.equals(KeyCode.A)) {
					move_it_left(block);
				}
				if(keyCode.equals(KeyCode.W)) {
					// rotate it.
					block.move_it_rotate();
				}
			}
		});
	}

    public static void move_it_right(block block) {
		// we set whole block to right one step

        if (block.get_XY("ax") + move_size <= width_grid - size_item && block.get_XY("bx") + move_size <= width_grid - size_item
                && block.get_XY("cx") + move_size <= width_grid - size_item && block.get_XY("dx") + move_size <= width_grid - size_item) {
            int move_a = grid[((int) block.get_XY("ax") / size_item) + 1][((int) block.get_XY("ay") / size_item)];
            int move_b = grid[((int) block.get_XY("bx") / size_item) + 1][((int) block.get_XY("by") / size_item)];
            int move_c = grid[((int) block.get_XY("cx") / size_item) + 1][((int) block.get_XY("cy") / size_item)];
            int move_d = grid[((int) block.get_XY("dx") / size_item) + 1][((int) block.get_XY("dy") / size_item)];
            if (move_a == 0 && move_a == move_b && move_b == move_c && move_c == move_d) {
                block.set_XY("ax",block.get_XY("ax") + move_size);
				block.set_XY("bx",block.get_XY("bx") + move_size);
				block.set_XY("cx",block.get_XY("cx") + move_size);
                block.set_XY("dx",block.get_XY("dx") + move_size);
            }
        }
    }

    public static void move_it_left(block block) {
		// we set whole block to left one step

		if (block.get_XY("ax") - move_size >= 0 && block.get_XY("bx") - move_size >= 0 && block.get_XY("cx") - move_size >= 0
                && block.get_XY("dx") - move_size >= 0) {
            int move_a = grid[((int) block.get_XY("ax") / size_item) - 1][((int) block.get_XY("ay") / size_item)];
            int move_b = grid[((int) block.get_XY("bx") / size_item) - 1][((int) block.get_XY("by") / size_item)];
            int move_c = grid[((int) block.get_XY("cx") / size_item) - 1][((int) block.get_XY("cy") / size_item)];
            int move_d = grid[((int) block.get_XY("dx") / size_item) - 1][((int) block.get_XY("dy") / size_item)];
            if (move_a == 0 && move_a == move_b && move_b == move_c && move_c == move_d){
                block.set_XY("ax",block.get_XY("ax") - move_size);
                block.set_XY("bx",block.get_XY("bx") - move_size);
                block.set_XY("cx",block.get_XY("cx") - move_size);
                block.set_XY("dx",block.get_XY("dx") - move_size);
            }
        }
    }



	private void move_full_rows(Pane pane) {
		// we remove full rows
		ArrayList<Node> polys = new ArrayList<Node>();
		ArrayList<Integer> lines = new ArrayList<Integer>();
		ArrayList<Node> new_polys = new ArrayList<Node>();
		int block_number_in_row = 0;
		int add_score = 0 ;
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == 1)
					block_number_in_row++;
			}
			if (block_number_in_row == grid.length || block_number_in_row == grid.length-1) {
				lines.add(i);
				add_score = 10 ;
			}
			block_number_in_row = 0;
		}
		score += add_score;
		if (lines.size() > 0)
			do {
				for (Node node : pane.getChildren()) {
					if (node instanceof Polygon)
						polys.add(node);
				}
				for (Node node : polys) {
					Polygon a = (Polygon) node;
					if (a.getTranslateY() == lines.get(0) * size_item) {
						grid[(int) a.getTranslateX() / size_item][(int) a.getTranslateY() / size_item] = 0;
						pane.getChildren().remove(node);
					} else
						new_polys.add(node);
				}
				for (Node node : new_polys) {
					Polygon a = (Polygon) node;
					if (a.getTranslateY() < lines.get(0) * size_item) {
						grid[(int) a.getTranslateX() / size_item][(int) a.getTranslateY() / size_item] = 0;
						a.setTranslateY(a.getTranslateX() + size_item);
					}
				}
				lines.remove(0);
				polys.clear();
				new_polys.clear();
				for (Node node : pane.getChildren()) {
					if (node instanceof Polygon)
						polys.add(node);
				}
				for (Node node : polys) {
					Polygon a = (Polygon) node;
					try {
						grid[(int) a.getTranslateX() / size_item][(int) a.getTranslateY() / size_item] = 1;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				polys.clear();
			} while (lines.size() > 0);
		lines.clear();

	}


	private void move_it_down(block block) {
		// we set whole block to down one step

		// if our block fit on top op thing or floor and stay down .
		if (block.get_XY("ay") == height_grid - size_item || block.get_XY("by") == height_grid - size_item || block.get_XY("cy") == height_grid - size_item
				|| block.get_XY("dy") == height_grid - size_item || move_a(block) || move_b(block) || move_c(block) || move_d(block)) {

			grid[(int) block.get_XY("ax") / size_item][(int) block.get_XY("ay") / size_item] = 1;
			grid[(int) block.get_XY("bx") / size_item][(int) block.get_XY("by") / size_item] = 1;
			grid[(int) block.get_XY("cx") / size_item][(int) block.get_XY("cy") / size_item] = 1;
			grid[(int) block.get_XY("dx") / size_item][(int) block.get_XY("dy") / size_item] = 1;
			move_full_rows(group);


			block a = next_block;
			next_block = new block();
			my_block = a;
			group.getChildren().addAll(a.a, a.b, a.c, a.d);
			moveOnKeyPress(a);

		}
		
		// if our block can move more ! 
		if (block.get_XY("ay") + move_size < height_grid && block.get_XY("by") + move_size < height_grid && block.get_XY("cy") + move_size < height_grid
				&& block.get_XY("dy") + move_size < height_grid) {
			int move_a = grid[(int) block.get_XY("ax") / size_item][((int) block.get_XY("ay") / size_item) + 1];
			int move_b = grid[(int) block.get_XY("bx") / size_item][((int) block.get_XY("by") / size_item) + 1];
			int move_c = grid[(int) block.get_XY("cx") / size_item][((int) block.get_XY("cy") / size_item) + 1];
			int move_d = grid[(int) block.get_XY("dx") / size_item][((int) block.get_XY("dy") / size_item) + 1];
			if (move_a == 0 && move_a == move_b && move_b == move_c && move_c == move_d) {
				block.set_XY("ay",block.get_XY("ay") + move_size);
				block.set_XY("by",block.get_XY("by") + move_size);
				block.set_XY("cy",block.get_XY("cy") + move_size);
				block.set_XY("dy",block.get_XY("dy") + move_size);
			}
		}
	}

	private boolean move_a(block block) {
		return (grid[(int) block.get_XY("ax") / size_item][((int) block.get_XY("ay") / size_item) + 1] == 1);
	}

	private boolean move_b(block block) {
		return (grid[(int) block.get_XY("bx") / size_item][((int) block.get_XY("by") / size_item) + 1] == 1);
	}

	private boolean move_c(block block) {
		return (grid[(int) block.get_XY("cx") / size_item][((int) block.get_XY("cy") / size_item) + 1] == 1);
	}

	private boolean move_d(block block) {
		return (grid[(int) block.get_XY("dx") / size_item][((int) block.get_XY("dy") / size_item) + 1] == 1);
	}

}


/*
	| writted by : nimazare 
	| university : ferdowsi 
	| code-meli  : 0925943037
	| phone      : 09055307841	
	| University_code : 9912762381
	
	thanks for your attention
 */