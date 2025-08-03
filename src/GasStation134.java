public class GasStation134 {
    public static void main(String[] args) {
      int[]  gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
      System.out.println(canCompleteCircuit(gas, cost));
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas =0, totalCost =0;

        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int currentGas =0, stateIndex =0;
        for(int i=0; i<gas.length; i++){
            currentGas += gas[i] - cost[i];

            if(currentGas < 0){
                stateIndex = i+1;
                currentGas =0;
            }
        }
        return stateIndex;
    }
}
