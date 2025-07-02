package parkingLot.repository;

import parkingLot.exception.TicketNotFoundException;
import parkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketNumber) {
        Ticket ticket = ticketMap.get(ticketNumber);
        if(ticket == null) {
            throw new TicketNotFoundException("Ticket not found for " + ticketNumber);
        }

        return ticket;
    }

    public void put(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("ticket added successfully");
    }
}
