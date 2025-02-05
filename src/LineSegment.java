import java.awt.Point;

public class LineSegment {
    private Point point1;
    private Point point2;

    /**
     * Constructs a LineSegment object with the given endpoints.
     *
     * @param point1 The first endpoint.
     * @param point2 The second endpoint.
     */
    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Gets the first endpoint of the line segment.
     *
     * @return The first endpoint.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Gets the second endpoint of the line segment.
     *
     * @return The second endpoint.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Calculates the length of the line segment.
     *
     * @return The length of the line segment.
     */
    public double length() {
        return point1.distanceTo(point2);
    }

    /**
     * Returns a string representation of the LineSegment object.
     *
     * @return A string representation of the line segment.
     */
    @Override
    public String toString() {
        return "LineSegment: Point1 = " + point1 + ", Point2 = " + point2;
    }
}