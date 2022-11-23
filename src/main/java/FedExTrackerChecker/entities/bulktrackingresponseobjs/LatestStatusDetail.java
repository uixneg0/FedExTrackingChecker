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
        "code",
        "derivedCode",
        "statusByLocale",
        "description",
        "scanLocation",
        "ancillaryDetails"
})
@Generated("jsonschema2pojo")
public class LatestStatusDetail {

    @JsonProperty("code")
    private String code;
    @JsonProperty("derivedCode")
    private String derivedCode;
    @JsonProperty("statusByLocale")
    private String statusByLocale;
    @JsonProperty("description")
    private String description;
    @JsonProperty("scanLocation")
    private ScanLocation scanLocation;
    @JsonProperty("ancillaryDetails")
    private List<AncillaryDetail> ancillaryDetails = new ArrayList<AncillaryDetail>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public LatestStatusDetail withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("derivedCode")
    public String getDerivedCode() {
        return derivedCode;
    }

    @JsonProperty("derivedCode")
    public void setDerivedCode(String derivedCode) {
        this.derivedCode = derivedCode;
    }

    public LatestStatusDetail withDerivedCode(String derivedCode) {
        this.derivedCode = derivedCode;
        return this;
    }

    @JsonProperty("statusByLocale")
    public String getStatusByLocale() {
        return statusByLocale;
    }

    @JsonProperty("statusByLocale")
    public void setStatusByLocale(String statusByLocale) {
        this.statusByLocale = statusByLocale;
    }

    public LatestStatusDetail withStatusByLocale(String statusByLocale) {
        this.statusByLocale = statusByLocale;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public LatestStatusDetail withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("scanLocation")
    public ScanLocation getScanLocation() {
        return scanLocation;
    }

    @JsonProperty("scanLocation")
    public void setScanLocation(ScanLocation scanLocation) {
        this.scanLocation = scanLocation;
    }

    public LatestStatusDetail withScanLocation(ScanLocation scanLocation) {
        this.scanLocation = scanLocation;
        return this;
    }

    @JsonProperty("ancillaryDetails")
    public List<AncillaryDetail> getAncillaryDetails() {
        return ancillaryDetails;
    }

    @JsonProperty("ancillaryDetails")
    public void setAncillaryDetails(List<AncillaryDetail> ancillaryDetails) {
        this.ancillaryDetails = ancillaryDetails;
    }

    public LatestStatusDetail withAncillaryDetails(List<AncillaryDetail> ancillaryDetails) {
        this.ancillaryDetails = ancillaryDetails;
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

    public LatestStatusDetail withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LatestStatusDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code == null) ? "<null>" : this.code));
        sb.append(',');
        sb.append("derivedCode");
        sb.append('=');
        sb.append(((this.derivedCode == null) ? "<null>" : this.derivedCode));
        sb.append(',');
        sb.append("statusByLocale");
        sb.append('=');
        sb.append(((this.statusByLocale == null) ? "<null>" : this.statusByLocale));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("scanLocation");
        sb.append('=');
        sb.append(((this.scanLocation == null) ? "<null>" : this.scanLocation));
        sb.append(',');
        sb.append("ancillaryDetails");
        sb.append('=');
        sb.append(((this.ancillaryDetails == null) ? "<null>" : this.ancillaryDetails));
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
        result = ((result * 31) + ((this.scanLocation == null) ? 0 : this.scanLocation.hashCode()));
        result = ((result * 31) + ((this.code == null) ? 0 : this.code.hashCode()));
        result = ((result * 31) + ((this.derivedCode == null) ? 0 : this.derivedCode.hashCode()));
        result = ((result * 31) + ((this.ancillaryDetails == null) ? 0 : this.ancillaryDetails.hashCode()));
        result = ((result * 31) + ((this.statusByLocale == null) ? 0 : this.statusByLocale.hashCode()));
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LatestStatusDetail) == false) {
            return false;
        }
        LatestStatusDetail rhs = ((LatestStatusDetail) other);
        return ((((((((this.scanLocation == rhs.scanLocation) || ((this.scanLocation != null) && this.scanLocation.equals(rhs.scanLocation))) && ((this.code == rhs.code) || ((this.code != null) && this.code.equals(rhs.code)))) && ((this.derivedCode == rhs.derivedCode) || ((this.derivedCode != null) && this.derivedCode.equals(rhs.derivedCode)))) && ((this.ancillaryDetails == rhs.ancillaryDetails) || ((this.ancillaryDetails != null) && this.ancillaryDetails.equals(rhs.ancillaryDetails)))) && ((this.statusByLocale == rhs.statusByLocale) || ((this.statusByLocale != null) && this.statusByLocale.equals(rhs.statusByLocale)))) && ((this.description == rhs.description) || ((this.description != null) && this.description.equals(rhs.description)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
