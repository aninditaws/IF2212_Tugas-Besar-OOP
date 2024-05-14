package Subscriber;

import java.util.ArrayList;
import java.util.List;

public class EventChannel {

    private static EventChannel instance = null;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public static EventChannel getInstance() {
        if (instance == null) {
            instance = new EventChannel();
        }
        return instance;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public synchronized void publishUpdate(int gameTick) {
        subscribers.forEach(subscriber -> {
            subscriber.update(gameTick);
        });
    }
}
