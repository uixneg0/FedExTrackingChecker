package FedExTrackerChecker.requests;

import FedExTrackerChecker.entities.RowData;
import okhttp3.Response;

import java.util.ArrayList;

public class ResponseParser {

    public static ArrayList<RowData> parseResponses() {
        ArrayList<RowData> rowDataList = new ArrayList<>();
        return rowDataList;
    }

    public static String getKeyValue(Response response, String key) {
        return "";
    }
}
