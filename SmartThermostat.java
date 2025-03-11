package smarthomesystem;

public class SmartThermostat implements SmartDevice {
    private String name;
    private boolean isOn;
    private double temperature;

    public SmartThermostat(String name, double temperature) {
        this.name = name;
        this.isOn = false;
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    @Override
    public void setSetting(String setting, Object value) {
        if (setting.equalsIgnoreCase("temperature")) {
            temperature = Double.parseDouble(value.toString());
            System.out.println(name + " temperature set to " + temperature + "°C.");
        } else {
            System.out.println("Invalid setting for " + name);
        }
    }

    @Override
    public String getStatus() {
        return "Thermostat: " + name + " | Status: " + (isOn ? "ON" : "OFF") + " | Temperature: " + temperature + "°C";
    }

    @Override
    public String getName() {
        return name;
    }
}
