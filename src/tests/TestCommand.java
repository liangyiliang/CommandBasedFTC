package tests;

import org.commandftc.Command;

public class TestCommand extends Command {
    private int i, ending;
    private String name;

    public TestCommand(String name, int starting, int ending) {
        this.name = name;
        this.i = starting;
        this.ending = ending;
    }
    
    @Override
    public void init() {
        System.out.println(name + " init");
    }
    @Override
    public void execute() {
        System.out.println(name + " value = " + i);
        i++;
    }
    @Override
    public void end() {
        if(!stopped) {
            System.out.println(name + " end");
            stopped = true;
        }
    }

    @Override
    public boolean isFinished() {
        return i > ending;
    }
}