public class Point {
    private double x;
    private double y;

    /**
     * Constructs a Point object with the given coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the point.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the point.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the coordinates of the point.
     *
     * @param x The new x-coordinate.
     * @param y The new y-coordinate.
     */
    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance to another point.
     *
     * @param other The other point.
     * @return The distance between the two points.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * Rotates the point around a center by a given angle in degrees.
     *
     * @param centerX     The x-coordinate of the center of rotation.
     * @param centerY     The y-coordinate of the center of rotation.
     * @param angleDegrees The angle of rotation in degrees.
     */
    public void rotate(double centerX, double centerY, double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        double newX = centerX + (this.x - centerX) * Math.cos(angleRadians) - (this.y - centerY) * Math.sin(angleRadians);
        double newY = centerY + (this.x - centerX) * Math.sin(angleRadians) + (this.y - centerY) * Math.cos(angleRadians);
        this.x = newX;
        this.y = newY;
    }

    /**
     * Returns a string representation of the Point object.
     *
     * @return A string representation of the point.
     */
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}