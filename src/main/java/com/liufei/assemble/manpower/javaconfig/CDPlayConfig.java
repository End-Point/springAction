package com.liufei.assemble.manpower.javaconfig;

import com.liufei.assemble.manpower.javaconfig.source.CompactDisc;
import com.liufei.assemble.manpower.javaconfig.source.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;

/**
 *
 */
//表示该类为配置类，相当于XML文件
    @Configuration
    //@Import() //引入其他@Configuration配置文件 格式为@Import(类名.class) 或者@Import({类名.class,类名.class})
//@ImportResource("classpath:配置文件.xml") //用来引入xml类型的配置文件
public class CDPlayConfig {

    private CDPlayer cdPlayer1;
    private CDPlayer2 cdPlayer2;

    /**
     * ---@Bean注解：
     *     <p>应用在带有@Configuration注解的类中，表明该方法是一个bean，在@Configuration加载时会执行@Bean注解下的方法，然后创建该方法返回值的对象，
     *     一般带有@Bean注解的方法的返回值都是对象类型，然后spring会为这个返回值创建一个Bean，并添加到spring容器中，供以后使用。该注解一般用于第
     *     三方工具，在无法使用@Autowired的情况下使用，需要和@Configretion配合使用。
     *     <br>
     *     注意：使用@Bean注解后，spring只会在spring容器中创建一个该方法返回值的bean，bean是单例的，每次调用该方法时，@Bean注解会拦截请求，去spring容器
     *     中查找是否有该方法返回值的bean对象，如果有，直接返回,并不会对方法直接调用，而是直接返回bean的对象，如果没有，先创建该方法返回值的bean，加入到spring容器中
     *     并返回给调用者，以后任何请求调用该方法，返回的都是同一个bean对象。多次调用该方法所返回的都是同一个对象.</p>
     *     <br>
     *    比如：创建一个getSgtPeppersPlay()方法返回值类型为CompactDisc接口，在该方法上使用@Bean注解，并且在方法中执行业务逻辑代码返回CompactDisc接口或者
     *          接口的实现类，然后在创建CompactDisc接口的bean，将这个bean加入到spring容器中，以后任何请求调用，都会返回相同的CompactDisc对象，@Bean
     *          时单例模式的。
     *    <hr>
     *  -- 使用@Bean注解的三种方法之一(没有参数传入时使用)：在方法上使用@Bean注解，然后在方法中执行业务逻辑，最后返回一个对象。注解会根据这个对象在spring容器中创建bean，
     *                                  这是最简单的使用方法
     * @return
     */
    @Bean
//    @Bean(name = "beanName") //bean默认名字为类名首字母小写，也可以使用@Bean的name属性指定名字。
    public CompactDisc getSgtPeppersPlay(){
        return new SgtPeppersPlay();
    }



    /** -- @Bean注解使用方法之二：通过调用上方的getSgtPeppersPlay()方法创建CompactDisc对象，将对象注入进来。
     * 如果@Bean是单例模式，则cdPlayer()和anotherCDPlayer()两个方法中创建CDPlayer对象传入的CompactDisc类型应该是同一个对象。
     *
     *
     *  <br>
     *     --@Bean(autowire = Autowire.BY_NAME,value = "cdPlayer")参数解释：
     *      因为spring默认是按照类型创建bean，这样同类型的bean只能有一个，在创建多个同类型bean的情况下回报错，
     *      如果想创建多个同类型的bean，可以指定按照bean的名字创建，设置@Bean注解中的autowire = Autowire.BY_NAME ，设置bean的名字value = "cdPlayer"；
     *      这样可以创建多个同类型的bean，在spring注入时，会根据名字进行查找bean，并注入。
     * @return
     */
    @Bean(autowire = Autowire.BY_NAME,value = "cdPlayer")
    public CDPlayer cdPlayer(){
        //在上方通过手动创建一个CompactDisc的Bean，并调用该方法，将CompactDisc对象注入进来。这是不常用的方法
        cdPlayer1 = new CDPlayer(getSgtPeppersPlay());
        return cdPlayer1;
    }

     //TODO 这里放开会报错，因为spring默认按照by_type进行注入，这里改为按照by_name注入就可以了
    @Bean(autowire = Autowire.BY_NAME,value = "anotherCDPlayer")
    public CDPlayer2 anotherCDPlayer(){
        cdPlayer2 =new CDPlayer2(getSgtPeppersPlay());
        return cdPlayer2;
    }


    /** -- @Bean注解使用方法之三(常用)：将CompactDisc作为方法参数传入。在spring创建bean的时候，会去spring容器中寻找CompactDisc的bean对象，如果找到会将bean注入到
     *                                   方法参数中。
     * 如果@Bean是单例模式，则cdPlayer()和anotherCDPlayer()两个方法中创建CDPlayer对象传入的CompactDisc类型应该是同一个对象。
     * @return
     */
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
          return new CDPlayer(compactDisc);
    }

    /**
     * 随机获取一种CD歌曲
     * @return
     */
    @Bean
    public String randomBeatlesCD(){
        int choic = (int) Math.floor(Math.random() * 4);
        if(choic == 0){
            return new String("没离开过---林志炫");
        }else if (choic == 1){
            return new String("精忠报国---屠洪刚");
        }else {
            return new String("稻香---周杰伦");
        }
    }


}
