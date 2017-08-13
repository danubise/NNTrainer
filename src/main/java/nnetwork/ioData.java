package nnetwork;

/**
 * Created by vkurilo on 8/13/17.
 */
public class ioData {
    private InputData inputData ;

    public InputData getInputData() {
        return inputData;
    }

    public OutputData getOutputData() {
        return outputData;
    }

    private OutputData outputData;

    public ioData(InputData inputData, OutputData outputData) {
        this.inputData = inputData;
        this.outputData = outputData;
    }
}
