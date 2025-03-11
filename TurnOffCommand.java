package smarthomesystem;

public class TurnOffCommand implements Command {
    private SmartDevice device;

    public TurnOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
