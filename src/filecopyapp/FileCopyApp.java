/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filecopyapp;

import java.nio.file.*;
import com.google.common.eventbus.*;
import java.util.*;

/**
 *
 * @author Pranath
 */
public class FileCopyApp {

    static boolean running = true;

    public static void main(String[] args) {
       
        try {
            //while (running == true) {
            Path pathDir1 = Paths.get("D:\\College");
            EventBus eventBus = new EventBus();
            TestSubscriber subscriber = new TestSubscriber();
            DirectoryEventWatcherImpl dir1 = new DirectoryEventWatcherImpl(eventBus, pathDir1);
            eventBus.register(subscriber);
            dir1.start();
            while (dir1.isRunning()) {
                System.out.println(subscriber.pathEvents.size());
                if (subscriber.pathEvents.size() > 0) {
                    List<PathEventContext> eventContexts = subscriber.pathEvents;
                    for (PathEventContext eventContext : eventContexts) {
                        Path dir = eventContext.getWatchedDirectory();
                        Path target = eventContext.getEvents().get(0).getEventTarget();
                        System.out.println(target.toString());
                    }
                }
            }
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void stop() {
        running = false;
    }
}
