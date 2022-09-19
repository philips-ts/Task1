package com.tarasenko.gof_patterns.behavioral;


interface Command{
    void execute();
}


class StartEngine implements Command {
    @Override
    public void execute() {
        System.out.println("Engine started.");
    }
}


class StopEngine implements Command {
    @Override
    public void execute() {
        System.out.println("Engine stopped.");
    }
}


class RemoteKey{
    private final Command startEngineCommand;
    private final Command stopEngineCommand;
    private boolean isStarted;

    public RemoteKey(Command startEngineCommand, Command stopEngineCommand) {
        this.startEngineCommand = startEngineCommand;
        this.stopEngineCommand = stopEngineCommand;
    }

    public void buttonPress() {
        if (isStarted) {
            stopEngineCommand.execute();
            isStarted = false;
        } else {
            startEngineCommand.execute();
            isStarted = true;
        }
    }
}




public class CommandPattern {
    public static void main(String[] args) {
        Command startEngine = new StartEngine();
        Command stopEngine = new StopEngine();

        RemoteKey remoteKey = new RemoteKey(startEngine, stopEngine);
        remoteKey.buttonPress();
        remoteKey.buttonPress();
        remoteKey.buttonPress();
        remoteKey.buttonPress();
        remoteKey.buttonPress();
    }
}

