package com.luxoft.jva001p1.oop.TV;

import static com.luxoft.jva001p1.oop.TV.RCButtons.*;

public class TV {

    private boolean isTVOn;
    private int activeChannelNum;
    private int channelQuantity = 9;
    private int volume;
    private final int maxVolume;
    private String[] channles = new String[channelQuantity];

    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl rc = new RemoteControl();
        rc.setTv(tv);

        rc.clickButton(BTN_PW);
        //rc.clickButton(BTN_PW);

        rc.clickButton(BTN6);
        rc.clickButton(BTN1);
        rc.clickButton(BTN3);

        rc.clickButton(BTN_CH_DEC);
        rc.clickButton(BTN_CH_INC);

        System.out.println("Current volume "+tv.getVolume());
        rc.clickButton(BTN_VOL_INC);
        rc.clickButton(BTN_VOL_DEC);

    }

    public TV() {
        isTVOn = false;
        for (int i = 0; i < channles.length; i++) {
            channles[i] = "Channel_"+i;
        }
        activeChannelNum = 0;
        maxVolume = 10;
        volume = maxVolume / 3;
    }

    public boolean isTVOn() {
        return isTVOn;
    }

    public void setTVOn(boolean TVOn) {
        isTVOn = TVOn;
    }

    public void changeTVState(){
        isTVOn = !isTVOn;
        System.out.println("isTVOn = "+isTVOn);
     }

    public int getActiveChannelNum() {
        return activeChannelNum;
    }

    public void setActiveChannelNum(int activeChannelNum) {
        if (isTVOn){
            this.activeChannelNum = activeChannelNum;
            System.out.println(channles[activeChannelNum]);
        }

    }

    public void increaseChannel() {
        if (isTVOn && activeChannelNum < channelQuantity - 1){
            activeChannelNum++;
            System.out.println(channles[activeChannelNum]);
        }

    }
    public void decreaseChannel() {
        if (isTVOn && activeChannelNum > 0){
            activeChannelNum--;
            System.out.println(channles[activeChannelNum]);
        }

    }

    public int getVolume() {
        return volume;
    }

    public void increaseVolume() {
        if (isTVOn && volume < maxVolume){
            volume += 1;
            System.out.println("Volume "+volume);
        }
    }

    public void decreaseVolume() {
        if (isTVOn && volume > 0){
            volume -= 1;
            System.out.println("Volume "+volume);
        }
    }
}
