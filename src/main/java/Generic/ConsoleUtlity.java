package Generic;

import com.sun.jna.Function;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import java.io.IOException;

public class ConsoleUtlity {

    /**
     * This function make use of JNA to call windows specific function to enable
     * virtual terminal sequence It attempts to call GetStdHandle,
     * GetConsoleMode and SetConsoleMode from kernel32.dll Note: This will ONLY
     * work in windows 10
     */
    public static final void enableVirtualTerminalSequence() {
        // References:
        // https://stackoverflow.com/questions/52767585/how-can-you-use-vt100-escape-codes-in-java-on-windows
        // https://docs.microsoft.com/en-us/windows/console/console-virtual-terminal-sequences
        // https://www.programmersought.com/article/2941621212/

        // Set output mode to handle virtual terminal sequences
        Function GetStdHandleFunc = Function.getFunction("kernel32", "GetStdHandle");
        WinDef.DWORD STD_OUTPUT_HANDLE = new WinDef.DWORD(-11);
        WinNT.HANDLE hOut = (WinNT.HANDLE) GetStdHandleFunc.invoke(WinNT.HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

        WinDef.DWORDByReference p_dwMode = new WinDef.DWORDByReference(new WinDef.DWORD(0));
        Function GetConsoleModeFunc = Function.getFunction("kernel32", "GetConsoleMode");
        GetConsoleModeFunc.invoke(WinDef.BOOL.class, new Object[]{hOut, p_dwMode});

        int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
        WinDef.DWORD dwMode = p_dwMode.getValue();
        dwMode.setValue(dwMode.intValue() | ENABLE_VIRTUAL_TERMINAL_PROCESSING);
        Function SetConsoleModeFunc = Function.getFunction("kernel32", "SetConsoleMode");
        SetConsoleModeFunc.invoke(WinDef.BOOL.class, new Object[]{hOut, dwMode});
    }

    /**
     * Calls SetConsoleTextAttribute to change console color<br>
     * Supports older version of windows<br>
     *
     * <b>int color:</b><br>
     * 0 - black<br>
     * 1 - blue<br>
     * 2 - green<br>
     * 3 - light blue<br>
     * 4 - red<br>
     * 5 - purple<br>
     * 6 - gold<br>
     * 7 - white<br>
     * 8 - grey<br>
     * 9 - strong blue<br>
     * 10 - strong green<br>
     * 11 - strong light blue<br>
     * 12 - strong red<br>
     * 13 - strong purple<br>
     * 14 - strong gold<br>
     * 15 - strong white<br>
     *
     * @param foreground int color
     * @param background int color
     */
    public static final void setConsoleColor(int background, int foreground) {
        int colorValue = background * 16 + foreground;
        Function GetStdHandleFunc = Function.getFunction("kernel32", "GetStdHandle");
        WinDef.DWORD STD_OUTPUT_HANDLE = new WinDef.DWORD(-11);
        WinNT.HANDLE hOut = (WinNT.HANDLE) GetStdHandleFunc.invoke(WinNT.HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

        Function SetConsoleModeFunc = Function.getFunction("kernel32", "SetConsoleTextAttribute");
        SetConsoleModeFunc.invoke(WinDef.BOOL.class, new Object[]{hOut, colorValue});
    }

    public static final void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
