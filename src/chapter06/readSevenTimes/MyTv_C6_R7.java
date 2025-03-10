package chapter06.readSevenTimes;

/*
MyTv Chapter06 Read 7th
 */
public class MyTv_C6_R7 {
    boolean isPowerOn;
    int channel;
    int volume;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    void turnOff() {
        // isPowerOn 의 값이 true 면 false 로, false 면 true 로 바꾼다.
        this.isPowerOn = !isPowerOn;
    }

    void volumeUp() {
        // volume 의 값이 MAX_VOLUME 보다 작을 때만 값을 1 증가시킨다.
        if (volume < MAX_VOLUME) volume++;
    }

    void volumeDown() {
        // volume 의 값이 MIN_VOLUME 보다 클 때만 값을 1 감소시킨다.
        if (volume > MIN_VOLUME) volume--;
    }

    void channelUp() {
        /*
        channel 의 값을 1 증가시킨다.
        만일 channel 이 MAX_CHANNEL 이면, channel 의 값을 MIN_CHANNEL 로 바꾼다.
         */
        if (channel == MAX_CHANNEL) channel = MIN_CHANNEL;
        else channel++;
    }

    void channelDown() {
        /*
        channel 의 값을 1 감소시킨다.
        만일 channel 이 MIN_CHANNEL 이면, channel 의 값을 MAX_CHANNEL 로 바꾼다.
         */
        if (channel == MIN_CHANNEL) channel = MAX_CHANNEL;
        else channel--;
    }
}
