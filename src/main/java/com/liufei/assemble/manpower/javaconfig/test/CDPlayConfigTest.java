package com.liufei.assemble.manpower.javaconfig.test;

import com.liufei.assemble.manpower.javaconfig.CDPlayConfig;
import com.liufei.assemble.manpower.javaconfig.source.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试SgtPeppersPlay类能否注入到CDPlayConfig配置中
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载特定的配置文件
@ContextConfiguration(classes = CDPlayConfig.class)
public class CDPlayConfigTest {

    /*
    * spring的自动装配功能：使用@Autowired注解
    * 注入接口
    *
    * */
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void compactDiscIsNull(){
        System.out.println(compactDisc != null? "不是null" : "失败了");
    }
}
