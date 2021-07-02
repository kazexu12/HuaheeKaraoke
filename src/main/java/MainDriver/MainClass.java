package MainDriver;

public class MainClass {

    public static void main(String[] args) throws Exception {
        // Only works in Win10, probably dropping it
        // Generic.ConsoleUtlity.enableVirtualTerminalSequence();
        // System.out.print(Generic.ConsoleColor.ANSI_B_BLUE);
        // System.out.print(Generic.ConsoleColor.ANSI_F_BWHITE);
        Generic.ConsoleUtlity.setConsoleColor(10, 0);
        System.out.print("I am green");
        new java.util.Scanner(System.in).nextLine();
    }
}
