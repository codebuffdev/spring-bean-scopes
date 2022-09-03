package in.spdev.scopes.applicationscope.webapp2;

import in.spdev.scopes.applicationscope.api.ApplicationScopeTest;
import in.spdev.scopes.applicationscope.api.SingletonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Controller2 {
    @Autowired
    private ApplicationScopeTest applicationScopeTest;

    @Autowired
    private SingletonTest singletonTest;

    @RequestMapping("/accessValues")
    @ResponseBody
    public String accessValues(){
        return "App One >>>  " + "ApplicationScopeTest value " + applicationScopeTest.getNumber()+"\n" +
                "singletonTest value " + singletonTest.getNumber();
    }
}
