package FedExTrackerChecker;

import FedExTrackerChecker.excel.ExcelUtils;
import FedExTrackerChecker.requests.FedExRequest;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import lombok.Getter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static String oAuthToken = "";
    @Getter
    public static File trackingFolder;
    public static List<List<Long>> trackingSets = new ArrayList<>();  // Represents tracking numbers of each individual file


    public static void main(String... args) throws IllegalAccessException, IOException, InvalidFormatException, InterruptedException {
        oAuthToken = FedExRequest.getNewOAuthToken();
        if (oAuthToken == null) exit("OAuth Token is null.");
        trackingFolder = getUserTrackingFolder();

        if (trackingFolder.listFiles() == null) exit("No files found within folder");
        for (File file : Objects.requireNonNull(trackingFolder.listFiles())) {
            if (file.getName().contains("xlsx") || file.getName().contains("xls")) {
                List<Long> trackingSet = ExcelUtils.parseTrackingNumbers(file);
                trackingSets.add(trackingSet);
            }
        }

        List<Thread> threads = new ArrayList<>();
        List<Workbook> workbooks = new ArrayList<>();
        for (List<Long> trackingSet : trackingSets) {
            Thread t = new Thread(() -> {
                try {
                    workbooks.add(ExcelUtils.buildWorkbook(trackingSet, oAuthToken));
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threads.add(t);
            t.start();
        }

        outer:
        while (true) {
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    Thread.sleep(150);
                    continue outer;
                }
            }
            break;
        }
        for (Workbook workbook : workbooks){
            writeWorkbook(workbook);
        }
        System.out.println("Done!");
    }


    public static void writeWorkbook(Workbook workbook){
        try {
            String randomString = UUID.randomUUID().toString().substring(0, 4);
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.getHour() + " " + localDateTime.getMinute();
            File folder = new File(trackingFolder + "/CheckedTracking");
            folder.mkdirs();
            FileOutputStream out = new FileOutputStream(folder.getAbsolutePath() + "/" + workbook.getSheetAt(0).getRow(1).getCell(9) + " " + time + " " + randomString + ".xlsx");
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static File getUserTrackingFolder() {
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
