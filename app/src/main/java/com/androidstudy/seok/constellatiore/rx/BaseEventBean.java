package com.androidstudy.seok.constellatiore.rx;

/**
 * @author: seok hzl
 * @date: 2022/1/13
 */
public class BaseEventBean {
    private int type;
    private Object event;

    public BaseEventBean(int type, Object event) {
        this.type = type;
        this.event = event;
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }
}
