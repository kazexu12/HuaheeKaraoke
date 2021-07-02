/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import org.jline.terminal.Terminal;

/**
 *
 * @author zkang
 */
public class Playground {

    public static void charInputPlayground(Terminal terminal) throws Exception {
        terminal.writer().println(Generic.ConsoleColor.ANSI_F_BRED + "Enter keys to show its integer values");
        terminal.writer().println("Press 'enter' to go to next line");
        while (true) {
            int c = terminal.reader().read();
            if (c == 27) {
                if (terminal.reader().peek(0) == 79) {
                    terminal.reader().read();
                    switch (terminal.reader().read()) {
                        case 65:
                            terminal.writer().print(Generic.ConsoleColor.WIN_CUR_UP);
                            break;
                        case 66:
                            terminal.writer().print(Generic.ConsoleColor.WIN_CUR_DOWN);
                            break;
                        case 67:
                            terminal.writer().print(Generic.ConsoleColor.WIN_CUR_RIGHT);
                            break;
                        case 68:
                            terminal.writer().print(Generic.ConsoleColor.WIN_CUR_LEFT);
                            break;
                    }
                }
                continue;
            }
            if (c == 13) {
                terminal.writer().println();
            } else {
                terminal.writer().print(Generic.ConsoleColor.ANSI_RESET + c + " ");
            }
        }
    }
}
