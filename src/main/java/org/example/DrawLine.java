package org.example;

import java.awt.*;
import java.util.LinkedList;

public class DrawLine {
    private LinkedList<Point> line;
    private Color color;
    private int width;

    public DrawLine (Color color , int width){
        this.color = color;
        this.width = width;
        line = new LinkedList<>();
    }

    public DrawLine() {

    }

    public void addPoint(Point point){
        line.add(point);
    }

    public Point getPoint(int index){
        return line.get(index);
    }
    public Color getColor() {return color;}
    public int getWidth() {return width;}
    public int size() {return line.size();}






}
