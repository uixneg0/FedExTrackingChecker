package FedExTrackerChecker.entities.bulktrackingresponseobjs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "trackingNumber",
        "trackResults"
})
@Generated("jsonschema2pojo")
public class CompleteTrackResult {

    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("trackResults")
    private List<TrackResult> trackResults = new ArrayList<TrackResult>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("trackingNumber")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    @JsonProperty("trackingNumber")
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public CompleteTrackResult withTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    @JsonProperty("trackResults")
    public List<TrackResult> getTrackResults() {
        return trackResults;
    }

    @JsonProperty("trackResults")
    public void setTrackResults(List<TrackResult> trackResults) {
        this.trackResults = trackResults;
    }

    public CompleteTrackResult withTrackResults(List<TrackResult> trackResults) {
        this.trackResults = trackResults;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CompleteTrackResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CompleteTrackResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("trackingNumber");
        sb.append('=');
        sb.append(((this.trackingNumber == null) ? "<null>" : this.trackingNumber));
        sb.append(',');
        sb.append("trackResults");
        sb.append('=');
        sb.append(((this.trackResults == null) ? "<null>" : this.trackResults));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.trackResults == null) ? 0 : this.trackResults.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.trackingNumber == null) ? 0 : this.trackingNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CompleteTrackResult) == false) {
            return false;
        }
        CompleteTrackResult rhs = ((CompleteTrackResult) other);
        return ((((this.trackResults == rhs.trackResults) || ((this.trackResults != null) && this.trackResults.equals(rhs.trackResults))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.trackingNumber == rhs.trackingNumber) || ((this.trackingNumber != null) && this.trackingNumber.equals(rhs.trackingNumber))));
    }


    public String getPurchaseOrder() {
        List<PackageIdentifier> packageIdentifiers = this.getPackageIdentifiers();
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

    public String getCustomerReference() {
        List<PackageIdentifier> packageIdentifiers = this.getPackageIdentifiers();
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

    public List<PackageIdentifier> getPackageIdentifiers() {
        AdditionalTrackingInfo additionalTrackingInfo = this.getAdditionalTrackingInfo();
        if (additionalTrackingInfo == null) return null;
        return additionalTrackingInfo.getPackageIdentifiers();
    }

    public AdditionalTrackingInfo getAdditionalTrackingInfo() {
        TrackResult trackResult = this.getFirstTrackResult();
        if (trackResult == null) return null;
        return trackResult.getAdditionalTrackingInfo();
    }

    public String getWeight() {
        ShipmentDetails shipmentDetails = this.getShipmentDetails();
        if (shipmentDetails == null || shipmentDetails.getWeight() == null || shipmentDetails.getWeight().size() == 0 || shipmentDetails.getWeight().get(0) == null)
            return null;
        return shipmentDetails.getWeight().get(0).getValue();
    }

    public ShipmentDetails getShipmentDetails() {
        TrackResult trackResult = this.getFirstTrackResult();
        return trackResult.getShipmentDetails();
    }

    public String getLatestDescription() {
        LatestStatusDetail latestStatusDetail = this.getLatestStatusDetail();
        if (latestStatusDetail == null) return null;
        return latestStatusDetail.getDescription();
    }

    public LatestStatusDetail getLatestStatusDetail() {
        TrackResult trackResult = this.getFirstTrackResult();
        if (trackResult == null) return null;
        return trackResult.getLatestStatusDetail();
    }

    public String getDeliveryDestinationServiceArea() {
        DeliveryDetails deliveryDetails = this.getDeliveryDetails();
        if (deliveryDetails == null) return null;
        return deliveryDetails.getDestinationServiceArea();
    }

    public String getDeliveryReceivedBy() {
        DeliveryDetails deliveryDetails = this.getDeliveryDetails();
        if (deliveryDetails == null) return null;
        return deliveryDetails.getReceivedByName();
    }

    public String getDeliveryAttempts() {
        DeliveryDetails deliveryDetails = this.getDeliveryDetails();
        if (deliveryDetails == null) return null;
        return deliveryDetails.getDeliveryAttempts();
    }

    public String getDeliveryState() {
        ActualDeliveryAddress actualDeliveryAddress = this.getActualDeliveryAddress();
        if (actualDeliveryAddress == null) return null;
        return actualDeliveryAddress.getStateOrProvinceCode();
    }

    public String getDeliveryCity() {
        ActualDeliveryAddress actualDeliveryAddress = this.getActualDeliveryAddress();
        if (actualDeliveryAddress == null) return null;
        return actualDeliveryAddress.getCity();
    }

    public ActualDeliveryAddress getActualDeliveryAddress() {
        DeliveryDetails deliveryDetails = this.getDeliveryDetails();
        if (deliveryDetails == null) return null;
        return deliveryDetails.getActualDeliveryAddress();
    }

    public DeliveryDetails getDeliveryDetails() {
        TrackResult trackResult = this.getFirstTrackResult();
        if (trackResult == null) return null;
        return trackResult.getDeliveryDetails();
    }

    public String getDateAndTimeTime() {
        DateAndTime dateAndTime = this.getDateAndTime();
        if (dateAndTime == null) return null;
        return dateAndTime.getDateTime();
    }

    public String getDateAndTimeType() {
        DateAndTime dateAndTime = this.getDateAndTime();
        if (dateAndTime == null) return null;
        return dateAndTime.getType();
    }


    public DateAndTime getDateAndTime() {
        TrackResult trackResult = this.getFirstTrackResult();
        if (trackResult == null || trackResult.getDateAndTimes() == null || trackResult.getDateAndTimes().size() == 0)
            return null;
        return trackResult.getDateAndTimes().get(0);
    }

    public TrackResult getFirstTrackResult() {
        if (this.getTrackResults() == null) return null;
        return this.getTrackResults().get(0);
    }
}
