package nnetwork;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class OutputData {
    HashMap<Integer,Double> outputDataHashMap = new HashMap<Integer, Double>();
    private  int coutData = 0;
    public OutputData add(int inputNeironNumber, double inputValue){
        outputDataHashMap.put(inputNeironNumber,inputValue);
        return this;
    }
    public Double getOutputData(int neironNumber){
        return outputDataHashMap.get(neironNumber);
    }
    public int getSize(){
        return outputDataHashMap.size();
    }

    public OutputData(String outputData){
        addBinary(outputData);
    }
    public OutputData(){}
    public OutputData(double value){
        outputDataHashMap.put(coutData, value);
        coutData ++;
    }
    public OutputData addBinary(String outoutData){
        int i = 0;
        for (char c : outoutData.toCharArray()) {

            outputDataHashMap.put(i, (double) (c - 48));
            i++;
        }
        return this;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (HashMap.Entry<Integer, Double> entry : outputDataHashMap.entrySet()) {
            stringBuilder.append(entry.getValue())
                    .append(" ");
        }
        return "OutputData{" +stringBuilder+"}";
    }
}
