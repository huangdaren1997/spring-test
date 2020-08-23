package hdr.spring.test.processor;

import hdr.spring.test.bean.InstantiationAwarePostProcessorBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor, BeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.isAssignableFrom(InstantiationAwarePostProcessorBean.class)){
            System.out.println("---------------- execute postProcessBeforeInstantiation -------------------");
            InstantiationAwarePostProcessorBean bean = new InstantiationAwarePostProcessorBean();
            bean.setName("测试InstantiationAwareBeanPostProcessor的Bean");
            return null;
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // do nothing just use to debug
        if (bean.getClass().isAssignableFrom(InstantiationAwarePostProcessorBean.class)){
            System.out.println("---------------- execute postProcessBeforeInitialization -------------------");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // do nothing just use to debug
        if (bean.getClass().isAssignableFrom(InstantiationAwarePostProcessorBean.class)){
            System.out.println("---------------- execute postProcessAfterInitialization -------------------");
        }
        return bean;
    }
}
