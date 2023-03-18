import com.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 11:19
 * @Description
 */


public class LifeCycleTest {
    /**
     * 1、实例化
     * 2、依赖注入
     * 3、后置处理器的postProcessBeforeInitialization
     * 4、初始化，需要通过bean的init-method属性指定
     * 5、后置处理器的postProcessAfterInitialization
     * 6.销毁需要通过bean的destroy-method属性指定，并且需要手动关闭IOC容器
     *
     * 注意：
     * 若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
     * 若bean的作用域为多例时，生命周期的的前三个步骤会在获取bean时执行，并且销毁步骤不由IOC控制
     *
     */

    @Test
    public void test(){
        //ConfigurableApplicationContext提供了关闭ioc的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
