package parkingLot.service;

import parkingLot.enums.Status;
import parkingLot.enums.VehicleType;
import parkingLot.models.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;
import parkingLot.strategy.spotAllocationStrategy.RandomSpotAllocationStrategy;
import parkingLot.strategy.spotAllocationStrategy.SpotAllocationFactory;

import java.time.LocalDateTime;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }

    public Ticket getTicket(VehicleType vehicleType, String vehicleNumber, String vehicleColour, String vehicleMake, int gateID) {
        Gate gate = gateRepository.get(gateID);

        RandomSpotAllocationStrategy randomSpotAllocationStrategy = SpotAllocationFactory.getSpotAllocationStrategy(parkingLotRepository);
        ParkingSpot parkingSpot = randomSpotAllocationStrategy.getSpot(vehicleType,gate);
        parkingSpot.setStatus(Status.NOT_AVAILBALE);

        Ticket ticket = new Ticket();
        ticket.setVehicle(new Vehicle(vehicleNumber,vehicleColour,vehicleMake,vehicleType));
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
}
