package FedExTrackerChecker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RowData {
    private final String trackingNumber;
    private final String packageWeight;
    private final String sequenceNumber;
    private final String shipperCity;
    private final String actualDeliveryAddressCity;
    private final String deliveryAttempts;
    private final String deliverySignature;
    private final String eventDescription;
    private final String reference1;
    private final String reference2;
    private final String reference3;
}
