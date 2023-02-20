import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class MainTest {


    @Test
    public void main() throws InterruptedException {
        File file = new File("lib", "jacob-1.20-x64.dll"); //path to the jacob dll
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

        AutoItX x = new AutoItX();
        String notepad = "C:\\Users\\alber\\OneDrive\\Рабочий стол\\Tests.txt - Notepad++ [Administrator]";
        String notepad2 = "*C:\\Users\\alber\\OneDrive\\Рабочий стол\\Tests.txt - Notepad++ [Administrator]";
        String testString = "Some text";
        x.run("C:\\Program Files\\Notepad++\\notepad++.exe");
        x.winMenuSelectItem("C:\\Users\\alber\\OneDrive\\Рабочий стол\\Tests.txt - Notepad++ [Administrator]",
                            "",
                            "&Файл",
                            "&Сохранить");
        Thread.sleep(1000);
        x.winWaitActive(notepad);
        Thread.sleep(1000);
        x.send(testString);
        Thread.sleep(1000);
        String text = x.controlGetText(notepad2, "","[CLASS:SysTabControl32; INSTANCE:5]");
        Assert.assertEquals("Tab", text);
        x.winClose(notepad2);
        x.send("!n");
    }
}
