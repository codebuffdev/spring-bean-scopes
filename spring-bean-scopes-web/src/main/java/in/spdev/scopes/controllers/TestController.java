package in.spdev.scopes.controllers;

import in.spdev.scopes.api.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private MyBean myBean;

    @RequestMapping("/name")
    public @ResponseBody String projectName() {
        /**
         * Want to display the website-project name to viewers*/
        return myBean.getWebSiteName();
    }

    @RequestMapping("/name-again")
    public @ResponseBody String projectNameUpdated() {
        /**
         * Want to display the website-project name to viewers*/
        myBean.setWebSiteName("www.in.spdev.com");
        return myBean.getWebSiteName();
    }

}