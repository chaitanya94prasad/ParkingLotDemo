package parkingLot.repository;

import parkingLot.exception.ParkingSpotNotFoundException;
import parkingLot.models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot get(int parkingSpotNumber) {
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotNumber);
        if(parkingSpot == null) {
            throw new ParkingSpotNotFoundException("Parking spot not found for " + parkingSpotNumber);
        }

        return parkingSpot;
    }

    public void put(ParkingSpot parkingSpot) {
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
        System.out.println("Parking Spot Added successfully");
    }
}
