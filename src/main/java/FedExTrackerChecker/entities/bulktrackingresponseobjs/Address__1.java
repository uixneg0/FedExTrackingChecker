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
        "city",
        "stateOrProvinceCode",
        "countryCode",
        "residential",
        "countryName"
})
@Generated("jsonschema2pojo")
public class Address__1 {

    @JsonProperty("city")
    private String city;
    @JsonProperty("stateOrProvinceCode")
    private String stateOrProvinceCode;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("residential")
    private Boolean residential;
    @JsonProperty("countryName")
    private String countryName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Address__1 withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("stateOrProvinceCode")
    public String getStateOrProvinceCode() {
        return stateOrProvinceCode;
    }

    @JsonProperty("stateOrProvinceCode")
    public void setStateOrProvinceCode(String stateOrProvinceCode) {
        this.stateOrProvinceCode = stateOrProvinceCode;
    }

    public Address__1 withStateOrProvinceCode(String stateOrProvinceCode) {
        this.stateOrProvinceCode = stateOrProvinceCode;
        return this;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Address__1 withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @JsonProperty("residential")
    public Boolean getResidential() {
        return residential;
    }

    @JsonProperty("residential")
    public void setResidential(Boolean residential) {
        this.residential = residential;
    }

    public Address__1 withResidential(Boolean residential) {
        this.residential = residential;
        return this;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Address__1 withCountryName(String countryName) {
        this.countryName = countryName;
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

    public Address__1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Address__1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null) ? "<null>" : this.city));
        sb.append(',');
        sb.append("stateOrProvinceCode");
        sb.append('=');
        sb.append(((this.stateOrProvinceCode == null) ? "<null>" : this.stateOrProvinceCode));
        sb.append(',');
        sb.append("countryCode");
        sb.append('=');
        sb.append(((this.countryCode == null) ? "<null>" : this.countryCode));
        sb.append(',');
        sb.append("residential");
        sb.append('=');
        sb.append(((this.residential == null) ? "<null>" : this.residential));
        sb.append(',');
        sb.append("countryName");
        sb.append('=');
        sb.append(((this.countryName == null) ? "<null>" : this.countryName));
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
        result = ((result * 31) + ((this.residential == null) ? 0 : this.residential.hashCode()));
        result = ((result * 31) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((result * 31) + ((this.countryCode == null) ? 0 : this.countryCode.hashCode()));
        result = ((result * 31) + ((this.stateOrProvinceCode == null) ? 0 : this.stateOrProvinceCode.hashCode()));
        result = ((result * 31) + ((this.countryName == null) ? 0 : this.countryName.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address__1) == false) {
            return false;
        }
        Address__1 rhs = ((Address__1) other);
        return (((((((this.residential == rhs.residential) || ((this.residential != null) && this.residential.equals(rhs.residential))) && ((this.city == rhs.city) || ((this.city != null) && this.city.equals(rhs.city)))) && ((this.countryCode == rhs.countryCode) || ((this.countryCode != null) && this.countryCode.equals(rhs.countryCode)))) && ((this.stateOrProvinceCode == rhs.stateOrProvinceCode) || ((this.stateOrProvinceCode != null) && this.stateOrProvinceCode.equals(rhs.stateOrProvinceCode)))) && ((this.countryName == rhs.countryName) || ((this.countryName != null) && this.countryName.equals(rhs.countryName)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
