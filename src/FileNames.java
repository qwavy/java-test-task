import java.io.File;

public class FileNames {
    private String prefix = "";
    private String dirName = "";

    public FileNames(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-p")) {
                prefix = args[i + 1];
            } else if (args[i].equals("-o")) {
                dirName = args[i + 1];
                File dir = new File(dirName);
                if (!dir.exists()) {
                    dir.mkdir();
                }
            }
        }
    }

    public String getPath() {
        String path = "";
        if (!dirName.isEmpty()) {
            path = dirName + "/";
        }
        if (!prefix.isEmpty()) {
            path += prefix + "_";
        }
        return path;
    }
}
