package io.tomoto.event;

import java.util.LinkedList;
import java.util.List;

/**
 * 事件监听器
 *
 * @author Tomoto
 * @version 1.0 2022/8/17 10:34
 * @since 1.0
 */
public abstract class IEventListener<E extends IEvent> {

    /**
     * 处理器表
     */
    private final List<IEventHandler<E>> handlerList = new LinkedList<>();

    /**
     * 获取处理器表
     *
     * @return 处理器表
     */
    public List<IEventHandler<E>> getHandlerList() {
        return handlerList;
    }

    /**
     * 处理事件
     *
     * @param event 事件
     */
    public void handle(E event) {
        handlerList.forEach(handler -> handler.invoke(event));
    }


    /**
     * 事件处理器
     *
     * @author Tomoto
     * @version 1.0 2022/8/17 10:36
     * @since 1.0
     */
    public interface IEventHandler<E extends IEvent> {

        /**
         * 处理事件
         *
         * @param event 事件
         */
        void invoke(E event);

    }

}
