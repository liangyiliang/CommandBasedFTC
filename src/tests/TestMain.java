package tests;
import org.commandftc.*;

public class TestMain {

    public static void main(String[] args) {
        Command tc1 = new TestCommand("TC1", 1, 20);

        Command tc2 = new TestCommand("TC2", 21, 30);

        Command tc3 = new TestCommand("TC3", 90, 110);
        
        Command tc123 = tc1.andThen(tc2).also(tc3);
        CommandScheduler.scheduleCommand(tc123);
        
        int i = 0;
        while(i < 100) {
            CommandScheduler.runOnce();
            i++;
        }

        System.out.println("TESTING COMPLETE!");
    }
}