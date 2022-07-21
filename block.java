
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class block {

	/*
		our block have 4 polygons
			that named a,b,c,d
		have a color
		and rotate state than shown us that this block set on what position
	 */

	Polygon a;
	double ax ;
	double ay ;

	Polygon b;
	double bx ;
	double by ;

	Polygon c;
	double cx ;
	double cy ;

	Polygon d;
	double dx;
	double dy;

	Color color;
	private String name_color;
	public int rotate_state = 1;

	// we get something from hextris class like our grid and more information

	public static int[][] grid = hextris.grid;

	public static final int move_size = hextris.move_size;
	public static final int size_item = hextris.size_item;

	public static int width_grid = hextris.width_grid;
	public static int height_grid = hextris.height_grid;



	public block() {
		int block = (int) (1000 * Math.random());
		String name_color;

		Polygon a = new Polygon();
		this.a = a;
		this.ax = 0.0;
		this.ay = 0.0;
		Polygon b = new Polygon();
		this.b = b;
		this.bx = 0.0;
		this.by = 0.0;
		Polygon c = new Polygon();
		this.c = c;
		this.cx = 0.0;
		this.cy = 0.0;
		Polygon d = new Polygon();
		this.d = d;
		this.dx = 0.0;
		this.dy = 0.0;

		double middle = width_grid / 2 - size_item;
		if (block < 142) {
			set_XY("ax",middle-size_item);

			set_XY("bx",middle-size_item);
			set_XY("by",size_item);

			set_XY("cx",middle);
			set_XY("cy",size_item);

			set_XY("dx",middle+size_item);
			set_XY("dy",size_item);

			name_color = "j";
		} else if (block < 284) {
			set_XY("ax",middle+size_item);

			set_XY("bx",middle-size_item);
			set_XY("by",size_item);

			set_XY("cx",middle);
			set_XY("cy",size_item);

			set_XY("dx",middle+size_item);
			set_XY("dy",size_item);

			name_color = "l";
		} else if (block < 426) {
			set_XY("ax",middle-size_item);

			set_XY("bx",middle);

			set_XY("cx",middle- size_item);
			set_XY("cy",size_item);

			set_XY("dx",middle);
			set_XY("dy",size_item);

			name_color = "o";
		} else if (block < 568) {
			set_XY("ax",middle+size_item);

			set_XY("bx",middle);

			set_XY("cx",middle);
			set_XY("cy",size_item);

			set_XY("dx",middle-size_item);
			set_XY("dy",size_item);


			name_color = "s";
		} else if (block < 710) {
			set_XY("ax",middle-size_item);

			set_XY("bx",middle);

			set_XY("cx",middle);
			set_XY("cy",size_item);

			set_XY("dx",middle+size_item);

			name_color = "t";
		} else if (block < 852) {
			set_XY("ax",middle);

			set_XY("bx",middle+size_item);

			set_XY("cx",middle+size_item);
			set_XY("cy",size_item);

			set_XY("dx",middle+size_item+size_item);
			set_XY("dy",size_item);


			name_color = "z";
		} else {
			set_XY("ax",middle- size_item - size_item);

			set_XY("bx",middle- size_item );

			set_XY("cx",middle);

			set_XY("dx",middle+size_item);

			name_color = "i";
		}


		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.name_color = name_color;

		switch (name_color) {

			case "l":
				color = Color.SADDLEBROWN;
				break;
			case "j":
				color = Color.CORNFLOWERBLUE;
				break;
			case "s":
				color = Color.DEEPPINK;
				break;
			case "o":
				color = Color.INDIGO;
				break;
			case "z":
				color = Color.DARKGREEN;
				break;
			case "t":
				color = Color.DARKSLATEGRAY;
				break;
			case "i":
				color = Color.GOLD;
				break;

		}
		this.a.setFill(color);
		this.b.setFill(color);
		this.c.setFill(color);
		this.d.setFill(color);


	}


	public block(Polygon a, Polygon b, Polygon c, Polygon d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public block(Polygon a, Polygon b, Polygon c, Polygon d, String name_color) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.name_color = name_color;

		switch (name_color) {
			case "l":
				color = Color.SADDLEBROWN;
				break;
			case "j":
				color = Color.CORNFLOWERBLUE;
				break;
			case "s":
				color = Color.DEEPPINK;
				break;
			case "o":
				color = Color.INDIGO;
				break;
			case "z":
				color = Color.DARKGREEN;
				break;
			case "t":
				color = Color.DARKSLATEGRAY;
				break;
			case "i":
				color = Color.GOLD;
				break;
		}
		this.a.setFill(color);
		this.b.setFill(color);
		this.c.setFill(color);
		this.d.setFill(color);
	}

	public void set_XY(String hex,double dyn1) {

		double sz = size_item/3.33;
		double sz2 = size_item/2.2;
		double xst,yst;
		switch (hex) {
			case "ax":
				this.ax = dyn1 ;
				 xst = dyn1;
				 yst = this.ay;
				hextris.group.getChildren().removeAll(this.a);
				this.a = new Polygon();
				this.a.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.a.setFill(color);
				hextris.group.getChildren().addAll(this.a);


				break;
			case "ay":
				this.ay = dyn1 ;
				yst = dyn1;
				xst = this.ax;
				hextris.group.getChildren().removeAll(this.a);
				this.a = new Polygon();
				this.a.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.a.setFill(color);
				hextris.group.getChildren().addAll(this.a);

				break;
			case "bx":
				this.bx = dyn1 ;
				xst = dyn1;
				yst = this.by;
				hextris.group.getChildren().removeAll(this.b);
				this.b = new Polygon();
				this.b.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.b.setFill(color);
				hextris.group.getChildren().addAll(this.b);

				break;
			case "by":
				this.by = dyn1 ;
				yst = dyn1;
				xst = this.bx;
				hextris.group.getChildren().removeAll(this.b);
				this.b = new Polygon();
				this.b.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.b.setFill(color);
				hextris.group.getChildren().addAll(this.b);

				break;
			case "cx":
				this.cx = dyn1 ;
				xst = dyn1;
				yst = this.cy;
				hextris.group.getChildren().removeAll(this.c);
				this.c = new Polygon();
				this.c.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.c.setFill(color);
				hextris.group.getChildren().addAll(this.c);

				break;
			case "cy":
				this.cy = dyn1 ;
				yst = dyn1;
				xst = this.cx;
				hextris.group.getChildren().removeAll(this.c);
				this.c = new Polygon();
				this.c.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.c.setFill(color);
				hextris.group.getChildren().addAll(this.c);

				break;
			case "dx":
				this.dx = dyn1 ;
				xst = dyn1;
				yst = this.dy;
				hextris.group.getChildren().removeAll(this.d);
				this.d = new Polygon();
				this.d.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.d.setFill(this.color);
				hextris.group.getChildren().addAll(this.d);

				break;
			case "dy":
				this.dy = dyn1 ;
				yst = dyn1;
				xst = this.dx;
				hextris.group.getChildren().removeAll(this.d);
				this.d = new Polygon();
				this.d.getPoints().addAll(new Double[]{
						xst+sz, yst,
						xst, yst+sz2,
						xst+sz, yst+2*sz2,
						xst+2*sz, yst+2*sz2,
						xst+3*sz, yst+sz2,
						xst+2*sz, yst+0.0,
				});
				this.d.setFill(color);
				hextris.group.getChildren().addAll(this.d);

				break;
		}
	}

	public double get_XY(String hex) {
		switch (hex) {
			case "ax":
				return this.ax ;
			case "ay":
				return this.ay ;
			case "bx":
				return this.bx ;
			case "by":
				return this.by ;
			case "cx":
				return this.cx ;
			case "cy":
				return this.cy ;
			case "dx":
				return this.dx ;
			case "dy":
				return this.dy ;
		}
		return -1;
	}


	public String getName() {
		return name_color;
	}


	public void change_rotate_state() {
		if (rotate_state != 4) {
			rotate_state ++;
		} else {
			rotate_state = 1;
		}
	}


	public void move_it_rotate() {
		
		Polygon a = this.a;
		Polygon b = this.b;
		Polygon c = this.c;
		Polygon d = this.d;
		switch (this.name_color) {
			case "j":
				if (rotate_state == 1 && can_move("a", 1, -1) && can_move("c", -1, -1) && can_move("d", -2, -2)) {
					move_it_right("ax");
					move_it_down("ay");
					move_it_down("cy");
					move_it_left("cx");
					move_it_down("dy");
					move_it_down("dy");
					move_it_left("dx");
					move_it_left("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("a", -1, -1) && can_move("c", -1, 1) && can_move("d", -2, 2)) {
					move_it_down("ay");
					move_it_left("ax");
					move_it_left("cx");
					move_it_up("cy");
					move_it_left("dx");
					move_it_left("dx");
					move_it_up("dy");
					move_it_up("dy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("a", -1, 1) && can_move("c", 1, 1) && can_move("d", 2, 2)) {
					move_it_left("ax");
					move_it_up("ay");
					move_it_up("cy");
					move_it_right("cx");
					move_it_up("dy");
					move_it_up("dy");
					move_it_right("dx");
					move_it_right("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("a", 1, 1) && can_move("c", 1, -1) && can_move("d", 2, -2)) {
					move_it_up("ay");
					move_it_right("ax");
					move_it_right("cx");
					move_it_down("cy");
					move_it_right("dx");
					move_it_right("dx");
					move_it_down("dy");
					move_it_down("dy");
					this.change_rotate_state();
					break;
				}
				break;
			case "l":
				if (rotate_state == 1 && can_move("a", 1, -1) && can_move("c", 1, 1) && can_move("b", 2, 2)) {
					move_it_right("ax");
					move_it_down("ay");
					move_it_up("cy");
					move_it_right("cx");
					move_it_up("by");
					move_it_up("by");
					move_it_right("bx");
					move_it_right("bx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("a", -1, -1) && can_move("b", 2, -2) && can_move("c", 1, -1)) {
					move_it_down("ay");
					move_it_left("ax");
					move_it_right("bx");
					move_it_right("bx");
					move_it_down("by");
					move_it_down("by");
					move_it_right("cx");
					move_it_down("cy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("a", -1, 1) && can_move("c", -1, -1) && can_move("b", -2, -2)) {
					move_it_left("ax");
					move_it_up("ay");
					move_it_down("cy");
					move_it_left("cx");
					move_it_down("by");
					move_it_down("by");
					move_it_left("bx");
					move_it_left("bx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("a", 1, 1) && can_move("b", -2, 2) && can_move("c", -1, 1)) {
					move_it_up("ay");
					move_it_right("ax");
					move_it_left("bx");
					move_it_left("bx");
					move_it_up("by");
					move_it_up("by");
					move_it_left("cx");
					move_it_up("cy");
					this.change_rotate_state();
					break;
				}
				break;
			case "o":
				break;
			case "s":
				if (rotate_state == 1 && can_move("a", -1, -1) && can_move("c", -1, 1) && can_move("d", 0, 2)) {
					move_it_down("ay");
					move_it_left("ax");
					move_it_left("cx");
					move_it_up("cy");
					move_it_up("dy");
					move_it_up("dy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("a", 1, 1) && can_move("c", 1, -1) && can_move("d", 0, -2)) {
					move_it_up("ay");
					move_it_right("ax");
					move_it_right("cx");
					move_it_down("cy");
					move_it_down("dy");
					move_it_down("dy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("a", -1, -1) && can_move("c", -1, 1) && can_move("d", 0, 2)) {
					move_it_down("ay");
					move_it_left("ax");
					move_it_left("cx");
					move_it_up("cy");
					move_it_up("dy");
					move_it_up("dy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("a", 1, 1) && can_move("c", 1, -1) && can_move("d", 0, -2)) {
					move_it_up("ay");
					move_it_right("ax");
					move_it_right("cx");
					move_it_down("cy");
					move_it_down("dy");
					move_it_down("dy");
					this.change_rotate_state();
					break;
				}
				break;
			case "t":
				if (rotate_state == 1 && can_move("a", 1, 1) && can_move("d", -1, -1) && can_move("c", -1, 1)) {
					move_it_up("ay");
					move_it_right("ax");
					move_it_down("dy");
					move_it_left("dx");
					move_it_left("cx");
					move_it_up("cy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("a", 1, -1) && can_move("d", -1, 1) && can_move("c", 1, 1)) {
					move_it_right("ax");
					move_it_down("ay");
					move_it_left("dx");
					move_it_up("dy");
					move_it_up("cy");
					move_it_right("cx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("a", -1, -1) && can_move("d", 1, 1) && can_move("c", 1, -1)) {
					move_it_down("ay");
					move_it_left("ax");
					move_it_up("dy");
					move_it_right("dx");
					move_it_right("cx");
					move_it_down("cy");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("a", -1, 1) && can_move("d", 1, -1) && can_move("c", -1, -1)) {
					move_it_left("ax");
					move_it_up("ay");
					move_it_right("dx");
					move_it_down("dy");
					move_it_down("cy");
					move_it_left("cx");
					this.change_rotate_state();
					break;
				}
				break;
			case "z":
				if (rotate_state == 1 && can_move("b", 1, 1) && can_move("c", -1, 1) && can_move("d", -2, 0)) {
					move_it_up("ay");
					move_it_down("ay");

					move_it_up("by");
					move_it_right("bx");
					move_it_left("cx");
					move_it_up("cy");
					move_it_left("dx");
					move_it_left("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("b", -1, -1) && can_move("c", 1, -1) && can_move("d", 2, 0)) {
					move_it_down("by");
					move_it_left("bx");
					move_it_right("cx");
					move_it_down("cy");
					move_it_right("dx");
					move_it_right("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("b", 1, 1) && can_move("c", -1, 1) && can_move("d", -2, 0)) {
					move_it_up("by");
					move_it_right("bx");
					move_it_left("cx");
					move_it_up("cy");
					move_it_left("dx");
					move_it_left("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("b", -1, -1) && can_move("c", 1, -1) && can_move("d", 2, 0)) {
					move_it_down("by");
					move_it_left("bx");
					move_it_right("cx");
					move_it_down("cy");
					move_it_right("dx");
					move_it_right("dx");
					this.change_rotate_state();
					break;
				}
				break;
			case "i":
				if (rotate_state == 1 && can_move("a", 2, 2) && can_move("b", 1, 1) && can_move("d", -1, -1)) {
					move_it_up("ay");
					move_it_up("ay");
					move_it_right("ax");
					move_it_right("ax");
					move_it_up("by");
					move_it_right("bx");
					move_it_down("dy");
					move_it_left("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 2 && can_move("a", -2, -2) && can_move("b", -1, -1) && can_move("d", 1, 1)) {
					move_it_down("ay");
					move_it_down("ay");
					move_it_left("ax");
					move_it_left("ax");
					move_it_down("by");
					move_it_left("bx");
					move_it_up("dy");
					move_it_right("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 3 && can_move("a", 2, 2) && can_move("b", 1, 1) && can_move("d", -1, -1)) {
					move_it_up("ay");
					move_it_up("ay");
					move_it_right("ax");
					move_it_right("ax");
					move_it_up("by");
					move_it_right("bx");
					move_it_down("dy");
					move_it_left("dx");
					this.change_rotate_state();
					break;
				}
				if (rotate_state == 4 && can_move("a", -2, -2) && can_move("b", -1, -1) && can_move("d", 1, 1)) {
					move_it_down("ay");
					move_it_down("ay");
					move_it_left("ax");
					move_it_left("ax");
					move_it_down("by");
					move_it_left("bx");
					move_it_up("dy");
					move_it_right("dx");
					this.change_rotate_state();
					break;
				}
				break;
		}
		
	}

	private boolean can_move(String a_b_c_d, int x, int y) {
		boolean xb = false;
		boolean yb = false;
		if (x >= 0)
			xb = get_XY(a_b_c_d+"x") + x * move_size <= width_grid - size_item;
		if (x < 0)
			xb = get_XY(a_b_c_d+"x") + x * move_size >= 0;
		if (y >= 0)
			yb = get_XY(a_b_c_d+"y") - y * move_size > 0;
		if (y < 0)
			yb = get_XY(a_b_c_d+"y") + y * move_size < height_grid;
		return xb && yb && grid[((int) get_XY(a_b_c_d+"x") / size_item) + x][((int) get_XY(a_b_c_d+"y") / size_item) - y] == 0;
	}
	
	private void move_it_down(String go_to) {
		double des = get_XY(go_to);
		if (des + move_size < height_grid) {
			set_XY(go_to, des + move_size);
		}
	}

	private void move_it_right(String go_to) {
		double des = get_XY(go_to);
		if (des + move_size <= width_grid - size_item) {
			set_XY(go_to, des + move_size);
		}
	}

	private void move_it_left(String go_to) {
		double des = get_XY(go_to);
		if (des - move_size >= 0) {
			set_XY(go_to, des - move_size);
		}
	}

	private void move_it_up(String go_to) {
		double des = get_XY(go_to);
		if (des - move_size > 0) {
			set_XY(go_to, des - move_size);
		}
	}


}


/*
	| writted by : hamidzehtab
	| university : ferdowsi
	
	thanks for your attention
 */
