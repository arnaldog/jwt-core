package com.aim.atlas.app.authapi.security;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class TenantContext {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TenantContext.class.getName());
    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();
    public static void setCurrentTenant(String tenant) {
        logger.debug("Setting tenant to " + tenant);
        currentTenant.set(tenant);
    }
    public static String getCurrentTenant() {
        return currentTenant.get();
    }
    public static void clear() {
        currentTenant.set(null);
    }
}