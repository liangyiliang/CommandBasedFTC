package org.commandftc;

import java.util.ArrayList;

public abstract class ParallelCommand extends Command {
    protected ArrayList<Command> commands;

    public ParallelCommand(Command ... commands) {
        this.commands = new ArrayList<Command> ();
        for(final Command cmd : commands) {
            addCommand(cmd);
        }
    }

    public void addCommand(Command cmd) {
        if(!cmd.isFinished()) {
            commands.add(cmd);
            addRequirements((Subsystem[])cmd.getRequirements().toArray());
        }
    }

    @Override
    public void init() {
        for(final Command cmd : commands) {
            cmd.init();
        }
    }

    @Override
    public void execute() {
        for(final Command cmd : commands) {
            if(cmd.isFinished()){
                cmd.end();
            } else {
                cmd.execute();
            }
        }
    }

    @Override
    public void end() {
        for(final Command cmd : commands) {
            cmd.end();
        }
    }

    @Override
    public abstract boolean isFinished();
}