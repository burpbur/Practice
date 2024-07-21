//package tutor;
//
//import api.MyClock;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.Calendar;
//
//public class MyWatch extends JFrame {
//
//    private ClockLabel clockLabel = new ClockLabel();
//    private JLabel weekLabel = new JLabel();
//    private JLabel dateLabel = new JLabel();
//    private JLabel timeLabel = new JLabel();
//    public MyClock myClock;
//
//
//
//    public MyWatch(){
//
//        myClock = new MyClock();
//        setLayout(new BorderLayout());
//        add(myClock,BorderLayout.CENTER);
//
//        setTitle("時鐘");
//        setVisible(true);//使窗口可見
//        setDefaultCloseOperation(EXIT_ON_CLOSE);//設置關閉操作
//        setBounds(300, 200, 800, 480);
//
//        init();
//
//
//
//    }
//
//    private void init(){
//
//    }
//
//    public static void main(String[] args){
//        new MyWatch();
//    }
//
//    class ClockLabel extends JFrame {
//
//        //定義常量
//        private final int width = 500;
//        private final int height = 440;
//        private final int Circle_x_radius = 150;
//        private final int Circle_y_radius = 150;
//        private final int Circle_x = 250;
//        private final int Circle_y = 250;
//
//        private final int Hour_Length = 70;
//        private final int Minute_Length = 100;
//        private final int Second_Length = 135;
//
//        private double arcHour = 0;
//        private double arcMinute = 0;
//        private double arcSecond = 0;
//
//        public ClockLabel(){
//            setSize(width,height);
//            Thread clockthread = new Thread(this);
//            clockthread.start();
//
//            Calendar calendar = Calendar.getInstance();
//
//            int hour = calendar.get(Calendar.HOUR_OF_DAY);
//            int minute = calendar.get(Calendar.MINUTE);
//            int second = calendar.get(Calendar.SECOND);
//
//            arcHour = calendar.get(Calendar.HOUR)*(360.0/12) +
//                      calendar.get(Calendar.MINUTE) * (360.0/12/60) +
//                      calendar.get(Calendar.SECOND) * (360.0/12/60/60);
//
//            arcMinute = calendar.get(Calendar.MINUTE) * (360.0/12/60) +
//                        calendar.get(Calendar.SECOND) * (360.0/12/60/60);
//
//            arcSecond = calendar.get(Calendar.SECOND) * (360.0/12/60/60);
//
//            }
//
//
//
//
//
//        }
//
//        @Override
//        protected void paintComponent(Graphics g){
//        super.paintComponents(g);
//        Graphics2D g2d = (Graphics2D) g.create();
//
//        for(int i = 0; i <360 ; i+=6){
//            if(i % 90 == 0){
//                g2d.setColor(Color.pink);
//                g2d.setStroke(new BasicStroke(7));
//            } else if (i % 30 == 0 ) {
//                g2d.setColor(Color.orange);
//                g2d.setStroke(new BasicStroke(3));
//            }else {
//                g2d.setColor(Color.GRAY);
//                g2d.setStroke(new BasicStroke(2));
//            }
//
//            double x1 = Circle_x + Math.cos(Math.toRadians(i)) * Circle;
//            double y1 = CIRCLE_y + Math.sin(Math.toRadians(i)) * CIRCLE_Y_RADIUS;
//            double x2 = CIRCLE_X + Math.cos(Math.toRadians(i)) * (CIRCLE_X_RADIUS - 10);
//            double y2 = CIRCLE_Y + Math.sin(Math.toRadians(i)) * (CIRCLE_Y_RADIUS - 10);
//            g2d.draw(new Line2D.Double(x1, y1, x2, y2));
//        }
//
//            // 繪制指針
//            g2d.setColor(Color.pink);
//            g2d.setStroke(new BasicStroke(8));
//            g2d.draw(new Line2D.Double(CIRCLE_X, CIRCLE_Y, CIRCLE_X + Math.cos(Math.toRadians(arcHour - 90)) * HOUR_LENGTH, CIRCLE_Y + Math.sin(Math.toRadians(arcHour - 90)) * HOUR_LENGTH));
//
//            g2d.setColor(Color.orange);
//            g2d.setStroke(new BasicStroke(4));
//            g2d.draw(new Line2D.Double(CIRCLE_X, CIRCLE_Y, CIRCLE_X + Math.cos(Math.toRadians(arcMin - 90)) * MIN_LENGTH, CIRCLE_Y + Math.sin(Math.toRadians(arcMin - 90)) * MIN_LENGTH));
//
//            g2d.setColor(Color.lightGray);
//            g2d.setStroke(new BasicStroke(1));
//            g2d.draw(new Line2D.Double(CIRCLE_X, CIRCLE_Y, CIRCLE_X + Math.cos(Math.toRadians(arcSec - 90)) * SEC_LENGTH, CIRCLE_Y + Math.sin(Math.toRadians(arcSec - 90)) * SEC_LENGTH));
//
//            g2d.dispose();
//        }
//
//    // 實現時鐘動畫效果的線程方法
//    @Override
//    public void run() {
//        try {
//            while (true) {
//
//                // 更新指針的角度
//                arcSec += 360.0 / 60 / 10;
//                arcMin += 360.0 / 60 / 60 / 10;
//                arcHour += 360.0 / 12 / 60 / 60 / 10;
//
//                // 判斷是否到達360度，若是則歸零
//                if (arcSec >= 360) {
//                    arcSec = 0;
//                }
//                if (arcMin >= 360) {
//                    arcMin = 0;
//                }
//                if (arcHour >= 360) {
//                    arcHour = 0;
//                }
//
//                // 重繪時鐘
//                repaint();
//                // 線程休眠一段時間
//                Thread.sleep(100);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//
//
//
