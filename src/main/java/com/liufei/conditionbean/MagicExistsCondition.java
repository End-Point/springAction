package com.liufei.conditionbean;

import com.liufei.conditionbean.source.ConditionBean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现了Condition接口，实现matches()方法，用于判断该@Bean是否符合创建条件
 */
public class MagicExistsCondition implements Condition {
    /**
     * 方法解释：matches()方法通过ConditionContext对象得到Environment对象，Environment对象调用containsProperty()方法检查环境中是否存在名为“magic”的
     *       环境属性，在该本示例中，属性的值是什么无所谓，只要属性存在即可满足要求。如果满足这个条件的话，matches()方法最后返回true，然后回到使用@Condiional
     *       注解的@Bean方法，得到返回的boolean值决定是否创建Bean对象。
     *      <hr>
     *    方法参数ConditionContext解释，它是一个接口：里面有几个方法：该参数主要是查看bean对象内部的属性或其他信息<br>
     *      (1)getRegistry()方法，返回值为BeanDefinitionRegistry，检查bean的定义；<br>
     *      (2)getBeanFactory(),返回值为ConfigurableListableBeanFactory，检查bean是否存在，还可以查看bean的属性
     *      (3)getEnvironment()，检查环境变量是否存在，以及它的值是什么<br>
     *      (4)getResourceLoader(),返回值为 ResourceLoader，返回ResourceLoader所加载的资源<br>
     *      (5)getClassLoader()，返回值为ClassLoader，加载该ClassLoader，并检查类是否存在
     *     <hr>
     *     方法参数AnnotatedTypeMetadata，它是一个接口，该参数主要是让我们检查该bean对象上还有哪些其他注解：
     *      (1) isAnnotated(String annotationName):返回值是boolean ，判断该bean中是否有特定的注解。
     *      (2)getAnnotationAttributes(String annotationName),返回值为Map<String, Object> ，获取某个注解中的所有属性。
     *      (3)getAllAnnotationAttributes(String annotationName),返回值为MultiValueMap<String, Object>，获取某个注解的所有属性值。
     *
     *
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        //判断是否包含magic属性，返回true或者false
        return env.containsProperty("magic");
    }
}
