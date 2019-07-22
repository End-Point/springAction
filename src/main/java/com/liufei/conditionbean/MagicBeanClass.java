package com.liufei.conditionbean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 用于测试条件配置Bean的类
 */
@Configuration
public class MagicBeanClass {

    /**
     * 想要使用@Conditional注解，传入的参数必须实现Condition接口，
     * MagicExistsCondition该类实现了Condition接口，重写了Condition接口的matches方法。
     * @return
     */
    @Bean
    @Conditional({MagicExistsCondition.class})
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //指定注解的作用域范围。
    public MagicBean magicBean(){
        return new MagicBean();
    }

}
