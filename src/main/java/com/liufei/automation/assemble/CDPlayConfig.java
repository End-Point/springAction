package com.liufei.automation.assemble;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 第三步：开启扫描包，扫描带有@Component的注解
 */
//表示该类为配置类，相当于XML文件
@Configuration
/*
  开启组件扫描包，只要有@Component注解的类，都会为其创建bean对象，bean的id为类名首字母小写。
    格式：
    (1)@ComponentScan：默认扫描包含@ComponentScan注解的包及其子孙包。
    (2) @ComponentScan(value=”com.xxx”):默认扫描指定包及其子孙包
    (3) @ComponentScan(basePackage={”com.xxx”,”com.xxx2”}):指定多个基础扫描包，该属性和value属性功能相同。
    (4)@ComponentScan(basePackageClasses ={xxxClass.class,xxxClass2.class}):以basePackageClasses中的类所在的包为基础扫描包，并扫描其下的子孙包
 */
@ComponentScan(value = "com.liufei.automation")
public class CDPlayConfig {
}
