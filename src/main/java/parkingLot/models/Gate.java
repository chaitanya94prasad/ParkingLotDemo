package parkingLot.models;

import parkingLot.enums.GateType;
import parkingLot.enums.Status;

public class Gate extends BaseModel {
    private int gateNumber;
    private Operator operator;
    private Status status;
    private GateType gateType;
    private int floorNumber;
}
