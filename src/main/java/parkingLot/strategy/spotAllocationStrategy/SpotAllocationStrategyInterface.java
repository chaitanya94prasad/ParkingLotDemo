package parkingLot.strategy.spotAllocationStrategy;

import parkingLot.enums.VehicleType;
import parkingLot.models.Gate;
import parkingLot.models.ParkingSpot;

public interface SpotAllocationStrategyInterface {
    ParkingSpot getSpot(VehicleType vehicleType, Gate gate);
}
