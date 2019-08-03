package core;

import core.commands.interfaces.Command;

public interface CommandFactory {

    Command produce(String type);
}
