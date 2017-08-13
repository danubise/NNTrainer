package trainer;

import nnetwork.InputData;
import nnetwork.OutputData;
import nnetwork.ioData;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class TrainingData2 {
    //HashMap<InputData, OutputData> trainigdata = new HashMap<InputData, OutputData>();
    private HashMap<Integer, ioData> trainigdata = new HashMap<Integer, ioData>();
    private int count = 0;
    private int currentID = 0 ;
    public void addData(InputData inputData, OutputData outputData){

        trainigdata.put(count,new ioData(inputData,outputData));
        count ++;
    }
    public InputData getInputData(int id){
        currentID = id;
        return getInputData();
    }

    public InputData getInputData(){
        if(currentID >= count ){
            currentID = 0;
        }
        return trainigdata.get(currentID).getInputData();
    }

    public InputData getInputData(int id, boolean random){
        if(random) {
            //currentID = (int) (Math.random() * id);
            return getInputData((int) (Math.random() * id));
        }else{
            currentID++;
            if(currentID > id){
                currentID = 0;
            }
            return getInputData();
        }
    }


    public OutputData getOutputData(){
        return trainigdata.get(currentID).getOutputData();
    }

    public int getCount(){
        return count;
    }

}
