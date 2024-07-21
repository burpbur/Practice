package api;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class MyDrawer extends JPanel {
        //成員變量
        private LinkedList<Line> lines, rbin;
        private Color defColor;
        private int width;

        //建構子
        public MyDrawer(){
                lines = new LinkedList<>();//重新賦值
                rbin = new LinkedList<>();//重新賦值

                defColor = Color.blue;//顏色為藍
                width = 4;//設定寬度

                setBackground(Color.yellow);
                MyMouseListener listener = new MyMouseListener();
                addMouseListener(listener);
                addMouseMotionListener(listener);
        }


        private BufferedImage backgroundImage;

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }

                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(width));
                for (Line line : lines) {
                        g2d.setColor(line.getColor());
                        for (int i = 1; i < line.size(); i++) {
                                HashMap<String, Integer> p0 = line.getPoint(i - 1);
                                HashMap<String, Integer> p1 = line.getPoint(i);
                                g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
                        }
                }
        }

        public void setBackgroundImage(BufferedImage img) {
                this.backgroundImage = img;
                repaint();
        }
        //清除所有線條
        public void clear(){
                lines.clear();
                repaint();
        }
        //回到上一步
        public void undo() {
                if (lines.size() > 0) {
                        rbin.add(lines.removeLast());
                        repaint();
                }
        }
        //回到上一步2
        public void redo() {
                if (rbin.size() > 0) {
                        lines.add(rbin.removeLast());
                        repaint();
                }
        }
        //換顏色
        public void changeColor(Color newColor) {
                defColor = newColor;
        }
        //獲取當前顏色
        public Color getColor() {
                return defColor;
        }
        //將畫好的內容保存成jpeg文件
        public void saveJPEG() throws IOException {
                BufferedImage img =
                        new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics g = img.getGraphics();
                paint(g); // 將當前畫布繪製到 BufferedImage

                ImageIO.write(img, "JPEG", new File("dir1/test2.jpg"));// 保存 BufferedImage 為 JPEG 文件

        }
        // 保存線條列表到文件
        public void saveLine(File saveFile) throws Exception {
                ObjectOutputStream oout = new ObjectOutputStream(
                        new FileOutputStream(saveFile));
                oout.writeObject(lines);
                oout.flush();
                oout.close();
        }
        // 從文件加載線條列表
        public void loadLine(File loadFile) throws Exception {
                ObjectInputStream oin = new ObjectInputStream(
                        new FileInputStream(loadFile));
                Object temp = oin.readObject();

                //if (temp instanceof LinkedList<LineV2>) {
                lines = (LinkedList<Line>)temp;
                repaint();

                //}

        }
        // 新增載入 JPEG 的方法
        public void loadJPEG(File jpegFile) throws IOException {
                BufferedImage img = ImageIO.read(jpegFile);
                Graphics g = this.getGraphics();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        // 內部類別：處理鼠標事件
        private class MyMouseListener extends MouseAdapter {
                @Override
                //滑鼠按下時
                public void mousePressed(MouseEvent e) {
                        HashMap<String, Integer> point = new HashMap<String, Integer>();
                        point.put("x", e.getX()); point.put("y", e.getY());
                        Line line = new Line(defColor, 4);

                        line.addPoint(point);;
                        lines.add(line);
                        rbin.clear();
                }
                @Override
                //滑鼠拖動時
                public void mouseDragged(MouseEvent e) {
                        HashMap<String, Integer> point = new HashMap<String, Integer>();
                        point.put("x", e.getX()); point.put("y", e.getY());

                        lines.getLast().addPoint(point);;

                        repaint();
                }
        }


}
