package chapter06.readSevenTimes;

public class Practice6_19_R7 {
    public static void main(String[] args) {
        MyTv_C6_R7 tv = new MyTv_C6_R7();

        tv.channel = 100;
        tv.volume = 0;
        System.out.println("CH:" + tv.channel + ", VOL:" + tv.volume);

        tv.channelDown();
        tv.volumeDown();
        System.out.println("CH:" + tv.channel + ", VOL:" + tv.volume);

        tv.volume = 100;
        tv.channelUp();
        tv.volumeUp();
        System.out.println("CH:" + tv.channel + ", VOL:" + tv.volume);
    }
}
