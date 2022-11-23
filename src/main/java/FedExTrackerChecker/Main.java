package FedExTrackerChecker;

import FedExTrackerChecker.excel.ExcelUtils;
import FedExTrackerChecker.requests.FedExRequest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static String oAuthToken = "";
    public static File trackingFolder;
    public static ArrayList<ArrayList<Long>> trackingSets = new ArrayList<>();  // Represents tracking numbers of each individual file


    public static void main(String... args) throws IllegalAccessException, IOException, InvalidFormatException {
        oAuthToken = FedExRequest.getOAuthToken();
        trackingFolder = getTrackingFolder();

        if (trackingFolder.listFiles() == null) exit("No files found within folder");
        for (File file : Objects.requireNonNull(trackingFolder.listFiles())) {
            if (file.getName().contains("xlsx") || file.getName().contains("xls")) {
                ArrayList<Long> trackingSet = ExcelUtils.getTrackingNumbers(file);
                trackingSets.add(trackingSet);
            }
        }
        ArrayList<Thread> threads = new ArrayList<>();
        for (ArrayList<Long> trackingSet : trackingSets) {
            Thread t = new Thread(() -> ExcelUtils.dumpTrackingSet(trackingSet));
            threads.add(t);
            t.start();
        }
        outer:
        while (true) {
            for (Thread thread : threads) {
                if (thread.isAlive()) continue outer;
            }
            break;
        }
        System.out.println("Done!");
    }


    public static File getTrackingFolder() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter folder path.");
        String folderPath = myObj.nextLine();
        File folder = new File(folderPath);
        if (!folder.exists()) {
            exit("Folder path provided does not exist.");
        } else if (!folder.isDirectory()) {
            exit("Folder path provided is not a folder.");
        }
        return folder;
    }

    public static void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }
}