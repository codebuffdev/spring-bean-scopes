package in.spdev.scopes.applicationscope.api;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class ApplicationScopeTest {
    private int number = 0;

    public ApplicationScopeTest() {
        System.out.println("ApplicationScopeTest Initialize");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
