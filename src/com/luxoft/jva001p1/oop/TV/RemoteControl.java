package com.luxoft.jva001p1.oop.TV;

public class RemoteControl {
    private TV tv;

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }

    public void clickButton(RCButtons button){
        switch(button){
            case BTN_PW:
                tv.changeTVState();
                break;
            case BTN1:
            case BTN2:
            case BTN3:
            case BTN4:
            case BTN5:
            case BTN6:
            case BTN7:
            case BTN8:
            case BTN9:
                tv.setActiveChannelNum(button.ordinal() - 1);
                break;
            case BTN_CH_INC:
                tv.increaseChannel();
                break;
            case BTN_CH_DEC:
                tv.decreaseChannel();
                break;
            case BTN_VOL_INC:
                tv.increaseVolume();
                break;
            case BTN_VOL_DEC:
                tv.decreaseVolume();
                break;
        }
    }
}
