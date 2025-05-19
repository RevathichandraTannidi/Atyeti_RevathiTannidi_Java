package abstraction.flexibleRemoteControlSystem.remotes;

import abstraction.flexibleRemoteControlSystem.devices.Device;

public class BasicRemote extends RemoteControl {

    public BasicRemote(Device device)
    {
        super(device);
    }
    @Override
    public void toggleUp() {
        System.out.println("just turn on ");

    }

    @Override
    public void toggleDown() {
        System.out.println("turn off");

    }

    @Override
    public void volumeup() {
       device.setVolume(68);

    }

    @Override
    public void volumeDown() {
        device.setVolume(20);

    }

    @Override
    public void changeChannel(String channel) {
        device.changeChannel(channel);

    }
    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted");
    }
}
