import com.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:13
 * @Description
 */


public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        //在spring-factory.xml中并不是将UserFactoryBean交给容器，而是将它的getObject()方法返回值交给IOC
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
