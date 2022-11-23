package FedExTrackerChecker.requests;

import FedExTrackerChecker.entities.RowData;
import FedExTrackerChecker.entities.bulktrackingresponseobjs.BulkTrackingResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class ResponseParser {
    public static ArrayList<RowData> parseResponses(Response response) throws IOException {
        ArrayList<RowData> rowDataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BulkTrackingResponse results = mapper.readValue(response.body().string(), BulkTrackingResponse.class);
        return rowDataList;
    }

    public static String getKeyValue(Response response, String key) {
        return "";
    }
}
