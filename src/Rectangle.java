import java.util.ArrayList;
import java.util.List;

/**
 * Представляет прямоугольник, который является частным случаем Figure.
 */
public class Rectangle extends Figure {

    /**
     * Создает объект Rectangle с заданными точками.
     *
     * @param point1 Первая угловая точка.
     * @param point2 Вторая угловая точка.
     * @param point3 Третья угловая точка.
     * @param point4 Четвертая угловая точка.
     * @throws IllegalArgumentException если у прямоугольника не ровно 4 точки или если какая-либо точка равна null.
     */
    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(createPointList(point1, point2, point3, point4));
        if (this.points.size() != 4) {
            throw new IllegalArgumentException("Прямоугольник должен иметь 4 точки.");
        }
    }

    private static List<Point> createPointList(Point point1, Point point2, Point point3, Point point4) {
        if (point1 == null || point2 == null || point3 == null || point4 == null) {
            throw new IllegalArgumentException("Точки не могут быть null.");
        }
        List<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        return points;
    }


    /**
     * Вычисляет периметр прямоугольника.
     *
     * @return Периметр прямоугольника.
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
     * Определяет, пересекается ли этот прямоугольник с другим прямоугольником.
     *
     * @param other Другой прямоугольник для проверки пересечения.
     * @return True, если прямоугольники пересекаются, False в противном случае.
     */
    public boolean intersects(Rectangle other) {
        if (other == null) {
            return false; // Или выбросить исключение, в зависимости от требуемого поведения
        }

        // Находим min/max значения x и y для этого прямоугольника
        double minX1 = Double.MAX_VALUE, maxX1 = Double.MIN_VALUE;
        double minY1 = Double.MAX_VALUE, maxY1 = Double.MIN_VALUE;
        for (Point p : this.points) {
            minX1 = Math.min(minX1, p.getX());
            maxX1 = Math.max(maxX1, p.getX());
            minY1 = Math.min(minY1, p.getY());
            maxY1 = Math.max(maxY1, p.getY());
        }

        // Находим min/max значения x и y для другого прямоугольника
        double minX2 = Double.MAX_VALUE, maxX2 = Double.MIN_VALUE;
        double minY2 = Double.MAX_VALUE, maxY2 = Double.MIN_VALUE;
        for (Point p : other.points) {
            minX2 = Math.min(minX2, p.getX());
            maxX2 = Math.max(maxX2, p.getX());
            minY2 = Math.min(minY2, p.getY());
            maxY2 = Math.max(maxY2, p.getY());
        }

        // Проверяем перекрытие по обеим осям x и y
        return !(maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1);
    }
}

