package Year2021.Day1;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathHelper {

    // ToDO recode getCombinePath method
    public String getCombinedPath(String onlyFullFilename)
    {
        // file system seperator
        char pathSeparator = File.separatorChar;

        // get path of src folder
        Path path = FileSystems.getDefault().getPath("");
        String mainClassPath = path.toAbsolutePath().toString();

        // get path of package folder
        String packagePath = this.getClass().getPackageName().replace('.', pathSeparator);

        // combine all to full path
        return mainClassPath + pathSeparator + "src" + pathSeparator + packagePath + pathSeparator + onlyFullFilename;
    }
}