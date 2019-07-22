package com.liufei.assemble.automation;

import com.liufei.assemble.automation.source.CompactDisc;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 第二步：光盘接口，需要实现播放机接口才可以展现结果
 *
 * Component自定义bean的id:
 *  (1)该类作为组件，自动创建该类的bean，bean默认的id为类名小写，如果需要指定bean的id，需要使用@Component("名称")
 *  (2)或者使用Java自带依赖注入规范，使用@Named("名称")注解为组件命名，spring支持@Named注解的使用，效果和@Component有细微差别，但是不影响使用(不常用)
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SgtPeppersPlay implements CompactDisc {

    public SgtPeppersPlay(){
        System.out.println("我使用播放机播放了喜羊羊，该类地址："+ SgtPeppersPlay.class);
    }


    @Override
    public String play() {
        System.out.println("我使用播放机播放了喜羊羊，该类地址："+ SgtPeppersPlay.class);
        return "该类地址："+ SgtPeppersPlay.class;
    }
}
