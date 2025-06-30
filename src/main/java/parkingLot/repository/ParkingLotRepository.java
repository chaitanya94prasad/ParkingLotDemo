package parkingLot.repository;

import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int ParkingLotNumber) {
        ParkingLot parkingLot = parkingLotMap.get(ParkingLotNumber);
        if(parkingLot == null) {
            throw new ParkingLotNotFoundException("Parking lot not found for " + ParkingLotNumber);
        }

        return parkingLot;
    }

    public void put(ParkingLot parkingLot) {
        parkingLotMap.put(parkingLot.getId(),parkingLot);
        System.out.println("Parking lot has been added successfully");
    }
}
