package smarthomesystem;

import java.util.List;
import java.util.Scanner;

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        Scanner scanner = new Scanner(System.in);

        // Adding devices
        controller.addDevice(new SmartLight("Living Room Light", 50));
        controller.addDevice(new SmartFan("Bedroom Fan", 3));
        controller.addDevice(new SmartThermostat("Hall Thermostat", 22.0));
        controller.addDevice(new SmartDoorLock("Main Door"));

        while (true) {
            System.out.println("\n1. Show All Devices");
            System.out.println("2. Control a Device");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting Smart Home System.");
                break;
            } else if (choice == 1) {
                controller.showAllDevices();
            } else if (choice == 2) {
                List<SmartDevice> devices = controller.getDevices();
                System.out.println("Select a device to control...");

                for (int i = 0; i < devices.size(); i++) {
                    System.out.println((i + 1) + ". " + devices.get(i).getName());
                }

                System.out.print("Enter device number: ");
                int deviceIndex = scanner.nextInt() - 1;

                if (deviceIndex < 0 || deviceIndex >= devices.size()) {
                    System.out.println("Invalid device selection.");
                    continue;
                }

                SmartDevice selectedDevice = devices.get(deviceIndex);

                if (selectedDevice instanceof SmartDoorLock) {
                    System.out.println("\n1. Lock");
                    System.out.println("2. Unlock");
                    System.out.print("Enter action: ");
                    int action = scanner.nextInt();

                    if (action == 1) {
                        controller.executeCommand(new TurnOnCommand(selectedDevice)); // Lock
                    } else if (action == 2) {
                        controller.executeCommand(new TurnOffCommand(selectedDevice)); // Unlock
                    } else {
                        System.out.println("Invalid action.");
                    }
                } else {
                    System.out.println("\n1. Turn On");
                    System.out.println("2. Turn Off");
                    System.out.println("3. Adjust Settings");
                    System.out.print("Enter action: ");
                    int action = scanner.nextInt();

                    if (action == 1) {
                        controller.executeCommand(new TurnOnCommand(selectedDevice));
                    } else if (action == 2) {
                        controller.executeCommand(new TurnOffCommand(selectedDevice));
                    } else if (action == 3) {
                        handleDeviceSettings(selectedDevice, scanner, controller);
                    } else {
                        System.out.println("Invalid action.");
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void handleDeviceSettings(SmartDevice device, Scanner scanner, SmartHomeController controller) {
        if (device instanceof SmartLight) {
            System.out.print("Enter brightness (0-100): ");
            int brightness = scanner.nextInt();
            controller.executeCommand(new AdjustSettingCommand(device, "brightness", brightness));
        } else if (device instanceof SmartFan) {
            System.out.print("Enter speed (1-5): ");
            int speed = scanner.nextInt();
            controller.executeCommand(new AdjustSettingCommand(device, "speed", speed));
        } else if (device instanceof SmartThermostat) {
            System.out.print("Enter temperature (°C): ");
            double temperature = scanner.nextDouble();
            controller.executeCommand(new AdjustSettingCommand(device, "temperature", temperature));
        } else {
            System.out.println("No adjustable settings available for this device.");
        }
    }
}
