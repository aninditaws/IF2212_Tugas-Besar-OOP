package Subscriber;

import Subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class EventChannel {

    public static EventChannel instance = new EventChannel();
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishUpdate() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
