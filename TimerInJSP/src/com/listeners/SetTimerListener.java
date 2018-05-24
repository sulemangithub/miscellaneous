package com.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SetTimerListener
 *
 */
public class SetTimerListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
    
    	arg0.getSession().setAttribute("minutes", 9);
    	arg0.getSession().setAttribute("seconds", 60);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
