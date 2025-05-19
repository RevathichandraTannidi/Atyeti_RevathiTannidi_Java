package abstraction.flexibleRemoteControlSystem.devices;


public class Radio implements Device{


    @Override
    public void turnOn() {
        System.out.println("Turn on the Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the radio");
    }

    @Override
    public void setVolume(int volume) {

        System.out.println("radio volume set to:"+volume);

    }

    @Override
    public void changeChannel(String channel) {

        System.out.println("radio channel changed to:"+channel);

    }
}
