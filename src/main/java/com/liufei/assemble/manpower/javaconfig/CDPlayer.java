package com.liufei.assemble.manpower.javaconfig;

import com.liufei.assemble.manpower.javaconfig.source.CompactDisc;
import com.liufei.assemble.manpower.javaconfig.source.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;


    public CDPlayer(){
        System.out.println(CDPlayer.class+"----进入了CDPlayer类的无参构造方法");

    }
    public CDPlayer(CompactDisc cd2){
        this.cd = cd2;
        if(cd2!=null){
            System.out.println(CDPlayer.class+"---注入成功CompactDisc的play方法输出信息为："+cd2.play());
        }else{
            System.out.println("注入失败");
        }

    }

    @Override
    public void play() {
        System.out.println("进入了"+ CDPlayer.class+" 类的 play方法");
    }
}
