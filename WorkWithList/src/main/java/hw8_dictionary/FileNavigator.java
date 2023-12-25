package hw8_dictionary;

import java.util.*;

public class FileNavigator {
    public static void main(String[] args) {

        List<FileData> filesList = new ArrayList<>();

        filesList.add(new FileData("Doc1", (byte) 125, "/Documents/lessons/day1"));
        filesList.add(new FileData("Doc2", (byte) 14, "/Documents/lessons/day1"));
        filesList.add(new FileData("Doc3", (byte) 42, "/Documents/lessons/day1"));
        filesList.add(new FileData("Doc4", (byte) 112, "/Documents/lessons/day2"));
        filesList.add(new FileData("Doc5", (byte) 110, "/Documents/lessons/day3"));

        Map<String, List<String>> mapFiles = addFiles(filesList);
        System.out.println();
        System.out.println("All files: " + mapFiles);
        System.out.println("----------------------");
        findFiles(mapFiles, "/Documents/lessons/day1");
        System.out.println("----------------------");
        filterBySize(filesList, (byte) 100);
        System.out.println("----------------------");
        sortBySize(filesList);
        removeFiles(mapFiles, "/Documents/lessons/day5");
        System.out.println("----------------------");
        System.out.println("After removing: " + mapFiles);

    }

    public static Map<String, List<String>> addFiles(List<FileData> filesList) {
        Map<String, List<String>> map = new HashMap<>();
        for (FileData file : filesList) {
            List<String> fileNames = new ArrayList<>();
            fileNames.add(file.getName());
//          fileNames.add(valueOf(file.getSize()));
            if (map.containsKey(file.getPath())) {
                map.get(file.getPath()).add(fileNames.toString());
            } else {
                map.put(file.getPath(), fileNames);
            }
        }
        return map;
    }

    public static void findFiles(Map<String, List<String>> map, String path) {
        for (Map.Entry<String, List<String>> mapEl : map.entrySet()) {
            if (mapEl.getKey().equals(path)) {
                System.out.println("Files in " + path + ": " + mapEl.getValue());
            }
        }
    }


    public static void filterBySize(List<FileData> filesList, byte size) {

        System.out.println("Files with size less than " + size + ":");
        for (FileData listEl : filesList) {
            byte fileSize = listEl.getSize();
            if (size >= fileSize) {
                System.out.println(listEl);
            }
        }
    }


    public static void removeFiles(Map<String, List<String>> map, String path) {
        String toRemove = null;
        for (Map.Entry<String, List<String>> mapEl : map.entrySet()) {
            if (mapEl.getKey().equals(path)) {
                toRemove = mapEl.getKey();
            }
        }
        map.remove(toRemove);
    }

    public static void sortBySize(List<FileData> filesList) {
        filesList.sort(new SizeComparator());
        System.out.println("Sorted List by size: " + filesList);
    }

    public static class SizeComparator implements Comparator<FileData> {
        @Override
        public int compare(FileData a, FileData b) {
            return a.getSize() - b.getSize();
        }
    }
}
