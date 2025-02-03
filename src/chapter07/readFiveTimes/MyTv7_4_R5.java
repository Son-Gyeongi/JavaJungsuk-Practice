package chapter07.readFiveTimes;

public class MyTv7_4_R5 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int preChannel; // 이전 채널

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    // 현재 채널을 이전 채널로 변경한다.
    public void gotoPrevChannel() {
        setChannel(preChannel);
    }

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
        // 매개 변수가 있는 메서드는 반드시 작업 전에 유효성 검사를 해야한다.
        if (!(1 <= channel && channel <= 100)) return;
        this.preChannel = this.channel;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        // 매개 변수가 있는 메서드는 반드시 작업 전에 유효성 검사를 해야한다.
        if (!(0 <= volume && volume <= 100)) return;
        this.volume = volume;
    }
}
