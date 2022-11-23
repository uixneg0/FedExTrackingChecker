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
        "date",
        "eventType",
        "eventDescription",
        "exceptionCode",
        "exceptionDescription",
        "scanLocation",
        "locationType",
        "derivedStatusCode",
        "derivedStatus"
})
@Generated("jsonschema2pojo")
public class ScanEvent {

    @JsonProperty("date")
    private String date;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("eventDescription")
    private String eventDescription;
    @JsonProperty("exceptionCode")
    private String exceptionCode;
    @JsonProperty("exceptionDescription")
    private String exceptionDescription;
    @JsonProperty("scanLocation")
    private ScanLocation__1 scanLocation;
    @JsonProperty("locationType")
    private String locationType;
    @JsonProperty("derivedStatusCode")
    private String derivedStatusCode;
    @JsonProperty("derivedStatus")
    private String derivedStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public ScanEvent withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public ScanEvent withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    @JsonProperty("eventDescription")
    public String getEventDescription() {
        return eventDescription;
    }

    @JsonProperty("eventDescription")
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public ScanEvent withEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
        return this;
    }

    @JsonProperty("exceptionCode")
    public String getExceptionCode() {
        return exceptionCode;
    }

    @JsonProperty("exceptionCode")
    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public ScanEvent withExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
        return this;
    }

    @JsonProperty("exceptionDescription")
    public String getExceptionDescription() {
        return exceptionDescription;
    }

    @JsonProperty("exceptionDescription")
    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    public ScanEvent withExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
        return this;
    }

    @JsonProperty("scanLocation")
    public ScanLocation__1 getScanLocation() {
        return scanLocation;
    }

    @JsonProperty("scanLocation")
    public void setScanLocation(ScanLocation__1 scanLocation) {
        this.scanLocation = scanLocation;
    }

    public ScanEvent withScanLocation(ScanLocation__1 scanLocation) {
        this.scanLocation = scanLocation;
        return this;
    }

    @JsonProperty("locationType")
    public String getLocationType() {
        return locationType;
    }

    @JsonProperty("locationType")
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public ScanEvent withLocationType(String locationType) {
        this.locationType = locationType;
        return this;
    }

    @JsonProperty("derivedStatusCode")
    public String getDerivedStatusCode() {
        return derivedStatusCode;
    }

    @JsonProperty("derivedStatusCode")
    public void setDerivedStatusCode(String derivedStatusCode) {
        this.derivedStatusCode = derivedStatusCode;
    }

    public ScanEvent withDerivedStatusCode(String derivedStatusCode) {
        this.derivedStatusCode = derivedStatusCode;
        return this;
    }

    @JsonProperty("derivedStatus")
    public String getDerivedStatus() {
        return derivedStatus;
    }

    @JsonProperty("derivedStatus")
    public void setDerivedStatus(String derivedStatus) {
        this.derivedStatus = derivedStatus;
    }

    public ScanEvent withDerivedStatus(String derivedStatus) {
        this.derivedStatus = derivedStatus;
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

    public ScanEvent withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ScanEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null) ? "<null>" : this.date));
        sb.append(',');
        sb.append("eventType");
        sb.append('=');
        sb.append(((this.eventType == null) ? "<null>" : this.eventType));
        sb.append(',');
        sb.append("eventDescription");
        sb.append('=');
        sb.append(((this.eventDescription == null) ? "<null>" : this.eventDescription));
        sb.append(',');
        sb.append("exceptionCode");
        sb.append('=');
        sb.append(((this.exceptionCode == null) ? "<null>" : this.exceptionCode));
        sb.append(',');
        sb.append("exceptionDescription");
        sb.append('=');
        sb.append(((this.exceptionDescription == null) ? "<null>" : this.exceptionDescription));
        sb.append(',');
        sb.append("scanLocation");
        sb.append('=');
        sb.append(((this.scanLocation == null) ? "<null>" : this.scanLocation));
        sb.append(',');
        sb.append("locationType");
        sb.append('=');
        sb.append(((this.locationType == null) ? "<null>" : this.locationType));
        sb.append(',');
        sb.append("derivedStatusCode");
        sb.append('=');
        sb.append(((this.derivedStatusCode == null) ? "<null>" : this.derivedStatusCode));
        sb.append(',');
        sb.append("derivedStatus");
        sb.append('=');
        sb.append(((this.derivedStatus == null) ? "<null>" : this.derivedStatus));
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
        result = ((result * 31) + ((this.date == null) ? 0 : this.date.hashCode()));
        result = ((result * 31) + ((this.derivedStatus == null) ? 0 : this.derivedStatus.hashCode()));
        result = ((result * 31) + ((this.scanLocation == null) ? 0 : this.scanLocation.hashCode()));
        result = ((result * 31) + ((this.exceptionDescription == null) ? 0 : this.exceptionDescription.hashCode()));
        result = ((result * 31) + ((this.eventDescription == null) ? 0 : this.eventDescription.hashCode()));
        result = ((result * 31) + ((this.locationType == null) ? 0 : this.locationType.hashCode()));
        result = ((result * 31) + ((this.eventType == null) ? 0 : this.eventType.hashCode()));
        result = ((result * 31) + ((this.derivedStatusCode == null) ? 0 : this.derivedStatusCode.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.exceptionCode == null) ? 0 : this.exceptionCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScanEvent) == false) {
            return false;
        }
        ScanEvent rhs = ((ScanEvent) other);
        return (((((((((((this.date == rhs.date) || ((this.date != null) && this.date.equals(rhs.date))) && ((this.derivedStatus == rhs.derivedStatus) || ((this.derivedStatus != null) && this.derivedStatus.equals(rhs.derivedStatus)))) && ((this.scanLocation == rhs.scanLocation) || ((this.scanLocation != null) && this.scanLocation.equals(rhs.scanLocation)))) && ((this.exceptionDescription == rhs.exceptionDescription) || ((this.exceptionDescription != null) && this.exceptionDescription.equals(rhs.exceptionDescription)))) && ((this.eventDescription == rhs.eventDescription) || ((this.eventDescription != null) && this.eventDescription.equals(rhs.eventDescription)))) && ((this.locationType == rhs.locationType) || ((this.locationType != null) && this.locationType.equals(rhs.locationType)))) && ((this.eventType == rhs.eventType) || ((this.eventType != null) && this.eventType.equals(rhs.eventType)))) && ((this.derivedStatusCode == rhs.derivedStatusCode) || ((this.derivedStatusCode != null) && this.derivedStatusCode.equals(rhs.derivedStatusCode)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.exceptionCode == rhs.exceptionCode) || ((this.exceptionCode != null) && this.exceptionCode.equals(rhs.exceptionCode))));
    }

}
