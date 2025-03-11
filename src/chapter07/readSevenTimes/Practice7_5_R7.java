package chapter07.readSevenTimes;

public class Practice7_5_R7 {
    public static void main(String[] args) {
        MyTv_C7_R7 tv = new MyTv_C7_R7();

        tv.setChannel(10);
        System.out.println("CH:" + tv.getChannel());
        tv.setChannel(20);
        System.out.println("CH:" + tv.getChannel());
        tv.gotoPrevChannel();
        System.out.println("CH:" + tv.getChannel());
        tv.gotoPrevChannel();
        System.out.println("CH:" + tv.getChannel());
    }
}
