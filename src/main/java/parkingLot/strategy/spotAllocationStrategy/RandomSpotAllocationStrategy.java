package parkingLot.strategy.spotAllocationStrategy;

import parkingLot.enums.Status;
import parkingLot.enums.VehicleType;
import parkingLot.exception.ParkingSpotNotFoundException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategyInterface{
    private ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
        int currentFloor = gate.getFloorNumber();
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(currentFloor-1);

        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpotList()) {
            if(parkingSpot.getSupportedVehicleType().equals(vehicleType) && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                return parkingSpot;
            }
        }

        for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot : floor.getParkingSpotList()) {
                if(parkingSpot.getSupportedVehicleType().equals(vehicleType) && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                    return parkingSpot;
                }
            }
        }

        throw new ParkingSpotNotFoundException("No parking spot available for vechicle type " + vehicleType.name());
    }

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
}
