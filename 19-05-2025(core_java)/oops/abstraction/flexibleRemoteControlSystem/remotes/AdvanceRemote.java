package abstraction.flexibleRemoteControlSystem.remotes;

import abstraction.flexibleRemoteControlSystem.devices.Device;

public class AdvanceRemote extends RemoteControl{

    public AdvanceRemote(Device device) {
        super(device);
    }

    @Override
    public void toggleUp() {
        System.out.println("Turn on");

    }

    @Override
    public void toggleDown() {
        System.out.println("Turn off ");

    }

    @Override
    public void volumeup() {
        device.setVolume(79);

    }

    @Override
    public void volumeDown() {
        device.setVolume(20);

    }

    @Override
    public void changeChannel(String channel) {
        device.changeChannel(channel);

    }
    public void micAssistant()
    {
        System.out.println("just give command to me i will change --by your assitant \n Thank You");
    }
}
