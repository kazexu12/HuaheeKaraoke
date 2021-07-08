package MainDriver;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Generic.DBManager;
public class MainClass {

    public static void main(String[] args) throws Exception {
        // Initializing DB
        DBManager db = new DBManager();
        db.prepareTable();
        
        // Initialising terminal
        Terminal terminal = TerminalBuilder.builder()
                .system(true).jna(true).type("windows-vtp")
                .build();
        terminal.enterRawMode();
        Playground.charInputPlayground(terminal);
    }
}
