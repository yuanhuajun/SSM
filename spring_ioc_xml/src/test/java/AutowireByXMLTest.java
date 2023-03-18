import com.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:41
 * @Description
 * 自动装配：
 * 根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的的类类属性或接口类型的属性赋值
 * 自动装配的策略：
 * 1、no、default：表示不装配，即不bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
 * 2、byType:根据要赋值的属性的类型，在IOC容器中匹配某个bean，为属性赋值
 * 注意：
 * a>若通过类型没有找到任何一个类型匹配的bean，此时不匹配，属性使用默认值
 * b>若通过类型找到多个类型匹配的bean，此时回抛出异常：NoUniqueBeanDefinitionException
 * 总结：当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
 * 3、byName：将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
 */


public class AutowireByXMLTest {

    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.saveUser();
    }
}
