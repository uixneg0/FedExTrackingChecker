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
        "option",
        "eligibility"
})
@Generated("jsonschema2pojo")
public class DeliveryOptionEligibilityDetail {

    @JsonProperty("option")
    private String option;
    @JsonProperty("eligibility")
    private String eligibility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("option")
    public String getOption() {
        return option;
    }

    @JsonProperty("option")
    public void setOption(String option) {
        this.option = option;
    }

    public DeliveryOptionEligibilityDetail withOption(String option) {
        this.option = option;
        return this;
    }

    @JsonProperty("eligibility")
    public String getEligibility() {
        return eligibility;
    }

    @JsonProperty("eligibility")
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public DeliveryOptionEligibilityDetail withEligibility(String eligibility) {
        this.eligibility = eligibility;
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

    public DeliveryOptionEligibilityDetail withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DeliveryOptionEligibilityDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("option");
        sb.append('=');
        sb.append(((this.option == null) ? "<null>" : this.option));
        sb.append(',');
        sb.append("eligibility");
        sb.append('=');
        sb.append(((this.eligibility == null) ? "<null>" : this.eligibility));
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
        result = ((result * 31) + ((this.eligibility == null) ? 0 : this.eligibility.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.option == null) ? 0 : this.option.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeliveryOptionEligibilityDetail) == false) {
            return false;
        }
        DeliveryOptionEligibilityDetail rhs = ((DeliveryOptionEligibilityDetail) other);
        return ((((this.eligibility == rhs.eligibility) || ((this.eligibility != null) && this.eligibility.equals(rhs.eligibility))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.option == rhs.option) || ((this.option != null) && this.option.equals(rhs.option))));
    }

}
