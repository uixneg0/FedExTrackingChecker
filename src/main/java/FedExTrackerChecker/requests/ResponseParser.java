package FedExTrackerChecker.requests;

import FedExTrackerChecker.entities.RowData;
import FedExTrackerChecker.entities.bulktrackingresponseobjs.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.apache.commons.math3.analysis.function.Add;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResponseParser {
    public static ArrayList<RowData> parseResponses(Response response) throws IOException {
        ArrayList<RowData> rowDataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BulkTrackingResponse parsedResponse = mapper.readValue(response.body().string(), BulkTrackingResponse.class);
        List<CompleteTrackResult> completeTrackResults = parsedResponse.getOutput().getCompleteTrackResults();
        for (CompleteTrackResult completeTrackResult : completeTrackResults) {
            String trackingNumber = completeTrackResult.getTrackingNumber();
            TrackResult trackResult = completeTrackResult.getTrackResults().get(0);

            DateAndTime dateAndTime = trackResult.getDateAndTimes().get(0);
            String dateAndTimeType = dateAndTime.getType();
            String dateAndTimeTime = dateAndTime.getDateTime();

            DeliveryDetails deliveryDetails = trackResult.getDeliveryDetails();
            ActualDeliveryAddress actualDeliveryAddress = deliveryDetails.getActualDeliveryAddress();
            String city = actualDeliveryAddress.getCity();
            String state = actualDeliveryAddress.getStateOrProvinceCode();
            String deliveryAttempts = deliveryDetails.getDeliveryAttempts();
            String receivedBy = deliveryDetails.getReceivedByName();
            String destinationServiceArea = deliveryDetails.getDestinationServiceArea();

            LatestStatusDetail latestStatusDetail = trackResult.getLatestStatusDetail();
            String latestDescription = latestStatusDetail.getDescription();

            String weight = trackResult.getShipmentDetails().getWeight().get(0).getValue();

            AdditionalTrackingInfo additionalTrackingInfo = trackResult.getAdditionalTrackingInfo();
            additionalTrackingInfo.getPackageIdentifiers()
        }
        return rowDataList;
    }
}
