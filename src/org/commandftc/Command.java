package org.commandftc;
import java.util.ArrayList;

public abstract class Command {
    private ArrayList<Subsystem> requirements = new ArrayList<>();

    /**
     * Returns a list of all subsystems required by this command.
     * @return a list of all subsystems required by this command
     */
    public ArrayList<Subsystem> getRequirements() {
        return requirements;
    }

    /**
     * Adds an arbitrary number of subsystems to the requirements of this command.
     */
    public void addRequirements(Subsystem ... sss) {
        for(Subsystem ss : sss) {
            requirements.add(ss);
        }
    }

    /**
     * The code in this method will only run once, when the command is scheduled.
     */
    public void init() {

    }

    /**
     * The code in this method will be executed continuously by the CommandScheduler until isFinished() returns true or the CommandScheduler ends the command.
     */
    public void execute() {

    }

    /**
     * The code in this method will run only once, when CommandScheduler ends this command (either by interrupting or by stopping it after isFinished() returns true).
     * @param interrupted true if the command ends while being interrupted by CommandScheduler, 
     *                    false otherwise.
     */
    public void end(boolean interrupted) {

    }

    /**
     * Returns whether this command is finished. Returning false tells CommandScheduler to continue calling the execute() method, and returning true tells it to end the command.
     * For a command that lasts throughout an entire game, for example, it should never "finish", i.e. isFinished() should always yield false.
     */
    public boolean isFinished() {
        return false;
    }
}