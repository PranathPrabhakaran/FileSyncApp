/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filecopyapp;


import com.google.common.eventbus.*;
import java.util.*;

/**
 *
 * @author Pranath
 */
public class TestSubscriber {

    List<PathEventContext> pathEvents = new ArrayList<>();

    //@Override
    @Subscribe
    public void handlePathEvents(PathEventContext pathEventContext) {
        pathEvents.add(pathEventContext);

    }
}
