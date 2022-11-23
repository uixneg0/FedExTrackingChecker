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

}
