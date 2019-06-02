package filesearch.serial;

import filesearch.utils.Result;

import java.io.File;
import java.util.Optional;

/**
 * 搜索串行版本
 */
public class SerialFileSearch {
    public static void searchFiles(File file, String fileName, Result result) {
        File[] contents;
        contents = file.listFiles();

        if ((contents == null) || (contents.length == 0)) {
            return;
        }
        for (File content :
                contents) {
            // 目录
            if (content.isDirectory()) {
                searchFiles(content, fileName, result);
            } else {
                if (content.getName().equals(fileName)) {
                    result.setPath(content.getAbsolutePath());
                    result.setFound(true);
                    System.out.println(String.format("Serial Search: Path: %s%n", result.getPath()));
                    return;
                }
            }
            if (result.isFound()) {
                return;
            }
        }
    }
}
