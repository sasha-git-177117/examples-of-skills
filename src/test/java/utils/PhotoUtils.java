package utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.FileSystems;

public class PhotoUtils {
    public static void ImportPhotoToSite(String path) {
        int waitingForExecution = 1000;
        String pathAvatar = FileSystems.getDefault().getPath(path).toAbsolutePath().toString();
        StringSelection photo = new StringSelection(pathAvatar);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(photo, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (robot != null) {
            robot.delay(waitingForExecution);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(waitingForExecution);
        }
    }
}
