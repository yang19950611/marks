package com.zy.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * javax.servlet.AsyncListener - 如果在添加了侦听器的ServletRequest上启动的异步操作已完成，超时或导致错误，将会通知侦听器。
 * javax.servlet.ServletContextListener - 用于接收关于ServletContext生命周期更改的通知事件的接口。
 * javax.servlet.ServletContextAttributeListener - 接收关于ServletContext属性更改的通知事件的接口。
 * javax.servlet.ServletRequestListener - 用于接收关于进入和超出Web应用程序范围的请求的通知事件的接口。
 * javax.servlet.ServletRequestAttributeListener - 接收关于ServletRequest属性更改的通知事件的接口。
 * javax.servlet.http.HttpSessionListener - 接收关于HttpSession生命周期更改的通知事件的接口。
 * javax.servlet.http.HttpSessionBindingListener - 使对象从会话绑定到绑定或从其绑定时被通知。
 * javax.servlet.http.HttpSessionAttributeListener - 用于接收关于HttpSession属性更改的通知事件的接口。
 * javax.servlet.http.HttpSessionActivationListener - 绑定到会话的对象可能会侦听容器事件，通知他们会话将被钝化，该会话将被激活。需要在VM或持久化会话之间迁移会话的容器来通知绑定到实现HttpSessionActivationListener的会话的所有属性。
 */
public class MyListener implements AsyncListener, ServletContextListener, ServletContextAttributeListener, ServletRequestListener,
        ServletRequestAttributeListener, HttpSessionListener, HttpSessionBindingListener, HttpSessionAttributeListener, HttpSessionActivationListener {

    private static Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onComplete(AsyncEvent event) throws IOException {

    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {

    }

    @Override
    public void onError(AsyncEvent event) throws IOException {

    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("-----myListener.......contextInitialized....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
