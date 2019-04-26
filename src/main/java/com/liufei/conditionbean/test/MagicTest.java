package com.liufei.conditionbean.test;


import com.liufei.conditionbean.MagicBeanClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//加载特定的配置文件
@ContextConfiguration(classes = MagicBeanClass.class)
public class MagicTest {


}
