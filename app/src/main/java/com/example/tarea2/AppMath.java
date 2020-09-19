package com.example.tarea2;

import android.annotation.SuppressLint;

public class AppMath {

    public static double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    }

    public static double slope(Point point1, Point point2) throws Exception {
        if (point1.x == point2.x) {
            throw new Exception("La pendiente para los valores X1, X2 iguales no está definida");
        }
        return (point2.y - point1.y) / (point2.x - point1.x);
    }

    public static double middlePoint(double p1, double p2) {
        return (p1 + p2) / 2;
    }

    public static Point middlePoint(Point point1, Point point2) {
        return new Point(middlePoint(point1.x, point2.x), middlePoint(point1.y, point2.y));
    }

    public static String getQuadrant(Point point)
    {
        if(point.x == 0 && point.y == 0)
            return point.toString() + " Se encuentra en el origen";

        if(point.x == 0)
        {
            if(point.y > 0) return point.toString() + " está entre el cuadrante I y II";
            else return point.toString() + " está entre el cuadrante III y IV ";
        }
        if (point.y == 0)
        {
            if (point.x > 0) return point.toString() + " está entre el cuadrante I y IV";
            else return point.toString() + " esta entre el cuadrante II y III";
        }
        if (point.x > 0) {
            if (point.y > 0)
                return point.toString() +" está en el cuadrante I";
            else if (point.y < 0)
                return point.toString() + " está en el cuadrante IV ";
        }
        if (point.x < 0) {
            if (point.y > 0) {
                return point.toString() + " está en el cuadrante II";
            } else if (point.y < 0) {
                return point.toString() + " está en el cuadrante III";
            }
        }

        return "Cuadrante no encontrado";
    }

    @SuppressLint("DefaultLocale")
    public String formatDouble(double number)
    {
        return (String) String.format("%.2f", number);
    }
}
