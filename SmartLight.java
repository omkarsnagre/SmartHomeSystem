package smarthomesystem;

public class SmartLight implements SmartDevice {
    private String name;
    private boolean isOn;
    private int brightness;

    public SmartLight(String name, int brightness) {
        this.name = name;
        this.isOn = false;
        this.brightness = brightness;
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
        if (setting.equalsIgnoreCase("brightness")) {
            brightness = Integer.parseInt(value.toString());
            System.out.println(name + " brightness set to " + brightness + "%.");
        } else {
            System.out.println("Invalid setting for " + name);
        }
    }

    @Override
    public String getStatus() {
        return "Light: " + name + " | Status: " + (isOn ? "ON" : "OFF") + " | Brightness: " + brightness + "%";
    }

    @Override
    public String getName() {
        return name;
    }
}
