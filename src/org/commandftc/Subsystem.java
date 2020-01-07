package org.commandftc;

public abstract class Subsystem {

    /**
     * This is equivalent to a default command, in which the CommandScheduler will run code in this method continuously.
     * @see setDefaultCommand
     * @see getDefaultCommand
     */
    void periodic () {

    }

    /**
     * A default command is executed whenever no other command is executed using this subsystem.
     * This function sets the default command.
     * @param command the command that needs to be the default command.
     */
    void setDefaultCommand(Command command) {
        CommandScheduler.setDefaultCommand(this, command);
    }

    /**
     * 
     * @return the default command.
     */
    Command getDefaultCommand() {
        return CommandScheduler.getDefaultCommand(this);
    }
}