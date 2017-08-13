import nnetwork.InputData;
import nnetwork.Neiron;
import nnetwork.NeironType;
import nnetwork.OutputData;
import trainer.Trainer2;
import trainer.TrainingData;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class main4 {
    public static void main(String[] args) {
        Trainer2 trainer2 = new Trainer2();
        Trainer2.setEpoch(100000);
        Trainer2.setLearning_rate(0.07);

        HashMap<String , Neiron> inputNeiron, hiddenNeiron, exitNeiron;

        inputNeiron = Trainer2.createNeironsMap(4, NeironType.INPUT);
        hiddenNeiron = Trainer2.createNeironsMap(16, NeironType.HIDDEN);
        exitNeiron = Trainer2.createNeironsMap(2, NeironType.EXIT);

        Trainer2.setLowLevelNeirons(hiddenNeiron, inputNeiron);
        Trainer2.setLowLevelNeirons(exitNeiron, hiddenNeiron);

        trainer2.setNeironInputHashMap(inputNeiron);
        trainer2.setNeironExitHashMap(exitNeiron);

        TrainingData trainingData = new TrainingData();

        //trainingData.addData(new InputData().add(0,0).add(1,0).add(2,0).add(3,1),new OutputData().add(0,0).add(1,1));
        trainingData.addData(new InputData("0001"),new OutputData("01"));

        trainingData.addData(new InputData().add(0,0).add(1,0).add(2,1).add(3,0),new OutputData().add(0,1).add(1,1));
        trainingData.addData(new InputData().add(0,0).add(1,1).add(2,0).add(3,1),new OutputData().add(0,0).add(1,1));
        trainingData.addData(new InputData().add(0,0).add(1,1).add(2,1).add(3,0),new OutputData().add(0,0).add(1,1));
        trainingData.addData(new InputData().add(0,1).add(1,0).add(2,0).add(3,0),new OutputData().add(0,1).add(1,0));
        trainingData.addData(new InputData().add(0,1).add(1,0).add(2,1).add(3,1),new OutputData().add(0,1).add(1,0));
        trainingData.addData(new InputData().add(0,1).add(1,1).add(2,0).add(3,0),new OutputData().add(0,0).add(1,1));
        trainingData.addData(new InputData().add(0,1).add(1,1).add(2,1).add(3,0),new OutputData().add(0,1).add(1,0));

        trainer2.setTrainingData(trainingData);

        trainer2.training();
        trainer2.showWeight();
        trainer2.showCheck();
        trainer2.manualCheckResult();
    }
}
