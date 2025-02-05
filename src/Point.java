public class Point {
    private double x;
    private double y;

    /**
     * Создает объект Point с заданными координатами.
     *
     * @param x Координата x точки.
     * @param y Координата y точки.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату x точки.
     *
     * @return Координата x.
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату y точки.
     *
     * @return Координата y.
     */
    public double getY() {
        return y;
    }

    /**
     * Устанавливает координаты точки.
     *
     * @param x Новая координата x.
     * @param y Новая координата y.
     */
    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисляет расстояние до другой точки.
     *
     * @param other Другая точка.
     * @return Расстояние между двумя точками.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + Math.pow(this.getY() - other.getY(), 2));
    }

    /**
     * Поворачивает точку вокруг заданного центра на заданный угол в градусах.
     *
     * @param centerX Координата x центра вращения.
     * @param centerY Координата y центра вращения.
     * @param angleDegrees Угол поворота в градусах.
     */
    public void rotate(double centerX, double centerY, double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        double newX = centerX + (this.x - centerX) * Math.cos(angleRadians) - (this.y - centerY) * Math.sin(angleRadians);
        double newY = centerY + (this.x - centerX) * Math.sin(angleRadians) + (this.y - centerY) * Math.cos(angleRadians);
        this.x = newX;
        this.y = newY;
    }

    /**
     * Возвращает строковое представление объекта Point.
     *
     * @return Строковое представление точки.
     */
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}