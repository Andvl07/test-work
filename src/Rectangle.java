
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;


/**
 * Represents a rectangle, which is a special case of a Figure.
 */
public class Rectangle extends Figure {

    /**
     * Constructs a Rectangle object with the given points.
     *
     * @param point1 The first corner point.
     * @param point2 The second corner point.
     * @param point3 The third corner point.
     * @param point4 The fourth corner point.
     * @throws IllegalArgumentException if the rectangle does not have exactly 4
     * points.
     */
    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(new ArrayList<>(List.of(point1, point2, point3, point4)));  // Pass a List to the super constructor
        if (points.size() != 4) {
            throw new IllegalArgumentException("Rectangle must have 4 points.");
        }
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */
    @Override
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            perimeter += points.get(i).distanceTo(points.get((i + 1) % points.size()));
        }
        return perimeter;
    }

    /**
     * Determines if this rectangle intersects with another rectangle.
     *
     * @param other The other rectangle to check for intersection.
     * @return True if the rectangles intersect, false otherwise.
     */
    public boolean intersects(Rectangle other) {
        if (other == null) {
            return false; // Or throw an exception, depending on desired behavior
        }

        // Find the min/max x and y values for this rectangle
        double minX1 = Double.MAX_VALUE, maxX1 = Double.MIN_VALUE;
        double minY1 = Double.MAX_VALUE, maxY1 = Double.MIN_VALUE;
        for (Point p : this.points) {
            minX1 = Math.min(minX1, p.getX());
            maxX1 = Math.max(maxX1, p.getX());
            minY1 = Math.min(minY1, p.getY());
            maxY1 = Math.max(maxY1, p.getY());
        }

        // Find the min/max x and y values for the other rectangle
        double minX2 = Double.MAX_VALUE, maxX2 = Double.MIN_VALUE;
        double minY2 = Double.MAX_VALUE, maxY2 = Double.MIN_VALUE;
        for (Point p : other.points) {
            minX2 = Math.min(minX2, p.getX());
            maxX2 = Math.max(maxX2, p.getX());
            minY2 = Math.min(minY2, p.getY());
            maxY2 = Math.max(maxY2, p.getY());
        }

        // Check for overlap in both x and y dimensions
        return !(maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1);
    }

}


     * 
