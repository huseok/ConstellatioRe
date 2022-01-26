package com.androidstudy.seok.constellatiore.rx;

import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * @author: seok hzl
 * @date: 2022/1/13
 */
public class RxBus {
    private static RxBus instance;

    private FlowableProcessor<Object> processorBus;

    public static RxBus build() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    RxBus tempInstance = new RxBus();
                    tempInstance.processorBus = PublishProcessor.create().toSerialized();
                    instance = tempInstance;
                }
            }
        }
        return instance;
    }
    public void postEvent(final int eventType,Object event){
        processorBus.onNext(new BaseEventBean(eventType,event));
    }

    private Flowable toFlowable() {
        return processorBus;
    }

//
//    public Disposable getEvent(RxAppCompatActivity activity, int code, Consumer<BaseEventBean> observer) {
//        return new BuildFlowable(activity, code).bindLifeCycle(toFlowable()).subscribe(observer);
//    }

    private class BuildFlowable {
        public BuildFlowable(RxAppCompatActivity activity, int code) {
        }

        public Flowable<Object> bindLifeCycle(Flowable toFlowable) {
            return null;
        }
    }
}
