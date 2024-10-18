package com.potatotech.testesbackend.config.interceptor;


import com.potatotech.authorization.exception.ServiceException;
import com.potatotech.authorization.security.Authenticate;
import com.potatotech.authorization.security.UserSupplier;
import com.potatotech.authorization.tenant.TenantConfiguration;
import com.potatotech.authorization.tenant.TenantContext;
import com.potatotech.testesbackend.config.migration.DBMigration;
import feign.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;

@Configuration
public class InterceptorConfig extends Authenticate implements HandlerInterceptor, WebMvcConfigurer  {


    @Autowired
    DBMigration dbMigration;

    private static final String AUTHORIZATION = "Authorization";
    private static final String TENANT = "Xtenant";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        var tenantConfiguration = new TenantConfiguration();

        String uri = request.getRequestURI();

        if(uri.startsWith("/testes-backend/swagger-ui/") || uri.startsWith("/testes-backend/v3/")) {
            return true;
        }

        if(isOptions(request)){
            return true;
        }
        var auth = request.getHeader(AUTHORIZATION);
        var tenant = request.getHeader(TENANT);
        tenant = "public";

//        if(!tenantConfiguration.validAnonymous(handler)){
//            var user = this.isAuthenticated(auth);
//            TenantContext.setCurrentTenant(user.getTenant());
//            TenantContext.setCurrentUser(user);
//        } else {
            if(tenant == null){
                //throw new ServiceException(HttpStatus.FORBIDDEN,"tenant is required");
            }

            TenantContext.setCurrentTenant(tenant);
        //}
        dbMigration.loadMigrateTenants(tenant);
        return true;
    }


    private boolean isOptions(HttpServletRequest request){
        return Request.HttpMethod.OPTIONS.equals(request.getMethod());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(this);
    }
}
