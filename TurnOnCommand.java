package smarthomesystem;

public class TurnOnCommand implements Command {
    private SmartDevice device;

    public TurnOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
