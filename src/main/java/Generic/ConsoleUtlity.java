package Generic;

import com.sun.jna.Function;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

public class ConsoleUtlity {

    /**
     * This function make use of JNA to call windows specific function to enable virtual terminal sequence
     * It attempts to call GetStdHandle, GetConsoleMode and SetConsoleMode from kernel32.dll
     * Note: This will ONLY work in windows 10
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
}
