package parkingLot;

import parkingLot.models.ParkingLot;
import parkingLot.service.InitialisationService;

public class ParkingLotMain {

    private InitialisationService initialisationService;

    public ParkingLotMain() {
        this.initialisationService = new InitialisationService();
    }

    public static void main(String[] args) {
        ParkingLotMain parkingLotMain = new ParkingLotMain();
        ParkingLot parkingLot = parkingLotMain.initialisationService.initialise();
    }
}
