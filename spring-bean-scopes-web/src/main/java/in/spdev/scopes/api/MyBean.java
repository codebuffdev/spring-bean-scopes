package in.spdev.scopes.api;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) // with each req a new Object will be created for the bean
//@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
//@RequestScope
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) //1 object per session
@SessionScope
public class MyBean {

    public MyBean() {
        System.out.println("MyBean object is created " + InstanceTracker.getYourInstanceTracked());
    }

    private String webSiteName = "in.spdev.com";

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }
}
