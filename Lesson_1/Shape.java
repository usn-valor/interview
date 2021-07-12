package Interview.Lesson_1;

public class Shape {

    public void draw() {
        System.out.println("Draw Shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }
}

class Test {

    public static void main(String[] args) {
        Shape shape1 = new Circle();
        testShape(shape);
        Shape shape2 = new Square();
        testShape(shape2);
    }

    private static void testShape(Shape shape) {
        shape.draw();
    }
}

