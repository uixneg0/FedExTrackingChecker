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
        "possessionStatus",
        "weight"
})
@Generated("jsonschema2pojo")
public class ShipmentDetails {

    @JsonProperty("possessionStatus")
    private Boolean possessionStatus;
    @JsonProperty("weight")
    private List<Weight__1> weight = new ArrayList<Weight__1>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("possessionStatus")
    public Boolean getPossessionStatus() {
        return possessionStatus;
    }

    @JsonProperty("possessionStatus")
    public void setPossessionStatus(Boolean possessionStatus) {
        this.possessionStatus = possessionStatus;
    }

    public ShipmentDetails withPossessionStatus(Boolean possessionStatus) {
        this.possessionStatus = possessionStatus;
        return this;
    }

    @JsonProperty("weight")
    public List<Weight__1> getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(List<Weight__1> weight) {
        this.weight = weight;
    }

    public ShipmentDetails withWeight(List<Weight__1> weight) {
        this.weight = weight;
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

    public ShipmentDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ShipmentDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("possessionStatus");
        sb.append('=');
        sb.append(((this.possessionStatus == null) ? "<null>" : this.possessionStatus));
        sb.append(',');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null) ? "<null>" : this.weight));
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
        result = ((result * 31) + ((this.weight == null) ? 0 : this.weight.hashCode()));
        result = ((result * 31) + ((this.possessionStatus == null) ? 0 : this.possessionStatus.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShipmentDetails) == false) {
            return false;
        }
        ShipmentDetails rhs = ((ShipmentDetails) other);
        return ((((this.weight == rhs.weight) || ((this.weight != null) && this.weight.equals(rhs.weight))) && ((this.possessionStatus == rhs.possessionStatus) || ((this.possessionStatus != null) && this.possessionStatus.equals(rhs.possessionStatus)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
