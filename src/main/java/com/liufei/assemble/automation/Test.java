package com.liufei.assemble.automation;

import com.liufei.assemble.automation.source.MediaPlayer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //
public class Test implements MediaPlayer {
    @Override
    public void play() {

    }
}
