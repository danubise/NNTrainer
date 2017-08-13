package trainer;

import nnetwork.Neiron;
import nnetwork.NeironType;
import nnetwork.Network;

import static java.lang.Math.random;

/**
 * Created by vkurilo on 7/27/17.
 */
public class testTrainer {
    public static void main(String[] args) {
        Training training = new Training();
        Network network = new Network();
        network.addNeiron(new Neiron("Vodka", NeironType.INPUT));
        network.addNeiron(new Neiron("Rain", NeironType.INPUT));
        network.addNeiron(new Neiron("Friend", NeironType.INPUT));
        double multi = 500;

        network.addNeiron(new Neiron("Hidden1", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden2", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi)).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden3", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden4", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden5", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden6", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), 4);

        network.addNeiron(new Neiron("Hidden7", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden8", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden9", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden10", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden11", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden12", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden13", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden14", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);


        network.addNeiron(new Neiron("Hidden15", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden16", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden17", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);
        network.addNeiron(new Neiron("Hidden18", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden19", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden20", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden21", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden22", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden23", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden24", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addNeiron(new Neiron("Hidden25", NeironType.HIDDEN , network.getNeironByName("Vodka"), random() * multi )).
                addNeirons(network.getNeironByName("Rain"),  random() * multi).
                addNeirons(network.getNeironByName("Friend"), random() * multi);

        network.addExitNeiron(new Neiron("Exit", NeironType.EXIT, network.getNeironByName("Hidden1"),random() * multi))
                .
                addNeirons(network.getNeironByName("Hidden2"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden3"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden4"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden6"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden8"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden9"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden10"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden11"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden12"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden13"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden14"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden15"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden16"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden17"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden18"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden19"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden20"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden21"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden22"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden23"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden24"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden25"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden7"), random() * multi)
                .addNeirons(network.getNeironByName("Hidden5"), random() * multi);
        training.setNetwork(network);
        training.test();
    }
}
