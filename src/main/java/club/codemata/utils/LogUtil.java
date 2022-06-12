package club.codemata.utils;

import club.codemata.exception.LogFileException;

import javax.validation.constraints.Min;
import java.io.*;

public class LogUtil {
    /**
     * 获取log文件的全部内容
     * @param logFile log文件
     * @return
     * @throws IOException
     */
    public static String getLogContent(File logFile) throws IOException {
        InputStream inputStream = new FileInputStream(logFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        int ch;
        StringBuilder stringBuilder = new StringBuilder();
        while ((ch = inputStreamReader.read()) != -1) {
            stringBuilder.append((char) ch);
        }
        inputStream.close();
        inputStreamReader.close();
        return stringBuilder.toString();
    }

    /**
     * 获取log文件中指定行区间的内容
     * 如果start>end将会抛出异常
     * @param logFile log文件
     * @param start 开始行数（最小值：1，如果小于1会自动从第一行开始处理）
     * @param end 结束行数（最小值>=start）
     * @param split 获取的结果是否需要分行拼接
     * @return
     * @throws LogFileException
     */
    public static String readLine(File logFile, int start, int end, boolean split) throws LogFileException, IOException {
        if (logFile == null || !logFile.exists()) {
            throw new LogFileException("The file:logFile does not exist");
        }
        if (logFile.isDirectory()) {
            throw new LogFileException("The parameter:logFile should be a file instead of a folder");
        }
        if (start <= 0) {
            start = 1;
        }
        BufferedReader reader = new BufferedReader(new FileReader(logFile));
        StringBuilder stringBuilder = new StringBuilder();
        String str = null;
        int curLine = 1;
        while ((str = reader.readLine()) != null) {
            if (curLine < start) {
                ++curLine;
                continue;
            } else if (curLine++ <= end) {
                stringBuilder.append(str);
                if (split) {
                    stringBuilder.append("\n\r");
                }
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
