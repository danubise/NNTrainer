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
public class main7 {
    public static void main(String[] args) {
        Trainer2 trainer2 = new Trainer2();
        Trainer2.setEpoch(1000000);
        Trainer2.setLearning_rate(0.07);
        Trainer2.setRandomMiltiper(1500);
        Trainer2.setResultTreshold(0.01);
        HashMap<String , Neiron> inputNeiron, hiddenNeiron, exitNeiron;

        inputNeiron = Trainer2.createNeironsMap(4, NeironType.INPUT);
        hiddenNeiron = Trainer2.createNeironsMap(18, NeironType.HIDDEN);
        exitNeiron = Trainer2.createNeironsMap(3, NeironType.EXIT);

        Trainer2.setLowLevelNeirons(hiddenNeiron, inputNeiron);
        Trainer2.setLowLevelNeirons(exitNeiron, hiddenNeiron);

        trainer2.setNeironInputHashMap(inputNeiron);
        trainer2.setNeironHiddenHashMap(hiddenNeiron);
        trainer2.setNeironExitHashMap(exitNeiron);

        TrainingData trainingData = new TrainingData();

        //trainingData.addData(new InputData().add(0,0).add(1,0).add(2,0).add(3,1),new OutputData().add(0,0).add(1,1));
        //
        //trainingData.addData(new InputData("000000000000000"),new OutputData("1010"));
        trainingData.addData(new InputData("1000"),new OutputData("001"));
       trainingData.addData(new InputData("0100"),new OutputData("010"));
        trainingData.addData(new InputData("0010"),new OutputData("011"));
        trainingData.addData(new InputData("0001"),new OutputData("100"));

//111000111001111
        //trainer2.save();

        trainer2.setTrainingData(trainingData);

        trainer2.training();
        //trainer2.showWeight();
        trainer2.showCheck();
        trainer2.manualCheckResult();
    }
}
