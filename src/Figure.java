import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс, представляющий геометрическую фигуру.
 */
public abstract class Figure {
    protected List<Point> points;

    /**
     * Создает объект Figure с заданными точками.
     *
     * @param points Список объектов Point, представляющих вершины фигуры.
     * @throws IllegalArgumentException если у фигуры меньше 3 точек.
     */
    public Figure(List<Point> points) {
        if (points == null || points.size() < 3) {
            throw new IllegalArgumentException("У фигуры должно быть не менее 3 точек.");
        }
        this.points = new ArrayList<>(points);
    }

    /**
     * Возвращает список точек, определяющих фигуру.
     *
     * @return Список точек.
     */
    public List<Point> getPoints() {
        return new ArrayList<>(points); // Return a copy
    }

    /**
     * Вычисляет периметр фигуры. Это абстрактный метод, поэтому подклассы должны его реализовать.
     *
     * @return Периметр фигуры.
     */
    public abstract double perimeter();

    /**
     * Поворачивает всю фигуру вокруг первой точки на заданный угол в градусах.
     *
     * @param angleDegrees Угол поворота в градусах.
     */
    public void rotate(double angleDegrees) {
        Point firstPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            points.get(i).rotate(firstPoint.getX(), firstPoint.getY(), angleDegrees);
        }
    }

    /**
     * Возвращает строковое представление объекта Figure.
     *
     * @return Строковое представление фигуры.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Фигура с точками: ");
        for (Point point : points) {
            sb.append(point.toString()).append(", ");
        }
        if (points.size() > 0) {
            sb.delete(sb.length() - 2, sb.length()); // Remove the last ", "
        }
        return sb.toString();
    }
}