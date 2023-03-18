import com.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/13 23:18
 * @Description
 */


public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloworld = (HelloWorld)applicationContext.getBean("helloworld");
        helloworld.sayHello();
    }
}
