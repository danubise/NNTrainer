package nnetwork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkurilo on 7/27/17.
 */
public class Network {
    private Neiron exitNeiron = null;
    private Map<String , Neiron> neirons = new HashMap<String, Neiron>();
    private Map<String , Neiron> inputNeirons = new HashMap<String, Neiron>();
    private Map<String , Neiron> hiddenNeirons = new HashMap<String, Neiron>();
    private Map<String , Neiron> exitNeirons = new HashMap<String, Neiron>();
    private int countIntNeirons = 0;
    private int countHiddenNeirons =0;
    private int countExitNeirons = 0;
    private double expectValue = 0.0;

    public Neiron addNeiron(Neiron inputNeiron){
        this.neirons.put(inputNeiron.getName(), inputNeiron);
        switch (inputNeiron.getNeironType()){
            case INPUT:
                inputNeirons.put(inputNeiron.getName(), inputNeiron);
                countIntNeirons ++;
            case HIDDEN:
                hiddenNeirons.put(inputNeiron.getName(), inputNeiron);
                countHiddenNeirons ++;
            case EXIT:
                exitNeirons.put(inputNeiron.getName(), inputNeiron);
                countExitNeirons ++;
        }
        return inputNeiron;
    }

    public Neiron addExitNeiron(Neiron exitNeiron){
        this.exitNeiron = exitNeiron;
        this.addNeiron(exitNeiron);
        return this.exitNeiron;
    }

    public Neiron getNeironByName(String name ){
        System.out.println("Getting neirong by name -'" + name+"'");
        System.out.println(neirons.get(name));
        return neirons.get(name);
    }

    public void setInputNeironsValue(NeironNetworkValue inputNeironsValue){
        //System.out.println("Set input neirons value");
        for (Map.Entry<String, Double> entry: inputNeironsValue.getInputValues().entrySet()){
            this.neirons.get(entry.getKey()).setValue(entry.getValue());
         //   System.out.println(this.neirons.get(entry.getKey()));
        }
        this.expectValue = inputNeironsValue.getResultValue();
        //System.out.println("Set input neirons value done ....");
    }

    public Double getExitValue(){

        return this.exitNeiron.getSigmoidValue();
    }
    public void calculate(){
        this.exitNeiron.reCalculateWeight();
    }

    public void setErrorValue(double errorValue, double weight_delta, double learningRate){
        this.exitNeiron.setErrorValue(errorValue, weight_delta, learningRate);
    }
    public void showWeight(){
        this.exitNeiron.showWeight();
    }

    public void showInputValues(){

    }

}
