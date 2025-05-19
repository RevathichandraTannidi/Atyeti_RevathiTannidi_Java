package abstraction.flexibleRemoteControlSystem.devices;

public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    void changeChannel(String channel);

}
