package chapter07.readFiveTimes;

public class Practice7_4_R5 {
    public static void main(String[] args) {
        MyTv7_4_R5 t = new MyTv7_4_R5();

        t.setChannel(10);
        System.out.println("CH:" + t.getChannel());
        t.setVolume(20);
        System.out.println("VOL:" + t.getVolume());
    }
}
