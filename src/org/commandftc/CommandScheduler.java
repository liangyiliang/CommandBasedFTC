package org.commandftc;
import java.util.*;

public final class CommandScheduler {

    /**
     * Subsystem and Default Command
     */
    private static final Map<Subsystem, Commmand> mapSsDefCmd;

    static {
        mapSsDefCmd = new LinkedHashMap<> ();
    }

    public static void setDefaultCommand(Subsystem ss, Command cmd) {
        if(cmd.isFinished()) {
            throw new IllegalArgumentException("Default commands shouldn't be finished.");
        }
        if(!cmd.getRequirements().contains(ss)) {
            throw new IllegalArgumentException("Default commands must require subsystem.");
        }
        mapSsDefCmd.put(ss, cmd);
    }

    public static Command getDefaultCommand(Subsystem ss) {
        return mapSsDefCmd.get(ss);
    }
}