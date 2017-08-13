package trainer;

import nnetwork.InputData;
import nnetwork.OutputData;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class TrainingData {
    HashMap<InputData, OutputData> trainigdata = new HashMap<InputData, OutputData>();

    public void addData(InputData inputData, OutputData outputData){
        trainigdata.put(inputData,outputData);
    }
    public  HashMap<InputData, OutputData>  getTrainigdata(){
        return trainigdata;
    }

}
