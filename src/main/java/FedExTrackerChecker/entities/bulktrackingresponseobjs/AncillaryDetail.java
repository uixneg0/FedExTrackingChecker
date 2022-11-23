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
        "reason",
        "reasonDescription",
        "action",
        "actionDescription"
})
@Generated("jsonschema2pojo")
public class AncillaryDetail {

    @JsonProperty("reason")
    private String reason;
    @JsonProperty("reasonDescription")
    private String reasonDescription;
    @JsonProperty("action")
    private String action;
    @JsonProperty("actionDescription")
    private String actionDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    public AncillaryDetail withReason(String reason) {
        this.reason = reason;
        return this;
    }

    @JsonProperty("reasonDescription")
    public String getReasonDescription() {
        return reasonDescription;
    }

    @JsonProperty("reasonDescription")
    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public AncillaryDetail withReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
        return this;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    public AncillaryDetail withAction(String action) {
        this.action = action;
        return this;
    }

    @JsonProperty("actionDescription")
    public String getActionDescription() {
        return actionDescription;
    }

    @JsonProperty("actionDescription")
    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public AncillaryDetail withActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
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

    public AncillaryDetail withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AncillaryDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reason");
        sb.append('=');
        sb.append(((this.reason == null) ? "<null>" : this.reason));
        sb.append(',');
        sb.append("reasonDescription");
        sb.append('=');
        sb.append(((this.reasonDescription == null) ? "<null>" : this.reasonDescription));
        sb.append(',');
        sb.append("action");
        sb.append('=');
        sb.append(((this.action == null) ? "<null>" : this.action));
        sb.append(',');
        sb.append("actionDescription");
        sb.append('=');
        sb.append(((this.actionDescription == null) ? "<null>" : this.actionDescription));
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
        result = ((result * 31) + ((this.reason == null) ? 0 : this.reason.hashCode()));
        result = ((result * 31) + ((this.action == null) ? 0 : this.action.hashCode()));
        result = ((result * 31) + ((this.reasonDescription == null) ? 0 : this.reasonDescription.hashCode()));
        result = ((result * 31) + ((this.actionDescription == null) ? 0 : this.actionDescription.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AncillaryDetail) == false) {
            return false;
        }
        AncillaryDetail rhs = ((AncillaryDetail) other);
        return ((((((this.reason == rhs.reason) || ((this.reason != null) && this.reason.equals(rhs.reason))) && ((this.action == rhs.action) || ((this.action != null) && this.action.equals(rhs.action)))) && ((this.reasonDescription == rhs.reasonDescription) || ((this.reasonDescription != null) && this.reasonDescription.equals(rhs.reasonDescription)))) && ((this.actionDescription == rhs.actionDescription) || ((this.actionDescription != null) && this.actionDescription.equals(rhs.actionDescription)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
