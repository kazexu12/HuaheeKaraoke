/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import SessionManagement.ADT.LinkedQueue;
import java.io.IOException;

/**
 *
 * @author zkang
 */
public class Playground {

    public static void charInputPlayground() throws IOException {
        MainClass.terminal.writer().println(Generic.ConsoleColor.ANSI_F_BRED + "Enter keys to show its integer values");
        MainClass.terminal.writer().println("Press 'enter' to go to next line");
        while (true) {
            int c = MainClass.terminal.reader().read();
            if (c == 27) {
                if (MainClass.terminal.reader().peek(0) == 79) {
                    MainClass.terminal.reader().read();
                    switch (MainClass.terminal.reader().read()) {
                        case 65:
                            MainClass.terminal.writer().print(Generic.ConsoleColor.WIN_CUR_UP);
                            break;
                        case 66:
                            MainClass.terminal.writer().print(Generic.ConsoleColor.WIN_CUR_DOWN);
                            break;
                        case 67:
                            MainClass.terminal.writer().print(Generic.ConsoleColor.WIN_CUR_RIGHT);
                            break;
                        case 68:
                            MainClass.terminal.writer().print(Generic.ConsoleColor.WIN_CUR_LEFT);
                            break;
                    }
                }
                continue;
            }
            if (c == 13) {
                MainClass.terminal.writer().println();
            } else {
                MainClass.terminal.writer().print(Generic.ConsoleColor.ANSI_RESET + c + " ");
            }
        }
    }
    
    public static void linkedQueuePG() {
        LinkedQueue<String> myqueue = new LinkedQueue<>();
        myqueue.enqueue("Item 1");
        myqueue.enqueue("Item 2");
        myqueue.enqueue("Item 3");
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
    }
}
