package abstraction.flexibleRemoteControlSystem.remotes;

import abstraction.flexibleRemoteControlSystem.devices.Device;

public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract  void toggleUp();
    public abstract void toggleDown();
    public abstract void volumeup();
    public abstract  void volumeDown();
    public abstract void changeChannel(String channel);
}
