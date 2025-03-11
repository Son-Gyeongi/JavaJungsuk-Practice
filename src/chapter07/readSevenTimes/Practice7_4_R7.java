package chapter07.readSevenTimes;

public class Practice7_4_R7 {
    public static void main(String[] args) {
        MyTv_C7_R7 myTv = new MyTv_C7_R7();

        myTv.setChannel(10);
        System.out.println("CH:" + myTv.getChannel());
        myTv.setVolume(20);
        System.out.println("VOL:" + myTv.getVolume());
    }
}
