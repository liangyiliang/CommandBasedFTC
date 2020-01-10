package org.commandftc;
import java.util.*;

public final class CommandScheduler {

    /**
     * Subsystem and Default Command
     */
    private static final Map<Subsystem, Command> mapSsDefCmd;

    private static final ArrayList<Subsystem> subsystems;

    private static final ArrayList<Command> scheduledCommands;

    static {
        mapSsDefCmd = new LinkedHashMap<> ();
        subsystems = new ArrayList<Subsystem>();
        scheduledCommands = new ArrayList<Command>();
    }

    public static void setDefaultCommand(Subsystem ss, Command cmd) {
        if(cmd.isFinished()) {
            throw new IllegalArgumentException("Default commands shouldn't be finished.");
        }
        if(!cmd.getRequirements().contains(ss)) {
            throw new IllegalArgumentException("Default commands must require the subsystem.");
        }
        mapSsDefCmd.put(ss, cmd);
    }

    public static Command getDefaultCommand(Subsystem ss) {
        return mapSsDefCmd.get(ss);
    }

    public static void registerSubsystem(Subsystem subsystem) {
        subsystems.add(subsystem);
    }

    public static void scheduleCommand(Command cmd) {
        if(cmd.isFinished()) {
            throw new IllegalArgumentException("Cannot schedule a finished command.");
        }
        if(!subsystems.containsAll(cmd.getRequirements())) {
            throw new IllegalArgumentException("Cannot schedule command because requirement not met.");
        }
        scheduledCommands.add(cmd);
        cmd.init();
    }

    public static void scheduleCommands(Command ... cmds) {
        for(Command cmd : cmds) {
            scheduleCommand(cmd);
        }
    }

    public static void runOnce() {
        for(Subsystem ss : subsystems) {
            ss.periodic();
            mapSsDefCmd.get(ss).execute();
        }

        Command toRemove = null;
        for(Command cmd : scheduledCommands) {
            if(cmd.isFinished()) {
                cmd.end();
                toRemove = cmd;
            } else {
                cmd.execute();
            }
        }

        if(toRemove != null) {
            scheduledCommands.remove(toRemove);
        }
    }
}