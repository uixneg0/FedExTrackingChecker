package FedExTrackerChecker.requests;

import FedExTrackerChecker.entities.RowData;
import FedExTrackerChecker.entities.bulktrackingresponseobjs.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResponseParser {
    public static ArrayList<RowData> parseResponse(Response response) throws IOException {
        ArrayList<RowData> rowDataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BulkTrackingResponse parsedResponse = mapper.readValue(response.body().string(), BulkTrackingResponse.class);
        if (parsedResponse == null) {
            System.out.println("Response was null.");
            return rowDataList;
        }
        if (parsedResponse.getOutput() == null){
            System.out.println("Output was null.");
            return rowDataList;
        }
        List<CompleteTrackResult> completeTrackResults = parsedResponse.getOutput().getCompleteTrackResults();
        for (CompleteTrackResult completeTrackResult : completeTrackResults) {
            String trackingNumber = completeTrackResult.getTrackingNumber();

            String dateAndTimeType = completeTrackResult.getDateAndTimeType();
            String dateAndTimeTime = completeTrackResult.getDateAndTimeTime();

            String deliveryCity = completeTrackResult.getDeliveryCity();
            String deliveryState = completeTrackResult.getDeliveryState();

            String deliveryAttempts = completeTrackResult.getDeliveryAttempts();
            String deliveryReceivedBy = completeTrackResult.getDeliveryReceivedBy();

            String latestDescription = completeTrackResult.getLatestDescription();

            String weight = completeTrackResult.getWeight();

            String customerReference = completeTrackResult.getCustomerReference();
            String purchaseOrder = completeTrackResult.getPurchaseOrder();
            rowDataList.add(new RowData(trackingNumber, dateAndTimeType, dateAndTimeTime, deliveryCity, deliveryState, deliveryAttempts, deliveryReceivedBy, latestDescription, weight, customerReference, purchaseOrder));
        }
        return rowDataList;
    }
}
