package club.codemata.utils;

import club.codemata.exception.LogFileException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class LogUtilTest {
    @Test
    public void testReadLine() throws LogFileException, IOException {
        String res = LogUtil.readLine(new File("e:\\JavaDemoFile\\log.txt"), 2, 2, true);
        System.out.println(res);
    }
}
