package io.tomoto.event.some.specific.event;

import io.tomoto.event.IEventListener;

/**
 * 某具体事件监听器
 *
 * @author Tomoto
 * @version 1.0 2022/8/17 11:13
 * @since 1.0
 */
public class SomeSpecificEventListener extends IEventListener<SomeSpecificEvent> {

    public SomeSpecificEventListener() {
        getHandlerList().add(event -> System.out.println("handler1"));
    }

}
