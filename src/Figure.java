import java.util.List;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Abstract class representing a geometric figure.
 */
public abstract class Figure {
    protected List<Point> points;

    /**
     * Constructs a Figure object with the given points.
     *
     * @param points An array of Point objects representing the vertices of the figure.
     * @throws IllegalArgumentException if the figure has less than 3 points.
     */
    public Figure(List<Point> points) {
        if (points.size() < 3) {
            throw new IllegalArgumentException("Figure must have at least 3 points.");
        }
        this.points = new ArrayList<>(points); // Copy points to avoid modification of original list
    }


    /**
     * Gets the list of points that define the figure.
     *
     * @return The list of points.
     */
    public List<Point> getPoints() {
        return new ArrayList<>(points); // Return a copy to prevent modification
    }

    /**
     * Calculates the perimeter of the figure.  This is an abstract method, so subclasses must implement it.
     *
     * @return The perimeter of the figure.
     */
    public abstract double perimeter();

    /**
     * Rotates the entire figure around the first point by the given angle in degrees.
     *
     * @param angleDegrees The angle of rotation in degrees.
     */
    public void rotate(double angleDegrees) {
        Point firstPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            points.get(i).rotate(firstPoint.getX(), firstPoint.getY(), angleDegrees);
        }
    }

    /**
     * Returns a string representation of the Figure object.
     *
     * @return A string representation of the figure.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Figure with points: ");
        for (Point point : points) {
            sb.append(point.toString()).append(", ");
        }
        if (points.size() > 0) {
            sb.delete(sb.length() - 2, sb.length()); // Remove the last ", "
        }
        return sb.toString();
    }
}