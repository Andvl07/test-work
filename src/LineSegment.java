public class LineSegment {
    private Point point1;
    private Point point2;

    /**
     * Создает объект LineSegment с заданными конечными точками.
     *
     * @param point1 Первая конечная точка.
     * @param point2 Вторая конечная точка.
     */
    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Возвращает первую конечную точку отрезка.
     *
     * @return Первая конечная точка.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Возвращает вторую конечную точку отрезка.
     *
     * @return Вторая конечная точка.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Вычисляет длину отрезка.
     *
     * @return Длина отрезка.
     */
    public double length() {
        return point1.distanceTo(point2);
    }

    /**
     * Возвращает строковое представление объекта LineSegment.
     *
     * @return Строковое представление отрезка.
     */
    @Override
    public String toString() {
        return "LineSegment: Point1 = " + point1 + ", Point2 = " + point2;
    }
}

