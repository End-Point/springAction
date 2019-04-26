package com.liufei.assemble.manpower.javaconfig.test;

import com.liufei.assemble.manpower.javaconfig.CDPlayConfig;
import com.liufei.assemble.manpower.javaconfig.CDPlayer;
import com.liufei.assemble.manpower.javaconfig.CDPlayer2;
import com.liufei.assemble.manpower.javaconfig.source.CompactDisc;
import com.liufei.assemble.manpower.javaconfig.source.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 验证CDPlayer类的@autowired注解
 *
 *  --@Autowired注解：该注解可以用在构造方法、set方法和其他组件的类上。
 *      *  用在方法上，会根据方法的参数去spring容器中查找相符的bean，如果找到，则注入；
 *      *  如果没找到，会报错，可以使用required=false压制错误，但是，如果注入为null，则会报空指针错误，很难排查，这个属性慎用。
 *      *  比如：SgtPeppersPlay实现了CompactDisc接口，在该类中使用了@Component注解，我在该类中构造方法中注入了CompactDisc接口，并在该构造方法上加入了@autowired注解，
 *      *  启动后，spring会去容器中查找CompactDisc接口及其实现类，进行注入。
 *      *    注意：CompactDisc接口有多个实现类时，spring会根据上下文找到适合注入的那个实现类，可能注入的并不对，这种情况下需要明确指定注入的实现类
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载特定的配置文件
@ContextConfiguration(classes = CDPlayConfig.class)
public class CDPlayerConfigTest {
    /*  这里对应了 com\liufei\assemble\manpower\javaconfig\CDPlayConfig类的cdPlayer()和cdPlayer2()两个方法
      当spring容器中有多个同类型的bean时，需要使用@Resource(name = "anotherCDPlayer")注解，指定bean的id命进行注入，否则
    * spring不知道在多个同类型的bean中选择哪个bean进行注入，所以会报错。
    * */
//    @Autowired
    @Resource(name = "anotherCDPlayer")
    private MediaPlayer player;
    @Autowired
    private CompactDisc cd;


    @Autowired
    private CDPlayer cdPlayer1;
    @Autowired
    private CDPlayer2 cdPlayer2;


    @Test
    public void isNull(){
        System.out.println("CompactDisc接口是否为null:"+(cd == null?"true":"false")+"---该类地址为："+ CDPlayerConfigTest.class);
    }

    @Test
    public void play(){
        //调用MediaPlayer接口的paly方法，会发生多态
        player.play();

    }


}
