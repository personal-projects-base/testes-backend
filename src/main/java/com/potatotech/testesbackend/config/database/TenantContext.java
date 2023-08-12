package com.potatotech.testesbackend.config.database;

import org.springframework.stereotype.Component;

@Component
public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant){
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant(){
        return currentTenant.get();
    }
}
