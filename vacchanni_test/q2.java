import java.util.*;
class Shape {
	String type;
	int x;
	int y;

	public Shape(String type, int x, int y) {
		this.type = type.toLowerCase();
		this.x = this.x;
		this.y = this.y;
	}
}

class Order {
	int num_shapes = 0;
	List<Shape> shapes = new ArrayList<Shape>();

	public void addShape(String type, int x, int y) {
		if (num_shapes == 5) {
			System.out.println("this order already has max shapes");
		}
		if (type.toLowerCase() != "triangle" && type.toLowerCase() != "rectangle") {
			System.out.println(type.toLowerCase());
			System.out.println("Wrong dimensions.");
		}
		this.num_shapes += 1;
		Shape s = new Shape(type, x, y);
		this.shapes.add(s);
	}

	public void addShape(String type, int x) {
		if (num_shapes == 5) {
			System.out.println("this order already has max shapes");
		}
		if (type.toLowerCase() != "circle" && type.toLowerCase() != "square") {
			System.out.println(type.toLowerCase());
			System.out.println("Wrong dimensions.");
		}
		this.num_shapes += 1;
		System.out.println(x);
		System.out.println();
		Shape s = new Shape(type, x, 0);
		System.out.println(s.x);
		this.shapes.add(s);
	}

}

class System1 {
	int num_orders = 0;
	List<Order> orders = new ArrayList<Order>();

	public void add_orders() {
		this.orders.add(new Order());
		this.num_orders += 1;
	}
	public void add_orders(Order o) {
		this.orders.add(o);
		this.num_orders += 1;
	}
}


public class q2 {

	public static float calCostOrder(Order o) {
		System.out.println(o.num_shapes);
		if (o.num_shapes == 0) 
			return 0;
		else {
			float cost = 0;
			for (int i = 0; i < o.shapes.size(); i++) {
				String s = o.shapes.get(i).type;

				System.out.println(s);

				if (s == "circle") {
					cost += 100 * 3.14 * o.shapes.get(i).x * o.shapes.get(i).x;
				}
				else if (s == "rectangle") {
					cost += 50 * o.shapes.get(i).x * o.shapes.get(i).y;
				}
				else if (s == "square") {
					System.out.println("hello");
					System.out.println(o.shapes.get(i).x);
					System.out.println(o.shapes.get(i).y);
					cost += 50 * o.shapes.get(i).x * o.shapes.get(i).x;
				}
				else if(s == "triangle") {
					cost += 75 * 0.5 * o.shapes.get(i).x * o.shapes.get(i).y;
				}

			}
			return cost;
		}
	}

	public static float totalCost(System1 s) {
		if(s.num_orders == 0) {
			return 0;
		}
		float totalCost = 0;
		for (int i = 0; i < s.orders.size(); i++) {
			totalCost += calCostOrder(s.orders.get(i));
		}
		return totalCost;
	}

	public static void main(String args[]) {
		System1 s = new System1();

		Order o = new Order();
		o.addShape("square", 3);
		System.out.println("calCostOrder = " + calCostOrder(o));
		o.addShape("rectangle", 4, 5);
		System.out.println("calCostOrder = " + calCostOrder(o));
		o.addShape("triangle", 6, 6);
		System.out.println("calCostOrder = " + calCostOrder(o));
		o.addShape("circle", 4);
		System.out.println("calCostOrder = " + calCostOrder(o));
		o.addShape("square", 6);
		System.out.println("calCostOrder = " + calCostOrder(o));
		o.addShape("circle", 4);

		s.add_orders(o);

		System.out.println("totalCost = " + totalCost(s));

	}
}