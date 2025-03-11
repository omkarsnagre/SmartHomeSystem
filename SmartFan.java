package smarthomesystem;

public class SmartFan implements SmartDevice {
    private String name;
    private boolean isOn;
    private int speed;

    public SmartFan(String name, int speed) {
        this.name = name;
        this.isOn = false;
        this.speed = speed;
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
        if (setting.equalsIgnoreCase("speed")) {
            speed = Integer.parseInt(value.toString());
            System.out.println(name + " speed set to " + speed + ".");
        } else {
            System.out.println("Invalid setting for " + name);
        }
    }

    @Override
    public String getStatus() {
        return "Fan: " + name + " | Status: " + (isOn ? "ON" : "OFF") + " | Speed: " + speed;
    }

    @Override
    public String getName() {
        return name;
    }
}
