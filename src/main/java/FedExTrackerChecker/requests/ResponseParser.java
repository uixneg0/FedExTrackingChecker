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
        if (parsedResponse == null || parsedResponse.getOutput() == null) {
            System.out.println("Response was null or output was null.");
            return rowDataList;
        }
        List<CompleteTrackResult> completeTrackResults = parsedResponse.getOutput().getCompleteTrackResults();
        for (CompleteTrackResult completeTrackResult : completeTrackResults) {
            String trackingNumber = getTrackingNumber(completeTrackResult);
            TrackResult trackResult = getTrackResult(completeTrackResult); //TODO move all the static methods into bulk tracking response obj

            DateAndTime dateAndTime = getDateAndTime(trackResult);
            String dateAndTimeType = getDateAndTimeType(dateAndTime);
            String dateAndTimeTime = getDateAndTimeTime(dateAndTime);

            DeliveryDetails deliveryDetails = getDeliveryDetails(trackResult);
            ActualDeliveryAddress actualDeliveryAddress = getActualDeliveryAddress(deliveryDetails);
            String deliveryCity = getDeliveryCity(actualDeliveryAddress);
            String deliveryState = getDeliveryState(actualDeliveryAddress);

            String deliveryAttempts = getDeliveryAttempts(deliveryDetails);
            String deliveryReceivedBy = getDeliveryReceivedBy(deliveryDetails);
            String deliveryDestinationServiceArea = getDeliveryDestinationServiceArea(deliveryDetails);

            LatestStatusDetail latestStatusDetail = getLatestStatusDetail(trackResult);
            String latestDescription = getLatestDescription(latestStatusDetail);

            ShipmentDetails shipmentDetails = getShipmentDetails(trackResult);
            String weight = getWeight(shipmentDetails);

            AdditionalTrackingInfo additionalTrackingInfo = getAdditionalTrackingInfo(trackResult);
            List<PackageIdentifier> packageIdentifiers = getPackageIdentifiers(additionalTrackingInfo);
            String customerReference = getCustomerReference(packageIdentifiers);
            String purchaseOrder = getPurchaseOrder(packageIdentifiers);
            rowDataList.add(new RowData(trackingNumber, dateAndTimeType, dateAndTimeTime, deliveryCity, deliveryState, deliveryAttempts, deliveryReceivedBy, deliveryDestinationServiceArea, latestDescription, weight, customerReference, purchaseOrder));
        }
        return rowDataList;
    }

    public static String getPurchaseOrder(List<PackageIdentifier> packageIdentifiers) {
        if (packageIdentifiers == null) return null;
        for (PackageIdentifier packageIdentifier : packageIdentifiers) {
            if (packageIdentifier.getType().equalsIgnoreCase("PURCHASE_ORDER")) {
                List<String> values = packageIdentifier.getValues();
                if (values != null) {
                    for (String val : values) {
                        if (val != null) {
                            return val;
                        }
                    }
                }
            }

        }
        return null;
    }

    public static String getCustomerReference(List<PackageIdentifier> packageIdentifiers) {
        if (packageIdentifiers == null) return null;
        for (PackageIdentifier packageIdentifier : packageIdentifiers) {
            if (packageIdentifier.getType().equalsIgnoreCase("CUSTOMER_REFERENCE")) {
                List<String> values = packageIdentifier.getValues();
                if (values != null) {
                    for (String val : values) {
                        if (val != null) {
                            return val;
                        }
                    }
                }
            }

        }
        return null;
    }

    public static List<PackageIdentifier> getPackageIdentifiers(AdditionalTrackingInfo additionalTrackingInfo) {
        if (additionalTrackingInfo == null) return null;
        return additionalTrackingInfo.getPackageIdentifiers();
    }

    public static AdditionalTrackingInfo getAdditionalTrackingInfo(TrackResult trackResult) {
        if (trackResult == null) return null;
        return trackResult.getAdditionalTrackingInfo();
    }

    public static String getWeight(ShipmentDetails shipmentDetails) {
        if (shipmentDetails == null || shipmentDetails.getWeight() == null || shipmentDetails.getWeight().size() == 0 || shipmentDetails.getWeight().get(0) == null)
            return null;
        return shipmentDetails.getWeight().get(0).getValue();
    }

    public static ShipmentDetails getShipmentDetails(TrackResult trackResult) {
        if (trackResult == null) return null;
        return trackResult.getShipmentDetails();
    }

    public static String getLatestDescription(LatestStatusDetail latestStatusDetail) {
        if (latestStatusDetail == null) return null;
        return latestStatusDetail.getDescription();
    }

    public static LatestStatusDetail getLatestStatusDetail(TrackResult trackResult) {
        if (trackResult == null) return null;
        return trackResult.getLatestStatusDetail();
    }

    public static String getDeliveryDestinationServiceArea(DeliveryDetails deliveryDetails) {
        if (deliveryDetails == null) return null;
        return deliveryDetails.getDestinationServiceArea();
    }

    public static String getDeliveryReceivedBy(DeliveryDetails deliveryDetails) {
        if (deliveryDetails == null) return null;
        return deliveryDetails.getReceivedByName();
    }

    public static String getDeliveryAttempts(DeliveryDetails deliveryDetails) {
        if (deliveryDetails == null) return null;
        return deliveryDetails.getDeliveryAttempts();
    }

    public static String getDeliveryState(ActualDeliveryAddress actualDeliveryAddress) {
        if (actualDeliveryAddress == null) return null;
        return actualDeliveryAddress.getStateOrProvinceCode();
    }

    public static String getDeliveryCity(ActualDeliveryAddress actualDeliveryAddress) {
        if (actualDeliveryAddress == null) return null;
        return actualDeliveryAddress.getCity();
    }

    public static ActualDeliveryAddress getActualDeliveryAddress(DeliveryDetails deliveryDetails) {
        if (deliveryDetails == null) return null;
        return deliveryDetails.getActualDeliveryAddress();
    }

    public static DeliveryDetails getDeliveryDetails(TrackResult trackResult) {
        if (trackResult == null) return null;
        return trackResult.getDeliveryDetails();
    }

    public static String getDateAndTimeTime(DateAndTime dateAndTime) {
        if (dateAndTime == null) return null;
        return dateAndTime.getDateTime();
    }

    public static String getDateAndTimeType(DateAndTime dateAndTime) {
        if (dateAndTime == null) return null;
        return dateAndTime.getType();
    }


    public static DateAndTime getDateAndTime(TrackResult trackResult) {
        if (trackResult == null || trackResult.getDateAndTimes() == null || trackResult.getDateAndTimes().size() == 0)
            return null;
        return trackResult.getDateAndTimes().get(0);
    }

    public static TrackResult getTrackResult(CompleteTrackResult completeTrackResult) {
        if (completeTrackResult == null || completeTrackResult.getTrackResults() == null) return null;
        return completeTrackResult.getTrackResults().get(0);
    }

    public static String getTrackingNumber(CompleteTrackResult completeTrackResult) {
        if (completeTrackResult == null) return null;
        return completeTrackResult.getTrackingNumber();
    }
}
