package io.tomoto;

import io.tomoto.event.EventCenter;
import io.tomoto.event.IEventListener;
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
        EventCenter.register(SomeSpecificEvent.class, new SomeSpecificEventListener());

        // 默认处理
        EventCenter.handleEvent(new SomeSpecificEvent());

        System.out.println("===");

        // 移除
        EventCenter.getListener(SomeSpecificEvent.class).removeHandler(SomeSpecificEventListener.DEFAULT_HANDLER);
        EventCenter.handleEvent(new SomeSpecificEvent());

        System.out.println("===");

        IEventListener.IEventHandler<SomeSpecificEvent> handler = event -> System.out.println(event.getMessage() + " 2");
        EventCenter.getListener(SomeSpecificEvent.class).addHandler(handler);
        EventCenter.handleEvent(new SomeSpecificEvent());

        System.out.println("===");

        // 清空
        EventCenter.getListener(SomeSpecificEvent.class).clearHandler();
        EventCenter.handleEvent(new SomeSpecificEvent());

        System.out.println("===");
    }
}
