package com.example.tarea2;

public class Point {
    public double x, y;

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+MainActivity.formatDouble(this.x)+", "+MainActivity.formatDouble(this.y)+")";
    }
}
