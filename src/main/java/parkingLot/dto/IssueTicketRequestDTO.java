package parkingLot.dto;

import parkingLot.enums.VehicleType;

public class IssueTicketRequestDTO {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleColour;
    private String vehicleMake;
    private Integer gateID;

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public Integer getGateID() {
        return gateID;
    }

    public void setGateID(Integer gateID) {
        this.gateID = gateID;
    }
}
