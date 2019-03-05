package com.luxoft.jva001p1.oop.TV;

public class TV {

    private TVState state;
    private int volume;
    private final int maxVolume;
    private String[] channles = new String[9];

    public static void main(String[] args) {
        TV tv = new TV();
        tv.setState(TVState.ON);
    }

    public TV() {
        for (int i = 0; i < channles.length; i++) {
            channles[i] = "Channel_"+i;
        }
        maxVolume = 10;
    }

    public TVState getState() {
        return state;
    }

    public void setState(TVState state) {
        this.state = state;
    }

    public int getVolume() {
        return volume;
    }

    public void increaseVolume() {
        if (volume < maxVolume){
            volume += 1;
        }
    }

    public void decreaseVolume() {
        if (volume > 0){
            volume -= 1;
        }
    }
}
