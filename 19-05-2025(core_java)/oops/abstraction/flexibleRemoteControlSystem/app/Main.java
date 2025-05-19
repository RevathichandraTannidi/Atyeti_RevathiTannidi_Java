package abstraction.flexibleRemoteControlSystem.app;

import abstraction.flexibleRemoteControlSystem.devices.Device;
import abstraction.flexibleRemoteControlSystem.devices.Radio;
import abstraction.flexibleRemoteControlSystem.remotes.AdvanceRemote;
import abstraction.flexibleRemoteControlSystem.remotes.BasicRemote;
import abstraction.flexibleRemoteControlSystem.remotes.RemoteControl;

public class Main {
    public static void main(String[] args) {
        Device radio = new Radio();
        RemoteControl basicRemote = new BasicRemote(radio);
        RemoteControl advancedRemote = new AdvanceRemote(radio);

        System.out.println("Using Basic Remote with Radio:");
        basicRemote.toggleUp();
        basicRemote.volumeup();
        basicRemote.changeChannel("FM 102.5");

        System.out.println("\nUsing Advanced Remote with Radio:");
        advancedRemote.toggleUp();
        advancedRemote.volumeDown();
        advancedRemote.changeChannel("FM 105.7");
        ((AdvanceRemote) advancedRemote).micAssistant();
        advancedRemote.toggleDown();
    }
}
