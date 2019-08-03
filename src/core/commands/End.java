package core.commands;

public class End implements core.commands.interfaces.Command {
    @Override
    public String execute(String[] args) {
        return args[0];
    }
}
