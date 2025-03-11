package smarthomesystem;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    void setSetting(String setting, Object value);
    String getStatus();
    String getName();
}
