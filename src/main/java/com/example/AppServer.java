package com.example;

import com.example.config.ConfigManager;
import com.example.config.Configuration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Date;

public class AppServer {

    static final Logger logger = LogManager.getLogger(AppServer.class.getName());
    static final Configuration configuration = ConfigManager.getConfiguration();

    public static final String SERVER_PORT = "server.port";
    public static final String WEB_XML = "WEB-INF/web.xml";
    public static final String RESOURCE_BASE = "web";

    public static void main(String[] args) throws Exception {

        try {
            Server server = new Server(Integer.parseInt(configuration.read(SERVER_PORT)));

            WebAppContext context = new WebAppContext();
            context.setDescriptor(WEB_XML);
            context.setResourceBase(RESOURCE_BASE);
            context.setContextPath("/");
            context.setParentLoaderPriority(true);

            server.setHandler(context);

            logger.warn("Hi there!");

            System.out.println("Server starting...");
            server.start();
            System.out.println("Server started at: " + new Date().toString());

            server.join();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error Starting server! cause: " + ex.getMessage());
        }
    }
}
