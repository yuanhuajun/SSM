import com.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 14:16
 * @Description
 */


public class IOCByAnnotationTest {

    /**
     *@Repository：该注解主要针对于数据访问层的（Dao，持久化层）
     * @Service：该注解主要针对于业务逻辑层（service层）
     * @Controller：该注解主要针对于控制器层（servlet层 ，Controller层）
     * @Component：该注解不属于任何层，当该类不知道属于以上三类的那一类时可以使用该注解。
     * 通过注解+扫描配置bean的id，默认为类的小驼峰，即类名的首字母为小写的结果,也可以在注解时通过注解的value属性自定义
     *
     * @Autowired：实现自动装配的注解、
     * 1.@Autowired注解能和标识的位置
     * a>标识在成员变量上，此时不需要get和set方法
     * b>标识在set方法上
     * c>标识在为当前成员变量赋值的有参构造上
     * 2.@Autowired注解的原理：
     * a>默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     * b>若有多个类型匹配的bean，此时会自动转换为byName方式实现自动装配效果
     * 即将要赋值的属性的属性名作为bean的id匹配某个bean的属性值
     * c>若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean，且这些bean的id和要赋值的属性的属性名都不一致。此时异常：NoUniqueBeanDeffinitionException
     * d>此时可在要赋值的属性上，添加一个注解@Qualifier，通过指定该注解的value属性，指定某个bean的id，将这个bean来为属性赋值
     *
     * 注意：若IOC容器中没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     * 在@Autowired注解中有个属性required，默认值为true，要求必须完成自动装配；可以将required设置为flase，此时能装配就装装配，不能装配属性就使用默认值。
     */
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController controller = ioc.getBean("userController",UserController.class);
        controller.saveUser();
    }

}
