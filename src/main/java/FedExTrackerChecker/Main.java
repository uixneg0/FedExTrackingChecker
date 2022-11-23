package FedExTrackerChecker;

import FedExTrackerChecker.excel.ExcelParser;
import FedExTrackerChecker.requests.FedExRequest;
import okhttp3.Response;
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
                ArrayList<Long> trackingSet = ExcelParser.getTrackingNumbers(file);
                trackingSets.add(trackingSet);
            }
        }


        for (ArrayList trackingSet : trackingSets) {
            ArrayList<ArrayList<Long>> segmentedTracking = new ArrayList<>();
            ArrayList<Long> currSet = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < trackingSet.size(); i++) {
                count++;
                currSet.add((Long) trackingSet.get(i));

                if (count >= 30 || i == trackingSet.size() - 1) {
                    segmentedTracking.add(currSet);
                    currSet = new ArrayList<>();
                    count = 0;
                }
            }

            ArrayList<Response> responses = new ArrayList<>(); //todo add threading here tmrw when parsing responses
            for (ArrayList<Long> trackingSegment : segmentedTracking) {
                Response response = FedExRequest.getTrackingResults(trackingSegment);
                responses.add(response);
            }
        }
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
