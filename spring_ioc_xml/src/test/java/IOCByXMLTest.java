import com.pojo.Clazz;
import com.pojo.Person;
import com.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/14 6:51
 * @Description
 */


public class IOCByXMLTest {

    /**
     * 获取bean的三种方式
     * 1、根据id
     * 2、根据bean的类型
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean （事实上，没有必要在xml中给一个class配置两个不同的bean，可通过scope取消单例）
     * 3.根据bean的id和类型获取
     * 4.如果组件实现了接口，可与根据与接口类型获取bean，前提是bean唯一
     *   即通过bean的类型，bean所继承的类型、bean所实现的接口类型都可获取bean
     */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = (Student) ioc.getBean("studentOne");
        // Student student1 = ioc.getBean(Student.class);
        //3.根据bean的id和类型获取
        Student student2 = ioc.getBean("studentOne",Student.class);
        //4.
        Person bean = ioc.getBean("studentOne",Person.class);

        System.out.println(bean);
    }


    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //setter注入
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
        //构造器注入
        Student studentThree = ioc.getBean("studentThree", Student.class);
        System.out.println(studentThree);

        //null值、大于小于号
        Student studentFour = ioc.getBean("studentFour", Student.class);
        System.out.println(studentFour);

        //为类属性赋值(1.ref引用外部bean；2.级联赋值；3.内部bean(内部bean只能在bean的内部使用，无法直接通过IOC容器获取)
        Student studentFive = ioc.getBean("studentFive", Student.class);
        System.out.println(studentFive);
        //为list集合类型属性赋值，实现一对多
        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);

        //p命名空间
        Student studentSix = ioc.getBean("studentSix", Student.class);
        System.out.println(studentSix);


    }
}
