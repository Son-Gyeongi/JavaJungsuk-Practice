package chapter07.readSixTimes;

class MyTv2_C6_R6 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prevChannel; // 이전 채널

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (channel < MIN_CHANNEL || channel > MAX_CHANNEL) return;

        this.prevChannel = this.channel;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < MIN_VOLUME || volume > MAX_VOLUME) return;

        this.volume = volume;
    }

    public void gotoPrevChannel() {
        // 현재의 채널을 이전 채널로 변경한다.
        setChannel(prevChannel);
    }
}

public class Practice7_5_R6 {
    public static void main(String[] args) {
        MyTv2_C6_R6 t = new MyTv2_C6_R6();

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
