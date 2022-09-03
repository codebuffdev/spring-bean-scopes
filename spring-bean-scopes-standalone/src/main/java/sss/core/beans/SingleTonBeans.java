package sss.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stBeans")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingleTonBeans {

    private PrototypeBean prototypeBean;

    @Autowired
    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }
}
