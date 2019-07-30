package core;

import exceptions.ArgumentException;
import models.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;
}
