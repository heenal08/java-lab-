abstract class Shape {
    int a, b;

    abstract void printArea();
}

class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        a = length;
        b = breadth;
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

class Triangle extends Shape {

    Triangle(int base, int height) {
        a = base;
        b = height;
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));
    }
}

class Circle extends Shape {

    Circle(int radius) {
        a = radius;
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.14 * a * a));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape r = new Rectangle(10, 5);
        Shape t = new Triangle(8, 6);
        Shape c = new Circle(7);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}
