package com.liufei.assemble.manpower.javaconfig.source;

/**
 *
 * spring通过Java代码自动装配bean
 *
 *
 * 第一步：播放机接口，该接口所有实现类都可以注入
 */
public interface CompactDisc {
    /**
     * 播放方法
     */
    String play();
}
