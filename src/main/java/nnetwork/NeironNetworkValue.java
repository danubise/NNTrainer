package nnetwork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkurilo on 7/27/17.
 */
public class NeironNetworkValue {
    public void setResultValue(Double resultValue) {
        this.resultValue = resultValue;
    }

    Double resultValue = 0.0;
    Map<String, Double> nnValues = new HashMap<String, Double>();


    public void  setValues(String neironName, double value){
        nnValues.put(neironName, value);
    }

    public Map<String, Double>  getInputValues(){
        return nnValues;
    }

    public double getResultValue(){
        return this.resultValue;
    }



    @Override
    public String toString() {
        return "NeironNetworkValue{" +
                "resultValue=" + resultValue +
                ", nnValues=" + nnValues +
                '}';
    }
}
