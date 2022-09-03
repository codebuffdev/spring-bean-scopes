package in.spdev.scopes.applicationscope.webapp1;

import in.spdev.scopes.applicationscope.api.ApplicationScopeTest;
import in.spdev.scopes.applicationscope.api.SingletonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app1")
public class Controller1 {
    @Autowired
    private ApplicationScopeTest applicationScopeTest;

    @Autowired
    private SingletonTest singletonTest;

    @RequestMapping("/changeDefaultValues")
    @ResponseBody
    public String changeDefaultValues(){
        applicationScopeTest.setNumber(5);
        singletonTest.setNumber(5);
        return "App One >>>  " + "ApplicationScopeTest value " + applicationScopeTest.getNumber()+"\n" +
                "singletonTest value " + singletonTest.getNumber();
    }
}
