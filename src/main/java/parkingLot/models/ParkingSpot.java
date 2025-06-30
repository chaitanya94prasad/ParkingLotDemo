package parkingLot.models;

import parkingLot.enums.Status;
import parkingLot.enums.VehicleType;

public class ParkingSpot extends BaseModel {
    private int number;
    private VehicleType supportedVehicleType;
    private Status status;
    private Vehicle vehicle;
}
