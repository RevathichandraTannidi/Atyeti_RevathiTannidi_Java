package abstraction.flexibleRemoteControlSystem.devices;

import java.util.Scanner;

public class Tv implements  Device{



    @Override
    public void turnOn() {
        System.out.println("Turn on the Tv ");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the Tv");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("set the volume in the tv is"+volume);
    }

    @Override
    public void changeChannel(String channel) {

        System.out.println("change the channel in tv whatever we want"+channel);
    }
}
