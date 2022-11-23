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
        "type",
        "values",
        "trackingNumberUniqueId",
        "carrierCode"
})
@Generated("jsonschema2pojo")
public class PackageIdentifier {

    @JsonProperty("type")
    private String type;
    @JsonProperty("values")
    private List<String> values = new ArrayList<String>();
    @JsonProperty("trackingNumberUniqueId")
    private String trackingNumberUniqueId;
    @JsonProperty("carrierCode")
    private String carrierCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public PackageIdentifier withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("values")
    public List<String> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    public PackageIdentifier withValues(List<String> values) {
        this.values = values;
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

    public PackageIdentifier withTrackingNumberUniqueId(String trackingNumberUniqueId) {
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

    public PackageIdentifier withCarrierCode(String carrierCode) {
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

    public PackageIdentifier withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PackageIdentifier.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("values");
        sb.append('=');
        sb.append(((this.values == null) ? "<null>" : this.values));
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
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.values == null) ? 0 : this.values.hashCode()));
        result = ((result * 31) + ((this.carrierCode == null) ? 0 : this.carrierCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PackageIdentifier) == false) {
            return false;
        }
        PackageIdentifier rhs = ((PackageIdentifier) other);
        return ((((((this.trackingNumberUniqueId == rhs.trackingNumberUniqueId) || ((this.trackingNumberUniqueId != null) && this.trackingNumberUniqueId.equals(rhs.trackingNumberUniqueId))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))) && ((this.values == rhs.values) || ((this.values != null) && this.values.equals(rhs.values)))) && ((this.carrierCode == rhs.carrierCode) || ((this.carrierCode != null) && this.carrierCode.equals(rhs.carrierCode))));
    }

}
