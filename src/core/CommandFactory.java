package core;

public interface CommandFactory {

    Command produce(String type);
}
