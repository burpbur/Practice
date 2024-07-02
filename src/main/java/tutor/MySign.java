package tutor;

import org.example.DrawLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MySign extends JFrame {

    public DrawLine drawLine;

    private JButton clear, undo, redo, color,width, saveJPEG,
                    saveLines, loadLines;

    public MySign(){
        super("My Sign");

        drawLine = new DrawLine();
        setLayout(new BorderLayout());
        add(drawLine,BorderLayout.CENTER);
        clear = new JButton("Clear");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        color = new JButton("Color");
        saveJPEG = new JButton("Save JPEG");
        saveLines = new JButton("Save Lines");
        loadLines = new JButton("Load Lines");

        setSize(800,480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void add(DrawLine drawLine, String center) {
    }
    private void addEvents(){
            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawLine.clear();
                }
            });

            undo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawLine.undo();
                }
            });

            redo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawLine.redo();
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
                        drawLine.saveJPEG();
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
    }

    private void saveLine(){
        JFileChooser jfc = new JFileChooser();
        if( jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File selectedFile = jfc.getSelectedFile();
                try{
                    drawLine.saveLine(selectedFile);
                    JOptionPane.showMessageDialog(null,"儲存成功");
                }catch (Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"儲存失敗");
                }
        }
    }


    private void loadLine(){
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File selectedFile = jfc.getSelectedFile();
            try{
                drawLine.loadLine(selectedFile);
            }catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "載入失敗");
            }
        }

    }


    public static void main(String[] args){
        new MySign();
    }
}
