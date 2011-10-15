/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.osgi;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;


public interface ClassFinder {
	
    /**
     * Find, resolve, and return this class definition.
     * Static convenience method.
     * @param className
     * @return The class definition or null if not found.
     */
    public Class<?> findClass(String className);
    /**
     * Find, resolve, and return this resource's URL.
     * Static convenience method.
     * @param className
     * @return The class definition or null if not found.
     */
    public URL findResourceURL(String className);
    /**
     * Find, resolve, and return this ResourceBundle.
     * Static convenience method.
     * @param className
     * @return The class definition or null if not found.
     */
    public ResourceBundle findResourceBundle(String className, Locale locale);

    /**
     * Convert this encoded string back to a Java Object.
     * TODO This is expensive, I need to synchronize and use a static writer.
     * @param className
     * @param string The string to convert.
     * @return The java object.
     */
    public Object findConvertStringToObject(String className, String string);

    /**
     * Find, resolve, and return this bundle.
     * @param packageName
     */
    public Bundle findBundle(String packageName, String version);
    
    /**
     * Find the currently installed bundle that exports this package.
     * @param context
     * @param version
     * @param resource
     * @return
     */
    public Bundle findBundle(Object objResource, BundleContext context, String packageName, String version);

    /**
     * Get the bundle classloader for this package.
     * @param string The class name to find the bundle for.
     * @return The class loader.
     * @throws ClassNotFoundException
     */
    public ClassLoader findBundleClassLoader(String packageName);

    /**
     * Find this class's class access registered class access service in the current workspace.
     * @param interfaceName The registered object name
     * @param className The class name (that has the package that the object was registered under)
     * @return
     */
    public BundleService getClassBundleService(String interfaceName, String className);
    /**
     * Find this resource in the repository, then deploy and optionally start it.
     * @param version TODO
     * @param className
     * @param options 
     * @return
     */
    public Object deployThisResource(String packageName, String version, boolean start);
    /**
     * Shutdown the bundle for this service.
     * @param service The service object
     */
    public void shutdownService(Object service);
}
