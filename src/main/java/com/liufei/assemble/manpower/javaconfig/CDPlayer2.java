package com.liufei.assemble.manpower.javaconfig;

import com.liufei.assemble.manpower.javaconfig.source.CompactDisc;
import com.liufei.assemble.manpower.javaconfig.source.MediaPlayer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("aaa")
public class CDPlayer2 implements MediaPlayer {


    public CDPlayer2(CompactDisc sgtPeppersPlay) {
        System.out.println("进入了"+CDPlayer2.class+"  的构造方法");
    }

    @Override
    public void play() {
        System.out.println("进入了"+CDPlayer2.class+"  的play方法");
    }
}
