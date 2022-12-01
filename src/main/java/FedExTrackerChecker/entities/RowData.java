package FedExTrackerChecker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RowData {
    public final String trackingNumber;
    public final String dateAndTimeType;
    public final String dateAndTimeTime;
    public final String deliveryCity;
    public final String deliveryState;
    public final String deliveryAttempts;
    public final String deliveryReceivedBy;
    public final String latestDescription;
    public final String weight;
    public final String customerReference;
    public final String purchaseOrder;

    public RowData(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        dateAndTimeType = null;
        dateAndTimeTime = null;
        deliveryCity = null;
        deliveryState = null;
        deliveryAttempts = null;
        deliveryReceivedBy = null;
        latestDescription = null;
        weight = null;
        customerReference = null;
        purchaseOrder = null;
    }
}
