package MainDriver;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class MainClass {

    public static void main(String[] args) throws Exception {
        // Initialising terminal
        Terminal terminal = TerminalBuilder.builder()
                .system(true).jna(true).type("windows-vtp")
                .build();
        terminal.enterRawMode();
        Playground.charInputPlayground(terminal);
    }
}
