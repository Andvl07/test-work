import java.util.ArrayList;
import java.util.List;

/**
 * Main class to demonstrate the geometry package.
 */
public class Main {
    /**
     * Main method to demonstrate the functionality of the classes.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create some points
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 0);
        Point point3 = new Point(1, 1);
        Point point4 = new Point(0, 1);

        // Demonstrate Point methods
        System.out.println("Initial point1: " + point1);
        point1.setCoordinates(2, 2);
        System.out.println("Point1 after setting new coordinates: " + point1);

        // Create a line segment
        LineSegment line = new LineSegment(point1, point2);
        System.out.println(line);
        System.out.println("Length of the line: " + line.length());

        // Create a rectangle
        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
        System.out.println(rectangle);
        System.out.println("Perimeter of the rectangle: " + rectangle.perimeter());

        // Rotate the rectangle
        System.out.println("Rotating the rectangle 45 degrees around point1...");
        rectangle.rotate(45);
        System.out.println(rectangle);

        // Create two rectangles
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(2, 0), new Point(2, 1), new Point(0, 1));
        Rectangle rect2 = new Rectangle(new Point(1, 0), new Point(3, 0), new Point(3, 1), new Point(1, 1));
        Rectangle rect3 = new Rectangle(new Point(5, 5), new Point(7, 5), new Point(7, 6), new Point(5, 6));

        // Check for intersection
        System.out.println("Does rect1 intersect rect2? " + rect1.intersects(rect2)); // Should intersect
        System.out.println("Does rect1 intersect rect3? " + rect1.intersects(rect3)); // Should not intersect
        System.out.println("Does rect1 intersect null? " + rect1.intersects(null)); // Should not intersect
    }
}

