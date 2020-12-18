package combination.better;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {
    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir :
                subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        int sizeOfFiles = 0;
        for (FileSystemNode fileOrDir :
                subNodes) {
            sizeOfFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int j = 0;
        for (; j < size; ++j) {
            if (subNodes.get(j) .getPath() . equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }

        }
        if (j < size) { subNodes.remove(j); }
    }
}
