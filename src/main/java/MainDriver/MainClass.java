package MainDriver;

public class MainClass {

    public static void main(String[] args) throws Exception {
        Generic.ConsoleUtlity.enableVirtualTerminalSequence();
        System.out.print(Generic.ConsoleColor.ANSI_B_BLUE);
        System.out.print(Generic.ConsoleColor.ANSI_F_BWHITE);
        System.out.println("Hello, I am blue");
        new java.util.Scanner(System.in).nextLine();
    }
}
