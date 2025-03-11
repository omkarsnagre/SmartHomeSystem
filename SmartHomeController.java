package smarthomesystem;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println(device.getName() + " added to the system.");
    }

    public void showAllDevices() {
        System.out.println("\n=====================================");
        System.out.println("       Smart Home Devices");
        System.out.println("=====================================");
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
        System.out.println("=====================================");
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }
}
