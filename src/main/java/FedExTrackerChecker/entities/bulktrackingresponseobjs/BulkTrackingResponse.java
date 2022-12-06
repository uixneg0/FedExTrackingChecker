package FedExTrackerChecker.entities.bulktrackingresponseobjs;

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
        "transactionId",
        "output"
})
@Generated("jsonschema2pojo")
public class BulkTrackingResponse {

    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("output")
    private Output output;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BulkTrackingResponse withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @JsonProperty("output")
    public Output getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(Output output) {
        this.output = output;
    }

    public BulkTrackingResponse withOutput(Output output) {
        this.output = output;
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

    public BulkTrackingResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BulkTrackingResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null) ? "<null>" : this.transactionId));
        sb.append(',');
        sb.append("output");
        sb.append('=');
        sb.append(((this.output == null) ? "<null>" : this.output));
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
        result = ((result * 31) + ((this.output == null) ? 0 : this.output.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.transactionId == null) ? 0 : this.transactionId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BulkTrackingResponse) == false) {
            return false;
        }
        BulkTrackingResponse rhs = ((BulkTrackingResponse) other);
        return ((((this.output == rhs.output) || ((this.output != null) && this.output.equals(rhs.output))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.transactionId == rhs.transactionId) || ((this.transactionId != null) && this.transactionId.equals(rhs.transactionId))));
    }

    public List<CompleteTrackResult> getCompleteTrackResults(){
        Output output = this.getOutput();
        if (output == null) return null;
        return output.getCompleteTrackResults();
    }

}
