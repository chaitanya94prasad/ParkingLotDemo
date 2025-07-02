package parkingLot.controller;

import parkingLot.dto.IssueTicketRequestDTO;
import parkingLot.dto.IssueTicketResponseDTO;
import parkingLot.enums.ResponseStatus;
import parkingLot.exception.InvalidRequestDataException;
import parkingLot.models.Ticket;
import parkingLot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO getTicket(IssueTicketRequestDTO issueTicketRequestDTO) {
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
        Ticket ticket;
        try{
            if(issueTicketRequestDTO.getGateID() == null ||
            issueTicketRequestDTO.getVehicleType() == null ||
            issueTicketRequestDTO.getVehicleNumber() == null) {
                throw new InvalidRequestDataException("Ticket generation request data is invalid");
            }

            ticket = ticketService.getTicket(issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getVehicleColour(),
                    issueTicketRequestDTO.getVehicleMake(),
                    issueTicketRequestDTO.getGateID());
        }catch (Exception e) {
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDTO.setFailureReason(e.getMessage());
        }

        return issueTicketResponseDTO;
    }
}
