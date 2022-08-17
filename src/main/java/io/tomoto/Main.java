package io.tomoto;

import io.tomoto.event.EventCenter;
import io.tomoto.event.some.specific.event.SomeSpecificEvent;
import io.tomoto.event.some.specific.event.SomeSpecificEventListener;

/**
 * main
 *
 * @author Tomoto
 * @version 1.0 2022/8/17 11:18
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        SomeSpecificEventListener listener = new SomeSpecificEventListener();
        EventCenter.register(SomeSpecificEvent.class, listener);

        EventCenter.handleEvent(new SomeSpecificEvent());

        System.out.println();

        listener.getHandlerList().add(event -> System.out.println("handler2"));
        EventCenter.handleEvent(new SomeSpecificEvent());
    }
}
