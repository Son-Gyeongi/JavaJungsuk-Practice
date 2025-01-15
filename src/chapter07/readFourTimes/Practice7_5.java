package chapter07.readFourTimes;

class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int preChannel; // 이전 채널

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void changePowerOn() {
        this.isPowerOn = !this.isPowerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        // 매개변수가 있는 메서드는 반드시 작업 전에 유효성 검사를 해야한다.
        if (!(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL)) {
            return;
        }

        this.preChannel = this.channel; // 현재 채널을 이전 채널에 저장한다.
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (!(MIN_VOLUME <= volume && volume <= MAX_VOLUME)) {
            return;
        }

        this.volume = volume;
    }

    public void gotoPrevChannel() {
        setChannel(this.preChannel); // 현재 채널을 이전 채널에 변경한다.
    }
}

public class Practice7_5 {
    public static void main(String[] args) {
        MyTv2 myTv = new MyTv2();

        myTv.setChannel(10);
        System.out.println("CH:" + myTv.getChannel());
        myTv.setChannel(20);
        System.out.println("CH:" + myTv.getChannel());
        myTv.gotoPrevChannel();
        System.out.println("CH:" + myTv.getChannel());
        myTv.gotoPrevChannel();
        System.out.println("CH:" + myTv.getChannel());
    }
}
