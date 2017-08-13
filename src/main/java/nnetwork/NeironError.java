package nnetwork;

/**
 * Created by vkurilo on 8/12/17.
 */
public class NeironError {
    Double resultError =0.0;
    Double deltaWeigth =0.0;

    public NeironError(Double resultError, Double deltaWeigth) {
        this.resultError = resultError;
        this.deltaWeigth = deltaWeigth;
    }

    public Double getResultError() {
        return resultError;
    }

    public void setResultError(Double resultError) {
        this.resultError = resultError;
    }

    public Double getDeltaWeigth() {
        return deltaWeigth;
    }

    public void setDeltaWeigth(Double deltaWeigth) {
        this.deltaWeigth = deltaWeigth;
    }

    @Override
    public String toString() {
        return "NeironError{" +
                "resultError=" + resultError +
                ", deltaWeigth=" + deltaWeigth +
                '}';
    }
}
