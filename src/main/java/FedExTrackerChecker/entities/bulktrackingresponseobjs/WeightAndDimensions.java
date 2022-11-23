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
        "weight",
        "dimensions"
})
@Generated("jsonschema2pojo")
public class WeightAndDimensions {

    @JsonProperty("weight")
    private List<Weight> weight = new ArrayList<Weight>();
    @JsonProperty("dimensions")
    private List<Dimension> dimensions = new ArrayList<Dimension>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("weight")
    public List<Weight> getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(List<Weight> weight) {
        this.weight = weight;
    }

    public WeightAndDimensions withWeight(List<Weight> weight) {
        this.weight = weight;
        return this;
    }

    @JsonProperty("dimensions")
    public List<Dimension> getDimensions() {
        return dimensions;
    }

    @JsonProperty("dimensions")
    public void setDimensions(List<Dimension> dimensions) {
        this.dimensions = dimensions;
    }

    public WeightAndDimensions withDimensions(List<Dimension> dimensions) {
        this.dimensions = dimensions;
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

    public WeightAndDimensions withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WeightAndDimensions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null) ? "<null>" : this.weight));
        sb.append(',');
        sb.append("dimensions");
        sb.append('=');
        sb.append(((this.dimensions == null) ? "<null>" : this.dimensions));
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
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.dimensions == null) ? 0 : this.dimensions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeightAndDimensions) == false) {
            return false;
        }
        WeightAndDimensions rhs = ((WeightAndDimensions) other);
        return ((((this.weight == rhs.weight) || ((this.weight != null) && this.weight.equals(rhs.weight))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.dimensions == rhs.dimensions) || ((this.dimensions != null) && this.dimensions.equals(rhs.dimensions))));
    }

}
