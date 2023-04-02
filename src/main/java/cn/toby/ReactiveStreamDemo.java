package cn.toby;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamDemo {
    public static void main(String[] args) {
        var publisher = new SubmissionPublisher();
        Flow.Subscriber subscriber = new Flow.Subscriber() {
            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("build subscription connection");
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Object item) {
                System.out.println("process data: " + item);
                subscription.request(10);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("some error occurred");
            }

            @Override
            public void onComplete() {
                System.out.println("all done");
            }
        };

        publisher.subscribe(subscriber);

        for (int i = 0; i < 100; i++) {
            publisher.submit("hi reactive " + i);
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
