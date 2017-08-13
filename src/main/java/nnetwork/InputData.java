package nnetwork;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class InputData {
    HashMap<Integer,Double> inputDataHashMap = new HashMap<Integer, Double>();

    public InputData add(int inputNeironNumber, double inputValue){
        inputDataHashMap.put(inputNeironNumber,inputValue);
        return this;
    }
    public Double getInputData(int neironNumber){
        return inputDataHashMap.get(neironNumber);
    }

    public InputData(String inputData){
        addBinary(inputData);
    }
    public InputData(){}
    public InputData addBinary(String inputData){
        int i = 0;
        for (char c : inputData.toCharArray()) {

            inputDataHashMap.put(i, (double) (c - 48));
            i++;
        }
        return this;
    }

    public int getSize(){
        return inputDataHashMap.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (HashMap.Entry<Integer, Double> entry : inputDataHashMap.entrySet()) {
            stringBuilder.append(entry.getValue())
                    .append(" ");
        }
        return "InputData{"+stringBuilder+ "}";
    }
}
