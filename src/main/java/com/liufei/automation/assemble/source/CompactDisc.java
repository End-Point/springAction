package com.liufei.automation.assemble.source;

/**
 *
 * spring自动装备bean：
 * 思路：(1)先创建一个播放机(CompactDisc)接口；
 *       (2)再创建一个播放机接口的实现类(SgtPeppersPlay)添加@Component注解，表示这是组件类；
 *       (3)最后创建一个配置类(CDPlayConfig)，使用@Configuration注解表示这是配置类，启动时加载。使用@ComponentScan注解，扫描带有@Component注解的类，
 *          并创建该类的bean。
 *        (4)测试：创建测试类(CDPlayConfigTest)，注入CompactDisc接口，利用多态查看该接口的实现类是否被创建。
 *
 * 第一步：播放机接口，该接口所有实现类都可以注入
 */
public interface CompactDisc {
    /**
     * 播放方法
     */
    String play();
}
