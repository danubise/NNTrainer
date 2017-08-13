package trainer;

import nnetwork.InputData;
import nnetwork.Neiron;
import nnetwork.NeironType;
import nnetwork.OutputData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static java.lang.Math.abs;
import static java.lang.Math.random;

/**
 * Created by vkurilo on 8/12/17.
 */
public class Trainer2 {
    HashMap<String, Neiron> neironInputHashMap = new HashMap<String, Neiron>();
    HashMap<String, Neiron> neironHiddenHashMap = new HashMap<String, Neiron>();
    HashMap<String, Neiron> neironExitHashMap = new HashMap<String, Neiron>();
    HashMap<String, Neiron> neironAllHashMap = new HashMap<String, Neiron>();
    TrainingData2 trainingData ;

    private static int epoch = 60000;
    private static double learning_rate = 0.07;

    private static double resultTreshold = 0.75;
    private static double randomMiltiper = 200;
    private int errorCount = 0;
    private int totalCout  =0 ;
    private double errorV =0;


    public static void setEpoch(int epoch) {
        Trainer2.epoch = epoch;
    }

    public static void setLearning_rate(double learning_rate) {
        Trainer2.learning_rate = learning_rate;
    }

    public static void setResultTreshold(double resultTreshold) {
        Trainer2.resultTreshold = resultTreshold;
    }

    public static void setRandomMiltiper(double randomMiltiper) {
        Trainer2.randomMiltiper = randomMiltiper;
    }


    public static HashMap<String , Neiron> createNeironsMap(int count, NeironType neironType){
        HashMap<String , Neiron> neironHashMap = new HashMap<String, Neiron>();
        String neironName = null;
        for (int i = 0; i < count; i++) {
            neironName = neironType.toString().concat(String.valueOf(i));
            neironHashMap.put(neironName, new Neiron(neironName, neironType, resultTreshold));
        }
        return neironHashMap;
    }

    public void setNeironInputHashMap(HashMap<String, Neiron> inputNeiron){
        this.neironInputHashMap.putAll(inputNeiron);
        this.neironAllHashMap.putAll(inputNeiron);
    }
    public void setNeironHiddenHashMap(HashMap<String, Neiron> hiddenNeiron){
        this.neironHiddenHashMap.putAll(hiddenNeiron);
        this.neironAllHashMap.putAll(hiddenNeiron);
    }

    public void setNeironExitHashMap(HashMap<String, Neiron> exitNeiron){
        this.neironExitHashMap.putAll(exitNeiron);
        this.neironAllHashMap.putAll(exitNeiron);
    }

    public static void setLowLevelNeirons(HashMap<String , Neiron> hightLevel , HashMap<String , Neiron> lowLevel){
        //привязывает lowLevel нейроны ко всем hightLevel

        Neiron hlNeiron, llNeiron;

        for (HashMap.Entry<String, Neiron> entry: hightLevel.entrySet()){

            hlNeiron = entry.getValue();
            for (HashMap.Entry<String, Neiron> entryLowLevel :lowLevel.entrySet()) {
                llNeiron = entryLowLevel.getValue();
                hlNeiron.addNeirons(llNeiron, random() * randomMiltiper);
            }
        }
    }

    public void setTrainingData(TrainingData2 trainingData){
        this.trainingData = trainingData;
    }
    public void setTrainingData(TrainingData trainingData){
        //this.trainingData = trainingData;
    }

    public void training(){
        int c = 0, stopByError =0;
        for (int i = 0; i < epoch; i++) {
            for (int h = 0; h < trainingData.getCount(); h++){
                setInputData(trainingData.getInputData(h));
                recalculateNNetwork();
                checkNNetworkResult(trainingData.getOutputData());
            }
            c++;
            if(c==1000) {
                System.out.printf("\r " + i + " error: " + String.format("%.09f", errorV) + " errorCount :" + errorCount + " total: "+ totalCout);
                c=0;
                if(errorCount ==0 ){
                    stopByError ++;
                    if(stopByError == 50) {
                        i=epoch;
                    }
                }
                errorCount = 0;
                totalCout = 0;
            }
        }
    }

    public void training2(boolean useRandom){
        int c = 0, stopByError =0, coutOfTrainingData = 0;
        for (int i = 0; i < epoch; i++) {

            setInputData(trainingData.getInputData(coutOfTrainingData, useRandom));
            recalculateNNetwork();
            checkNNetworkResult(trainingData.getOutputData());

            c++;
            if(c==5000) {
                System.out.printf("\r " + i + " error: " + String.format("%.09f", errorV) + " errorCount :" + errorCount + " total: "+ totalCout + " treningData: " + (coutOfTrainingData+1));
                c=0;
                if(errorCount == 0 ){
                    coutOfTrainingData++;
                    if(coutOfTrainingData > trainingData.getCount()) {
                        i = epoch;
                    }
                    stopByError ++;
                    if(stopByError == 100) {
                            i = epoch;
                    }
                }
                errorCount = 0;
                totalCout = 0;
            }
        }
    }

    private void recalculateNNetwork(){
        for (HashMap.Entry<String, Neiron> entry : this.neironExitHashMap.entrySet()) {
            Neiron exitNeiron = entry.getValue();
            exitNeiron.reCalculateWeight();
        }
    }
    private void checkNNetworkResult(OutputData outputData){
        for (int i = 0; i < outputData.getSize(); i++) {
            String neironName = NeironType.EXIT.toString().concat(String.valueOf(i));
            Neiron exitNeiron = this.neironExitHashMap.get(neironName);

            double exitNeironValue = exitNeiron.getSigmoidValue();
            double rightResult = outputData.getOutputData(i);

            double error = exitNeironValue - rightResult;
            double weigthDelta = error * exitNeironValue;

            errorV = error;
            if(abs(rightResult - exitNeironValue) > resultTreshold) {
                errorCount++;
                //exitNeiron.setErrorValue(error, weigthDelta, learning_rate);
            }
            totalCout ++;
                // else {
                exitNeiron.setErrorValue(error, weigthDelta, learning_rate);
//            }

        }
    }
    private void setInputData(InputData inputData){
        for (int i = 0; i < neironInputHashMap.size(); i++) {
            //System.out.println(inputData.getOutputData(i));
            String inputNeironName = NeironType.INPUT.toString().concat(String.valueOf(i));
            Neiron neiron = neironInputHashMap.get(inputNeironName);

            neiron.setValue(inputData.getInputData(i));
            //System.out.println(neiron.toString());
        }
    }

    public void showWeight(){
        for (int i = 0; i < neironExitHashMap.size(); i++) {
            String neironName = NeironType.EXIT.toString().concat(String.valueOf(i));
            Neiron neiron = neironExitHashMap.get(neironName);
            neiron.showWeight();
        }
    }

    public void showTree(){
        for (int i = 0; i < neironExitHashMap.size(); i++) {
            String neironName = NeironType.EXIT.toString().concat(String.valueOf(i));
            Neiron neiron = neironExitHashMap.get(neironName);
            neiron.showNeironTree();
        }
    }

    public void showCheck(){
        for (int h = 0; h < trainingData.getCount(); h++){
            setInputData(trainingData.getInputData(h));
            recalculateNNetwork();
            showResult(trainingData.getOutputData());
            System.out.println(trainingData.getInputData() + " ==> " + trainingData.getOutputData());
        }
    }
    private void showResult(OutputData outputData){
        for (int i = 0; i < outputData.getSize(); i++) {
            String neironName = NeironType.EXIT.toString().concat(String.valueOf(i));
            Neiron exitNeiron = this.neironExitHashMap.get(neironName);

            double exitNeironValue = exitNeiron.getSigmoidValue();
            double rightResult = outputData.getOutputData(i);

            double error = exitNeironValue - rightResult;
            double weigthDelta = error * exitNeironValue;

            errorV = error;

            System.out.println(exitNeiron.getName() + " -> " + String.format("%.09f", exitNeironValue)  + " == " + rightResult);

        }

    }
    private void showResult(){
        for (int i = 0; i < neironExitHashMap.size(); i++) {
            String neironName = NeironType.EXIT.toString().concat(String.valueOf(i));
            Neiron exitNeiron = this.neironExitHashMap.get(neironName);
            double exitNeironValue = exitNeiron.getSigmoidValue();
            System.out.println(exitNeiron.getName() + " -> " + String.format("%.09f", exitNeironValue));
        }

    }

    public void manualCheckResult(){
        try{
            boolean repeat = false;
            BufferedReader bufferRead = null;
            String inputString = null;
            do {
                StringBuilder inputDataSB = new StringBuilder();
                for (int i = 0; i < neironInputHashMap.size(); i++) {
                    String neironName = NeironType.INPUT.toString().concat(String.valueOf(i));
                    Neiron neiron = neironInputHashMap.get(neironName);
                    System.out.printf("Set value for " + neiron.getName() + " : ");
                    bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    inputString = bufferRead.readLine();
                    if(inputString.length() == neironInputHashMap.size()){
                        i = neironInputHashMap.size();
                    }
                    inputDataSB.append(inputString);
                }
                setInputData(new InputData(inputDataSB.toString()));
                recalculateNNetwork();
                showResult();
                do{
                System.out.println("One more?: Y/n");
                bufferRead = new BufferedReader(new InputStreamReader(System.in));
                inputString = bufferRead.readLine();
                repeat = false;
                if(inputString.equals("save")){
                    save();
                    repeat = true;
                }}while (repeat);
            }while (!inputString.equals("n"));
            bufferRead.close();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean save(){
        System.out.println("Saving");
        for (HashMap.Entry<String ,Neiron> entry: neironInputHashMap.entrySet()) {
            Neiron neiron = entry.getValue();
            System.out.println(neiron.getName() + "," + neiron.getValue());
        }

        for (HashMap.Entry<String , Neiron> entry: neironHiddenHashMap.entrySet()) {
            Neiron neiron = entry.getValue();
            for (HashMap.Entry<Neiron, Double> lowLevel : neiron.getLowLevelNeironsList().entrySet()) {
                Neiron lowLevelNeiron = lowLevel.getKey();
                Double weight = lowLevel.getValue();
                System.out.println(neiron.getName() + "," + lowLevelNeiron.getName()+ "," + weight);
            }

        }

        for (HashMap.Entry<String , Neiron> entry: neironExitHashMap.entrySet()) {
            Neiron neiron = entry.getValue();
            for (HashMap.Entry<Neiron, Double> lowLevel : neiron.getLowLevelNeironsList().entrySet()) {
                Neiron lowLevelNeiron = lowLevel.getKey();
                Double weight = lowLevel.getValue();
                System.out.println(neiron.getName() + "," + lowLevelNeiron.getName()+ "," + weight);
            }

        }
        System.out.println("Done...");
        return true;
    }

}
