package hackerrank.Java;

import java.util.*;

class A {
    private int length;
    private int width;

    public A (int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area() {
        return this.length * this.width;
    }
}

class B extends A {
    private int depth;

    public B(int length, int width, int depth) {
        super(length, width);
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int area() {
        return this.getLength() * this.getWidth() * this.getDepth();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        A a = new A(10, 5);
        B b = new B(10, 40, 2);
    
        A a2 = new B(10, 40, 60);
        // A cannot be casted to B
        // B b2 = (B) new A(30, 21);

        System.out.println(a.area());
        System.out.println(b.area());
        System.out.println(a2.area());

        // Won't work due to reason given above in the comment
        // System.out.println(b2.area());
    }
}
