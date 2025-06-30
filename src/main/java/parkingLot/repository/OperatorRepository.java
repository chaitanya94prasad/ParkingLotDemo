package parkingLot.repository;

import parkingLot.exception.OperatorNotFoundException;
import parkingLot.models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    private Map<Integer, Operator> operatorMap;

    public OperatorRepository() {
        this.operatorMap = new HashMap<>();
    }

    public Operator get(int operatorNumber) {
        Operator operator = operatorMap.get(operatorNumber);
        if(operator == null) {
            throw new OperatorNotFoundException("Operator not found for " + operatorNumber);
        }
        return operator;
    }

    public void put(Operator operator) {
        operatorMap.put(operator.getId(),operator);
        System.out.println("Operator added successfully");
    }
}
