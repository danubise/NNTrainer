import nnetwork.Neiron;
import nnetwork.NeironError;
import nnetwork.NeironType;

import java.util.HashMap;

import static java.lang.Math.random;

/**
 * Created by vkurilo on 8/11/17.
 */
public class main {
    private static int epoch =600000;
    private static double learning_rate = 0.007;
    private static double resultTreshold = 0.90;
    private static double minResultTreshold = 0.20;
    private static double randomMiltiper = 1500;
    private static double errorStatus =0.0;

    public static void main(String[] args) {
        HashMap<String, Neiron> neironInputHashMap;
        HashMap<String, Neiron> neironHiddenHashMap;
        HashMap<String, Neiron> neironExitHashMap;
        neironInputHashMap = createNeironsMap(3, NeironType.INPUT);
        neironHiddenHashMap = createNeironsMap(30, NeironType.HIDDEN);
        neironExitHashMap = createNeironsMap(1, NeironType.EXIT);
        setLowLevelNeirons(neironHiddenHashMap, neironInputHashMap);
        setLowLevelNeirons(neironExitHashMap, neironHiddenHashMap);

        int c = 0;

        for (int i = 0; i < epoch; i++) {
            calculate("000","0",neironInputHashMap,neironExitHashMap);
            calculate("001","0",neironInputHashMap,neironExitHashMap);
            calculate("010","0",neironInputHashMap,neironExitHashMap);
            calculate("011","0",neironInputHashMap,neironExitHashMap);
            calculate("100","1",neironInputHashMap,neironExitHashMap);
            calculate("101","1",neironInputHashMap,neironExitHashMap);
            calculate("110","0",neironInputHashMap,neironExitHashMap);
            calculate("111","1",neironInputHashMap,neironExitHashMap);
            c++;
            if (c == 1000) {
                System.out.printf("\r " + i*100/epoch + " err=" + String.format("%.09f", errorStatus));
                c = 0;
            }
        }

        showResult("000","0",neironInputHashMap,neironExitHashMap);
        showResult("001","0",neironInputHashMap,neironExitHashMap);
        showResult("010","0",neironInputHashMap,neironExitHashMap);
        showResult("011","0",neironInputHashMap,neironExitHashMap);
        showResult("100","1",neironInputHashMap,neironExitHashMap);
        showResult("101","1",neironInputHashMap,neironExitHashMap);
        showResult("110","0",neironInputHashMap,neironExitHashMap);
        showResult("111","1",neironInputHashMap,neironExitHashMap);

        //showTree(neironExitHashMap);
        //showError(errorHashMap,neironExitHashMap);
    }
    private static void calculate(String inputValue,String rightResult,HashMap<String, Neiron> neironInputHashMap, HashMap<String, Neiron> neironExitHashMap){
        setInputValue(inputValue, neironInputHashMap);
        applyErrorValue( checkResult(rightResult, getResult(neironExitHashMap, rightResult ), neironExitHashMap), neironExitHashMap);
    }

    private static void showResult(String inputValue, String rightResult, HashMap<String, Neiron> neironInputHashMap, HashMap<String, Neiron> neironExitHashMap){
        String resultNN;

        setInputValue(inputValue , neironInputHashMap);
        resultNN = getResult(neironExitHashMap, rightResult);
        System.out.println("Input value ='" + inputValue + "' rightResult='"+ rightResult + "' nnResult='"+resultNN+"'");
        Neiron neiron;
        for (HashMap.Entry<String, Neiron> entry : neironExitHashMap.entrySet()) {
            neiron = entry.getValue();
            System.out.println(neiron.getName() + " -> " + String.format("%.06f", neiron.getSigmoidValue()) +"\n");

        }
    }

    private static void showError(HashMap<String, NeironError> errorHashMap,  HashMap<String, Neiron> neironExitHashMap){
        String neironName = null;
        NeironError neironError = null;
        Neiron neiron = null;
        for (HashMap.Entry<String, Neiron> entry : neironExitHashMap.entrySet()) {
            neironName = entry.getKey();
            neiron = entry.getValue();
            System.out.println("Neiron name='"+ neiron.getName() +"' error='"+ errorHashMap.get(neiron.getName())+"'" );
        }
    }

    private static void applyErrorValue(HashMap<String, NeironError> errorHashMap , HashMap<String, Neiron> neironExitHashMap){
        String neironName = null;
        NeironError neironError = null;
        Neiron neiron = null;
        for (HashMap.Entry<String, NeironError> entry : errorHashMap.entrySet()) {
            neironName =  entry.getKey();
            neironError = entry.getValue();
            neiron = neironExitHashMap.get(neironName);
            neiron.setErrorValue(neironError.getResultError(),neironError.getDeltaWeigth(),learning_rate);
        }
    }
    private static HashMap<String, NeironError> checkResult(String rightResult, String nnResult, HashMap<String, Neiron> neironExitHashMap){
        HashMap<String, NeironError> neironWithError = new HashMap<String, NeironError>();
        char[] rightValue = rightResult.toCharArray();
        char[] nnValue = nnResult.toCharArray();
        Double rightValueDouble, errorValue, deltaWeight;
        Neiron neiron = null;

        NeironError neironError = null;
        for (int i = 0; i < rightValue.length; i++) {
            if(rightValue[i] != nnValue[i]){
                //System.out.println("Error for N" + i);
                neiron = neironExitHashMap.get(NeironType.EXIT + String.valueOf(i));

                rightValueDouble = Double.valueOf(String.valueOf(rightValue[i]));
                errorValue = neiron.getSigmoidValue() - rightValueDouble;
                deltaWeight = errorValue * neiron.getSigmoidValue();
                neironError = new NeironError(errorValue , deltaWeight );
                //neironWithError.put(neiron.getName(), neironError );
                errorStatus = errorValue;
                neiron.setErrorValue(errorValue, deltaWeight, learning_rate);
            }
        }
        return  neironWithError;
    }

    private static void training( HashMap<String , Neiron> neironHashMap){
/*
0000
0001
0010
0011

         */
    }
    private static void setInputValue(String inputValue, HashMap<String , Neiron>  neironHashMap){
        int c = 0;
        Neiron neiron = null;
        for (char s : inputValue.toCharArray()) {
            neiron = neironHashMap.get(NeironType.INPUT.toString().concat(String.valueOf(c)));
            neiron.setValue(Double.valueOf(String.valueOf(s)));
            c++;
            //System.out.println(neiron);
        }
    }

    private static HashMap<String , Neiron> createNeironsMap(int count, NeironType neironType){
        HashMap<String , Neiron> neironHashMap = new HashMap<String, Neiron>();
        String neironName = null;
        for (int i = 0; i < count; i++) {
            neironName = neironType.toString().concat(String.valueOf(i));
            neironHashMap.put(neironName, new Neiron(neironName, neironType, resultTreshold));
        }
        return neironHashMap;
    }

    private static void setLowLevelNeirons(HashMap<String , Neiron> hightLevel , HashMap<String , Neiron> lowLevel){
        String hlName, llName ;
        Neiron hlNeiron, llNeiron;

        for (HashMap.Entry<String, Neiron> entry: hightLevel.entrySet()){
                 hlName = entry.getKey();
                 hlNeiron = entry.getValue();
            for (HashMap.Entry<String, Neiron> entryLowLevel :lowLevel.entrySet()) {
                llName = entryLowLevel.getKey();
                llNeiron = entryLowLevel.getValue();
                hlNeiron.addNeirons(llNeiron, random()* randomMiltiper);
            }
        }
    }
    private static void showTree (HashMap<String , Neiron> neironHashMap){
        String hlName, llName ;
        Neiron hlNeiron, llNeiron;

        for (HashMap.Entry<String, Neiron> entry: neironHashMap.entrySet()){
            hlName = entry.getKey();
            hlNeiron = entry.getValue();
            hlNeiron.showNeironTree();
        }
    }

    private static String getResult(HashMap<String , Neiron> neironHashMap, String rightResult){
        String hlName  ;
        Neiron hlNeiron ;
        NeironType neironType = null;
        String result = "";
        for (HashMap.Entry<String, Neiron> entry: neironHashMap.entrySet()){
            hlNeiron = entry.getValue();
            neironType = hlNeiron.getNeironType();
            break;
        }
        char[] rightResultChar = rightResult.toCharArray();

        for (int i = 0; i < neironHashMap.size(); i++) {
            hlName = neironType.toString().concat(String.valueOf(i));
            hlNeiron = neironHashMap.get(hlName);
            hlNeiron.reCalculateWeight();
            //System.out.printf(hlName + " -> " + hlNeiron.getSigmoidValue()+ "\t");
            if(rightResultChar[i]-48 == 1 ){
                result = result.concat(String.valueOf( hlNeiron.getSigmoidValue() > resultTreshold  ? 1:2));
            }else{
                result = result.concat(String.valueOf( hlNeiron.getSigmoidValue() < minResultTreshold ? 0:2));
            }
        }
        //System.out.println();
        return result;
    }
}
