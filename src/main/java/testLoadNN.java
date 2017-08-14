import trainer.Trainer2;

/**
 * Created by vkurilo on 8/13/17.
 */
public class testLoadNN {
    public static void main(String[] args) {
        Trainer2 trainer2 = new Trainer2();
        trainer2.load("/home/vkurilo/Desktop/git/NNetworkMultyResponse/src/main/java/saved/main8work_from0-9");
        trainer2.manualCheckResult();
    }
}
