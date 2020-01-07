package org.commandftc;
import java.util.ArrayList;

public abstract class Command {
    private ArrayList<Subsystem> requirements = new ArrayList<>();
    public ArrayList<Subsystem> getRequirements() {
        return requirements;
    }
    public void addRequirements(Subsystem ... sss) {
        for(Subsystem ss : sss) {
            requirements.add(ss);
        }
    }

    public void init() {

    }

    public void execute() {

    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return false;
    }
}