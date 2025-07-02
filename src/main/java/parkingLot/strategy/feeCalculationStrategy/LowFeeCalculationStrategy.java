package parkingLot.strategy.feeCalculationStrategy;

import parkingLot.enums.VehicleType;
import parkingLot.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowFeeCalculationStrategy implements FeeCalculationStrategy {
    private static final int PER_MIN_RATE_2_WHEELER = 2;
    private static final int PER_MIN_RATE_4_WHEELER = 5;

    @Override
    public long getFeeAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime currentTime = LocalDateTime.now();
        long numberOfMinutes = ChronoUnit.MINUTES.between(currentTime,entryTime);

        if(ticket.getVehicle().getVehicleType().equals(VehicleType.TWO_WHEELER)) {
            return numberOfMinutes * PER_MIN_RATE_2_WHEELER;
        } else {
            return numberOfMinutes * PER_MIN_RATE_4_WHEELER;
        }
    }
}
