package api;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Line implements Serializable {
    //成員變量
    private LinkedList<HashMap<String,Integer>> line;
    private Color color;
    private int width;

    //定義建構子  參數為Color color, int width 初始化line為空的LinkedList<>()
    public Line (Color color, int width){
       this.color = color;
       this.width = width;
       line = new LinkedList<>();
    }
    //定義方法
    public void addPoint(HashMap<String,Integer> point) {
        line.add(point);
    }
    public HashMap<String,Integer> getPoint(int index) {
        return line.get(index);
    }
    public Color getColor() {return color;}
    public int getWidth() {return width;}
    public int size() {return line.size();}
}
