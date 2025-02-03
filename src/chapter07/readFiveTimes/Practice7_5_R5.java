package chapter07.readFiveTimes;

public class Practice7_5_R5 {
    public static void main(String[] args) {
        MyTv7_4_R5 t = new MyTv7_4_R5();

        t.setChannel(10);
        System.out.println("CH:" + t.getChannel());
        t.setChannel(20);
        System.out.println("CH:" + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:" + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:" + t.getChannel());
    }
}
