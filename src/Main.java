

/*Главный класс Main */
public class Main {
    /**
     * Главный метод для демонстрации функциональности классов.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Создаем несколько точек
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 0);
        Point point3 = new Point(1, 1);
        Point point4 = new Point(0, 1);

        // Демонстрируем методы Point
        System.out.println("Начальная point1: " + point1);
        point1.setCoordinates(2, 2);
        System.out.println("Point1 после установки новых координат: " + point1);

        // Создаем отрезок линии
        LineSegment line = new LineSegment(point1, point2);
        System.out.println(line);
        System.out.println("Длина линии: " + line.length());

        // Создаем прямоугольник
        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
        System.out.println(rectangle);
        System.out.println("Периметр прямоугольника: " + rectangle.perimeter());

        // Поворачиваем прямоугольник
        System.out.println("Поворачиваем прямоугольник на 45 градусов вокруг point1...");
        rectangle.rotate(45);
        System.out.println(rectangle);

        // Создаем два прямоугольника
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(2, 0), new Point(2, 1), new Point(0, 1));
        Rectangle rect2 = new Rectangle(new Point(1, 0), new Point(3, 0), new Point(3, 1), new Point(1, 1));
        Rectangle rect3 = new Rectangle(new Point(5, 5), new Point(7, 5), new Point(7, 6), new Point(5, 6));

        // Проверяем пересечение
        System.out.println("Пересекается ли rect1 с rect2? " + rect1.intersects(rect2)); // Должно пересекаться
        System.out.println("Пересекается ли rect1 с rect3? " + rect1.intersects(rect3)); // Не должно пересекаться
        System.out.println("Пересекается ли rect1 с null? " + rect1.intersects(null)); // Не должно пересекаться

        try {
            Rectangle invalidRect = new Rectangle(null, new Point(1,1), new Point(2,2), new Point(3,3));
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }
    }
}