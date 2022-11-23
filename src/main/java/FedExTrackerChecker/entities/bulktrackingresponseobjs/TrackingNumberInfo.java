package FedExTrackerChecker.entities.bulktrackingresponseobjs;

import java.util.LinkedHashMap;
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
        "trackingNumberUniqueId",
        "carrierCode"
})
@Generated("jsonschema2pojo")
public class TrackingNumberInfo {

    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("trackingNumberUniqueId")
    private String trackingNumberUniqueId;
    @JsonProperty("carrierCode")
    private String carrierCode;
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

    public TrackingNumberInfo withTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    @JsonProperty("trackingNumberUniqueId")
    public String getTrackingNumberUniqueId() {
        return trackingNumberUniqueId;
    }

    @JsonProperty("trackingNumberUniqueId")
    public void setTrackingNumberUniqueId(String trackingNumberUniqueId) {
        this.trackingNumberUniqueId = trackingNumberUniqueId;
    }

    public TrackingNumberInfo withTrackingNumberUniqueId(String trackingNumberUniqueId) {
        this.trackingNumberUniqueId = trackingNumberUniqueId;
        return this;
    }

    @JsonProperty("carrierCode")
    public String getCarrierCode() {
        return carrierCode;
    }

    @JsonProperty("carrierCode")
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public TrackingNumberInfo withCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
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

    public TrackingNumberInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TrackingNumberInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("trackingNumber");
        sb.append('=');
        sb.append(((this.trackingNumber == null) ? "<null>" : this.trackingNumber));
        sb.append(',');
        sb.append("trackingNumberUniqueId");
        sb.append('=');
        sb.append(((this.trackingNumberUniqueId == null) ? "<null>" : this.trackingNumberUniqueId));
        sb.append(',');
        sb.append("carrierCode");
        sb.append('=');
        sb.append(((this.carrierCode == null) ? "<null>" : this.carrierCode));
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
        result = ((result * 31) + ((this.trackingNumberUniqueId == null) ? 0 : this.trackingNumberUniqueId.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.trackingNumber == null) ? 0 : this.trackingNumber.hashCode()));
        result = ((result * 31) + ((this.carrierCode == null) ? 0 : this.carrierCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrackingNumberInfo) == false) {
            return false;
        }
        TrackingNumberInfo rhs = ((TrackingNumberInfo) other);
        return (((((this.trackingNumberUniqueId == rhs.trackingNumberUniqueId) || ((this.trackingNumberUniqueId != null) && this.trackingNumberUniqueId.equals(rhs.trackingNumberUniqueId))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.trackingNumber == rhs.trackingNumber) || ((this.trackingNumber != null) && this.trackingNumber.equals(rhs.trackingNumber)))) && ((this.carrierCode == rhs.carrierCode) || ((this.carrierCode != null) && this.carrierCode.equals(rhs.carrierCode))));
    }

}
