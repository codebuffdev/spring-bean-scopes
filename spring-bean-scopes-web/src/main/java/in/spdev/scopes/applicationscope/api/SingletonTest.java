package in.spdev.scopes.applicationscope.api;

import org.springframework.stereotype.Component;

@Component
public class SingletonTest {
    private int number = 0;

    public SingletonTest() {
        System.out.println("SingletonTest Initialize");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
