import nnetwork.InputData;
import nnetwork.Neiron;
import nnetwork.NeironType;
import nnetwork.OutputData;
import trainer.Trainer2;
import trainer.TrainingData2;

import java.util.HashMap;

/**
 * Created by vkurilo on 8/12/17.
 */
public class main2 {
    public static void main(String[] args) {
        Trainer2 trainer2 = new Trainer2();
        Trainer2.setEpoch(20000);

        HashMap<String , Neiron> inputNeiron, hiddenNeiron, exitNeiron;

        inputNeiron = Trainer2.createNeironsMap(3, NeironType.INPUT);
        hiddenNeiron = Trainer2.createNeironsMap(3, NeironType.HIDDEN);
        exitNeiron = Trainer2.createNeironsMap(1, NeironType.EXIT);

        Trainer2.setLowLevelNeirons(hiddenNeiron, inputNeiron);
        Trainer2.setLowLevelNeirons(exitNeiron, hiddenNeiron);

        trainer2.setNeironInputHashMap(inputNeiron);
        trainer2.setNeironExitHashMap(exitNeiron);

        TrainingData2 trainingData = new TrainingData2();

        trainingData.addData(new InputData().add(0,0).add(1,0).add(2,0),new OutputData().add(0,0));
        trainingData.addData(new InputData().add(0,0).add(1,0).add(2,1),new OutputData().add(0,0));
        trainingData.addData(new InputData().add(0,0).add(1,1).add(2,0),new OutputData().add(0,0));
        trainingData.addData(new InputData().add(0,0).add(1,1).add(2,1),new OutputData().add(0,0));
        trainingData.addData(new InputData().add(0,1).add(1,0).add(2,0),new OutputData().add(0,1));
        trainingData.addData(new InputData().add(0,1).add(1,0).add(2,1),new OutputData().add(0,1));
        trainingData.addData(new InputData().add(0,1).add(1,1).add(2,0),new OutputData().add(0,0));
        trainingData.addData(new InputData().add(0,1).add(1,1).add(2,1),new OutputData().add(0,0));

        trainer2.setTrainingData(trainingData);

        trainer2.training();
        trainer2.showWeight();
        trainer2.showCheck();
    }
}
