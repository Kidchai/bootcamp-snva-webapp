package servlet_examples.requestListener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerDemo implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request initialized");
    }

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request destroyed");
    }
}
