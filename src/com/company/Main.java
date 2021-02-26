package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface Func{
    int operation(int x, int y, int z);
}


public class Main {

    public static int operate (int x, int y, int z, Func lamda){
        return lamda.operation(x, y, z);
    }
    public static void main(String[] args) {

        Func lamdaExpression = (int x,int y, int z) -> x+y+z;

        int result = operate(5,10,15, lamdaExpression);
        System.out.println(result);

        System.out.println("Learning git feature");

        /*
        Numbers<Double> numbers = new Numbers();
        numbers.add(5.5);
        numbers.add(3.2);
        numbers.add(8.0);
        numbers.add(1.7);
        numbers.sortNumbers();
        numbers.displayList();
         */
        /*
        ShapeList<Shape> shapeList = new ShapeList();
        //shapeList.add("Hello");
        shapeList.add(new Circle(5));
        shapeList.add(new Rectangle(4,5));
        shapeList.add(new Circle(6));

        System.out.println("Number of circles: " + shapeList.calculateCircles());
        */

        /*
        try {
            Circle circle1 = Circle.class.newInstance();

            Field field = circle1.getClass().getDeclaredField("radius");
            Method[] method = circle1.getClass().getDeclaredMethods();
            field.setAccessible(true);
            field.set(circle1, 10);

            System.out.println(circle1);
            for (Method m:method) {
                System.out.println(m.getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        */








    }
}



class ShapeList<E> {
    private List<E> shapeList = new ArrayList<>();


    public void add(E s){
        shapeList.add(s);
    }
    public int calculateCircles(){
        int counter =0;
        for (E s:shapeList) {
            if (s instanceof Circle){
                counter++;
            }

        }
        return counter;
    }

}

abstract class Shape {
    private String color;
    private boolean filled;


    public Shape(){
        color = "red";
        filled = true;

    }

    public Shape (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "A shape with color of " + getColor() + " and " + (this.isFilled() ? "filled" : "not filled") + ")";
    }
}

class Circle extends Shape {
    private double radius;

    public  Circle(){
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public  double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public  double getPerimeter(){
        return 2 * Math.PI * radius;
    }



    @Override
    public String toString() {
        return "A Circle with radius=" + getRadius() + ", which is a subclass of " + super.toString();

    }
}


class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return 2*(width + length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of "+ super.toString() ;
    }
}
