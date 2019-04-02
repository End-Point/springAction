package com.liufei.automation.assemble.test;

import com.liufei.automation.assemble.CDPlayConfig;
import com.liufei.automation.assemble.source.CompactDisc;
import com.liufei.automation.assemble.source.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 验证CDPlayer类的@autowired注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载特定的配置文件
@ContextConfiguration(classes = CDPlayConfig.class)
public class CDPlayerConfigTest {
    @Autowired
    private MediaPlayer player;
    @Autowired
    private CompactDisc cd;


    @Test
    public void isNull(){
        System.out.println("CompactDisc接口是否为null:"+(cd == null?"true":"false")+"---该类地址为："+CDPlayerConfigTest.class);
    }

    @Test
    public void play(){
        //调用MediaPlayer接口的paly方法，会发生多态
        player.play();

    }


}
