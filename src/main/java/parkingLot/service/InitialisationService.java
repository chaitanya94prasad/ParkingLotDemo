package parkingLot.service;

import parkingLot.enums.GateType;
import parkingLot.enums.Status;
import parkingLot.enums.VehicleType;
import parkingLot.models.*;
import parkingLot.repository.*;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitialisationService() {
        this.gateRepository = new GateRepository();
        this.operatorRepository = new OperatorRepository();
        this.parkingFloorRepository = new ParkingFloorRepository();
        this.parkingLotRepository = new ParkingLotRepository();
        this.parkingSpotRepository = new ParkingSpotRepository();
    }

    public ParkingLot initialise() {
        Operator entryOperator = new Operator();
        entryOperator.setEmailId("emailIDX");
        entryOperator.setName("Operator Name entry");
        entryOperator.setPhoneNumber("1234567890");

        Operator exitOperator = new Operator();
        exitOperator.setEmailId("emailIDX");
        exitOperator.setName("Operator Name exit");
        exitOperator.setPhoneNumber("1234567890");

        operatorRepository.put(entryOperator);
        operatorRepository.put(exitOperator);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setOperator(entryOperator);
        entryGate.setGateNumber(1);
        entryGate.setGateType((GateType.ENTRY));
        entryGate.setFloorNumber(0);
        entryGate.setStatus(Status.ACTIVE);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setOperator(exitOperator);
        exitGate.setGateNumber(2);
        exitGate.setGateType((GateType.EXIT));
        exitGate.setFloorNumber(0);
        exitGate.setStatus(Status.ACTIVE);

        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress("ADDR");
        parkingLot.setCapacity(100);

        parkingLot.setGates(List.of(exitGate,entryGate));

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100+i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            for(int j = 0; j < 10; j++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(1000 + j);
                parkingSpot.setNumber(i*10 + j);
                if(j%2 == 0) {
                    parkingSpot.setSupportedVehicleType(VehicleType.TWO_WHEELER);
                } else {
                    parkingSpot.setSupportedVehicleType(VehicleType.FOUR_WHEELER);
                }

                parkingSpot.setStatus(Status.ACTIVE);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpotList(parkingSpots);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }

        parkingLot.setParkingFloors(parkingFloors);

        return parkingLot;

    }
}
