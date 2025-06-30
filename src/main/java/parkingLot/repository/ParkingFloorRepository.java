package parkingLot.repository;

import parkingLot.exception.ParkingFloorNotFoundException;
import parkingLot.models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorNumber) {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorNumber);
        if(parkingFloor == null) {
            throw new ParkingFloorNotFoundException("Parking floor not found for " + parkingFloorNumber);
        }

        return parkingFloor;
    }

    public void put(ParkingFloor parkingFloor) {
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
        System.out.println("Parking floor added successfully");
    }
}
