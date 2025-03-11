package chapter07.readSevenTimes;

/*
MyTv Chapter07 Read 7th
 */
public class MyTv_C7_R7 {
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
        if (!(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL)) return;

        this.prevChannel = this.channel; // 이전 채널에 현재 채널 저장
        this.channel = channel; // 현재 채널에 주어진 채널 저장
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (!(MIN_VOLUME <= volume && volume <= MAX_VOLUME)) return;

        this.volume = volume;
    }

    // 현재 채널을 이전 채널로 변경
    public void gotoPrevChannel() {
        setChannel(prevChannel);
    }
}
