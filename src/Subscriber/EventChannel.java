package Subscriber;

import Subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class EventChannel {

    private static EventChannel instance;
    private List<Subscriber> subscribers = new ArrayList<>();

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

    public void publishUpdate(int gameTick) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(gameTick);
        }
    }
}
