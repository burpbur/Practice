package api;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyClock extends JLabel {
    //成員變量
    private Timer timer;
    private  int i;

    //定義建構式
    public MyClock(){
        timer = new Timer();//變量賦值，
        timer.schedule(new ClockTask(),0,100);//從現在開始每100毫秒執行一次
    }
    //定義內部類別
    private  class  ClockTask extends TimerTask{
         @Override
        public void  run(){
             Date now  = new Date();//拿到現在時間
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");//設置為這樣的時間格式
             setText(sdf.format(now));//將時間設至到JLabel文字中
         }
    }
}
