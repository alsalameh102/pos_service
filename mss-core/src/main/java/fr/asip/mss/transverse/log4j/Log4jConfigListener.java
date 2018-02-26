/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.asip.mss.transverse.log4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.util.Log4jWebConfigurer;
import org.springframework.web.util.WebAppRootListener;

/**
 * Bootstrap listener for custom log4j initialization in a web environment.
 * Delegates to {@link Log4jWebConfigurer} (see its javadoc for configuration
 * details).
 * 
 * <b>WARNING: Assumes an expanded WAR file</b>, both for loading the
 * configuration file and for writing the log files. If you want to keep your
 * WAR unexpanded or don't need application-specific log files within the WAR
 * directory, don't use log4j setup within the application (thus, don't use
 * Log4jConfigListener or Log4jConfigServlet). Instead, use a global, VM-wide
 * log4j setup (for example, in JBoss) or JDK 1.4's
 * <code>java.util.logging</code> (which is global too).
 * 
 * <p>
 * This listener should be registered before ContextLoaderListener in
 * <code>web.xml</code> when using custom log4j initialization.
 * 
 * @author Juergen Hoeller
 * @since 13.03.2003
 * @see Log4jWebConfigurer
 * @see org.springframework.web.context.ContextLoaderListener
 * @see WebAppRootListener
 */
public class Log4jConfigListener implements ServletContextListener {

    @Override
    public void contextDestroyed(final ServletContextEvent event) {
        Log4jWebConfigurerCustom.shutdownLogging(event.getServletContext());
    }

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        Log4jWebConfigurerCustom.initLogging(event.getServletContext());
    }
}