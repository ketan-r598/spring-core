package io.java_core.infrastructure;

import io.java_core.repository.TaskRepository;
import io.java_core.service.IService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TaskBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TaskRepository || bean instanceof IService) {
            System.out.println("[BPP] - " + beanName + " is initializing...");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TaskRepository || bean instanceof IService) {
            System.out.println("[BPP] - " + beanName + " is ready to use...");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
