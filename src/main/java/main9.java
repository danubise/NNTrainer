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
public class main9 {
    public static void main(String[] args) {
        Trainer2 trainer2 = new Trainer2();
        Trainer2.setEpoch(100000000);
        Trainer2.setLearning_rate(0.007);
        Trainer2.setRandomMiltiper(500);
        Trainer2.setResultTreshold(0.09);
        HashMap<String , Neiron> inputNeiron, hiddenNeiron, exitNeiron;

        inputNeiron = Trainer2.createNeironsMap(15, NeironType.INPUT);
        hiddenNeiron = Trainer2.createNeironsMap(266, NeironType.HIDDEN);
        exitNeiron = Trainer2.createNeironsMap(4, NeironType.EXIT);

        Trainer2.setLowLevelNeirons(hiddenNeiron, inputNeiron);
        Trainer2.setLowLevelNeirons(exitNeiron, hiddenNeiron);

        trainer2.setNeironInputHashMap(inputNeiron);
        trainer2.setNeironHiddenHashMap(hiddenNeiron);
        trainer2.setNeironExitHashMap(exitNeiron);

        TrainingData2 trainingData = new TrainingData2();

        //trainingData.addData(new InputData().add(0,0).add(1,0).add(2,0).add(3,1),new OutputData().add(0,0).add(1,1));
        //
        //trainingData.addData(new InputData("000000000000000"),new OutputData("1010"));
        trainingData.addData(new InputData("001001001001001"),new OutputData("1000")); //1
//        trainingData.addData(new InputData("110110110110110"),new OutputData("0"));
//
//
        trainingData.addData(new InputData("111001111100111"),new OutputData("0100")); //2
//        trainingData.addData(new InputData("000000000000000"),new OutputData("0"));
//        trainingData.addData(new InputData("000110000011000"),new OutputData("0"));
        trainingData.addData(new InputData("111001111001111"),new OutputData("0010"));//3
        trainingData.addData(new InputData("101101111001001"),new OutputData("0001")); // 4
        //trainingData.addData(new InputData("111100111001111"),new OutputData(1)); //5
       //trainingData.addData(new InputData("111100111101111"),new OutputData(1)); //6
//        trainingData.addData(new InputData("111001001001001"),new OutputData(0.7)); //7
//        trainingData.addData(new InputData("111101111101111"),new OutputData(0.8)); //8
//        trainingData.addData(new InputData("111101111001111"),new OutputData(0.9)); // 9
//        trainingData.addData(new InputData("111101101101111"),new OutputData(0.01)); // 0
//111000111001111
        //trainer2.save();
//        System.out.println(trainingData.getCount());
//        System.out.println(trainingData.getInputData(10).toString());

        trainer2.setTrainingData(trainingData);

        trainer2.training2(false);
        //trainer2.showWeight();
        trainer2.showCheck();
        trainer2.manualCheckResult();
    }
}
