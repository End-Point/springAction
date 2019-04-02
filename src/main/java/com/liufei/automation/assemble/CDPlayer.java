package com.liufei.automation.assemble;

import com.liufei.automation.assemble.source.CompactDisc;
import com.liufei.automation.assemble.source.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  --@Autowired注解可以用在属性上、方法上
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    /**
     * --@Autowired注解：该注解可以用在构造方法、set方法和其他组件的类上。
     *  用在方法上，会根据方法的参数去spring容器中查找相符的bean，如果找到，则注入；
     *  如果没找到，会报错，可以使用required=false压制错误，但是，如果注入为null，则会报空指针错误，很难排查，这个属性慎用。
     *  比如：SgtPeppersPlay实现了CompactDisc接口，在该类中使用了@Component注解，我在该类中构造方法中注入了CompactDisc接口，并在该构造方法上加入了@autowired注解，
     *  启动后，spring会去容器中查找CompactDisc接口及其实现类，进行注入。
     *    注意：CompactDisc接口有多个实现类时，spring会根据上下文找到适合注入的那个实现类，可能注入的并不对，这种情况下需要明确指定注入的实现类
     * @param cd2
     */
    @Autowired
    public CDPlayer(CompactDisc cd2){
        if(cd2!=null){
            System.out.println(CDPlayer.class+"---注入成功CompactDisc的play方法输出信息为："+cd2.play());
        }else{
            System.out.println("注入失败");
        }

    }

    @Override
    public void play() {
        System.out.println("进入了"+CDPlayer.class+" 类的 play方法");
    }
}
