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
        "packagingDescription",
        "physicalPackagingType",
        "sequenceNumber",
        "count",
        "weightAndDimensions",
        "packageContent"
})
@Generated("jsonschema2pojo")
public class PackageDetails {

    @JsonProperty("packagingDescription")
    private PackagingDescription packagingDescription;
    @JsonProperty("physicalPackagingType")
    private String physicalPackagingType;
    @JsonProperty("sequenceNumber")
    private String sequenceNumber;
    @JsonProperty("count")
    private String count;
    @JsonProperty("weightAndDimensions")
    private WeightAndDimensions weightAndDimensions;
    @JsonProperty("packageContent")
    private List<Object> packageContent = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("packagingDescription")
    public PackagingDescription getPackagingDescription() {
        return packagingDescription;
    }

    @JsonProperty("packagingDescription")
    public void setPackagingDescription(PackagingDescription packagingDescription) {
        this.packagingDescription = packagingDescription;
    }

    public PackageDetails withPackagingDescription(PackagingDescription packagingDescription) {
        this.packagingDescription = packagingDescription;
        return this;
    }

    @JsonProperty("physicalPackagingType")
    public String getPhysicalPackagingType() {
        return physicalPackagingType;
    }

    @JsonProperty("physicalPackagingType")
    public void setPhysicalPackagingType(String physicalPackagingType) {
        this.physicalPackagingType = physicalPackagingType;
    }

    public PackageDetails withPhysicalPackagingType(String physicalPackagingType) {
        this.physicalPackagingType = physicalPackagingType;
        return this;
    }

    @JsonProperty("sequenceNumber")
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("sequenceNumber")
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public PackageDetails withSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        return this;
    }

    @JsonProperty("count")
    public String getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(String count) {
        this.count = count;
    }

    public PackageDetails withCount(String count) {
        this.count = count;
        return this;
    }

    @JsonProperty("weightAndDimensions")
    public WeightAndDimensions getWeightAndDimensions() {
        return weightAndDimensions;
    }

    @JsonProperty("weightAndDimensions")
    public void setWeightAndDimensions(WeightAndDimensions weightAndDimensions) {
        this.weightAndDimensions = weightAndDimensions;
    }

    public PackageDetails withWeightAndDimensions(WeightAndDimensions weightAndDimensions) {
        this.weightAndDimensions = weightAndDimensions;
        return this;
    }

    @JsonProperty("packageContent")
    public List<Object> getPackageContent() {
        return packageContent;
    }

    @JsonProperty("packageContent")
    public void setPackageContent(List<Object> packageContent) {
        this.packageContent = packageContent;
    }

    public PackageDetails withPackageContent(List<Object> packageContent) {
        this.packageContent = packageContent;
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

    public PackageDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PackageDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("packagingDescription");
        sb.append('=');
        sb.append(((this.packagingDescription == null) ? "<null>" : this.packagingDescription));
        sb.append(',');
        sb.append("physicalPackagingType");
        sb.append('=');
        sb.append(((this.physicalPackagingType == null) ? "<null>" : this.physicalPackagingType));
        sb.append(',');
        sb.append("sequenceNumber");
        sb.append('=');
        sb.append(((this.sequenceNumber == null) ? "<null>" : this.sequenceNumber));
        sb.append(',');
        sb.append("count");
        sb.append('=');
        sb.append(((this.count == null) ? "<null>" : this.count));
        sb.append(',');
        sb.append("weightAndDimensions");
        sb.append('=');
        sb.append(((this.weightAndDimensions == null) ? "<null>" : this.weightAndDimensions));
        sb.append(',');
        sb.append("packageContent");
        sb.append('=');
        sb.append(((this.packageContent == null) ? "<null>" : this.packageContent));
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
        result = ((result * 31) + ((this.physicalPackagingType == null) ? 0 : this.physicalPackagingType.hashCode()));
        result = ((result * 31) + ((this.sequenceNumber == null) ? 0 : this.sequenceNumber.hashCode()));
        result = ((result * 31) + ((this.packagingDescription == null) ? 0 : this.packagingDescription.hashCode()));
        result = ((result * 31) + ((this.count == null) ? 0 : this.count.hashCode()));
        result = ((result * 31) + ((this.weightAndDimensions == null) ? 0 : this.weightAndDimensions.hashCode()));
        result = ((result * 31) + ((this.packageContent == null) ? 0 : this.packageContent.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PackageDetails) == false) {
            return false;
        }
        PackageDetails rhs = ((PackageDetails) other);
        return ((((((((this.physicalPackagingType == rhs.physicalPackagingType) || ((this.physicalPackagingType != null) && this.physicalPackagingType.equals(rhs.physicalPackagingType))) && ((this.sequenceNumber == rhs.sequenceNumber) || ((this.sequenceNumber != null) && this.sequenceNumber.equals(rhs.sequenceNumber)))) && ((this.packagingDescription == rhs.packagingDescription) || ((this.packagingDescription != null) && this.packagingDescription.equals(rhs.packagingDescription)))) && ((this.count == rhs.count) || ((this.count != null) && this.count.equals(rhs.count)))) && ((this.weightAndDimensions == rhs.weightAndDimensions) || ((this.weightAndDimensions != null) && this.weightAndDimensions.equals(rhs.weightAndDimensions)))) && ((this.packageContent == rhs.packageContent) || ((this.packageContent != null) && this.packageContent.equals(rhs.packageContent)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
