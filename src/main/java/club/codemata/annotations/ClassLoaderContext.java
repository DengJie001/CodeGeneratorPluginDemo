package club.codemata.annotations;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassLoaderContext implements Context {
    private Class injectType;

    private static List<File> fileList;

    private static Map<String, Object> objectFactory = new HashMap<String, Object>();

    public void initContext() throws ClassNotFoundException {
        injectType = Class.forName("club.codemata.annotations.JsonFileResource");
        String filePath = this.getClass().getResource("").getFile();
    }
}
