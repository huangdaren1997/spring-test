package hdr.spring.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    @Autowired
    private BeanA beanA;

    private String name;

    public BeanB() {
        this.name = "Class B";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
