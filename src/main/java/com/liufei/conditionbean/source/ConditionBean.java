package com.liufei.conditionbean.source;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 按照条件创建bean，如果返回true，则创建bean，false则不创建。
 */
public interface ConditionBean {
    /*检查是否符合创建条件的方法*/
    boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
}
