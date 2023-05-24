package servlet_examples.requestAtributeListener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.printf("Added attribute: %s %s%n", event.getName(), event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.printf("Removed attribute: %s %s%n", event.getName(), event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        Object oldValue = event.getValue();
        Object newValue = event.getServletRequest().getAttribute(event.getName());
        System.out.println("Replaced attribute: " + event.getName() + " " + oldValue);
        System.out.println("Old value: " + oldValue);
        System.out.println("New value: " + newValue);
        System.out.println("==================================");
    }
}
