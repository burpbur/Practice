package tutor;

import api.MyClock;
import api.MyDrawer;
import org.example.DrawLine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MySign extends JFrame {
    //宣告成員變量
    public MyDrawer myDrawer;
    private MyClock myClock;
    private JButton clear, undo, redo, color, width, saveJPEG,
                    saveLines, loadLines, loadJPEG;

    //定義建構子
    public MySign(){

        super("My Sign");

        myDrawer = new MyDrawer();//初始化物件
        setLayout(new BorderLayout());//將JFrame布局設為BorderLayout
        add(myDrawer,BorderLayout.CENTER);//將myDrawer設置在中心位置
        //初始化按鈕
        clear = new JButton("Clear");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        color = new JButton("Color");
        saveJPEG = new JButton("Save JPEG");
        saveLines = new JButton("Save Lines");
        loadLines = new JButton("Load Lines");
        loadJPEG = new JButton("Load JPEG");
        myClock = new MyClock();

        setSize(800,480);//設置窗口大小
        setVisible(true);//使窗口可見
        setDefaultCloseOperation(EXIT_ON_CLOSE);//設置關閉操作

        JPanel top = new JPanel(new FlowLayout()); //創建flowLayout的布局
        //將按鈕添加到JPanel start
        top.add(clear); top.add(undo); top.add(redo); top.add(color);
        top.add(saveJPEG); top.add(saveLines); top.add(loadLines);top.add(loadJPEG);
        top.add(myClock);
        //將按鈕添加到JPanel end

        add(top, BorderLayout.NORTH);//添加位置

        addEvents();//調用上述按鈕方法
    }
    //按鈕事件方法
    private void addEvents(){
            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myDrawer.clear();
                }
            });

            undo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myDrawer.undo();
                }
            });

            redo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myDrawer.redo();
                }
            });

            color.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  changeColor();
                }
            });

            saveJPEG.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        myDrawer.saveJPEG();
                        JOptionPane.showMessageDialog(null, "Save JPEG success");
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Save JPEG failure");
                    }
                }
            });

            saveLines.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveLine();
                }
            });

            loadLines.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadLine();
                }
            });

            loadJPEG.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadJPEGImage(); // 新增載入 JPEG 圖片的方法
                }
            });

    }

    private void saveLine() {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            if (!selectedFile.getName().endsWith(".ser")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".ser");
            }
            try {
                myDrawer.saveLine(selectedFile);
                JOptionPane.showMessageDialog(null, "儲存成功");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "儲存失敗");
            }
        }
    }

    private void loadLine() {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            if (!selectedFile.getName().endsWith(".ser")) {
                JOptionPane.showMessageDialog(null, "請選擇正確的序列化文件");
                return;
            }
            try {
                myDrawer.loadLine(selectedFile);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "載入失敗");
            }
        }
    }
    private void loadJPEGImage() {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(selectedFile);
                myDrawer.setBackgroundImage(img);
            } catch (IOException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "載入 JPEG 失敗");
            }
        }
    }

    private void changeColor() {
        Color newColor = JColorChooser.showDialog(null, "Change Line Color", myDrawer.getColor());
        if (newColor != null) {
            myDrawer.changeColor(newColor);
        }
    }


    public static void main(String[] args){
        new MySign();
    }
}
