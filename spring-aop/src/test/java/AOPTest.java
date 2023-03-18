import com.aop.annotation.Calculator;
import com.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 8:29
 * @Description
 * 基于注解的aop
 */


public class AOPTest {
    @Test
    public void testAopByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.div(3,1);
    }
}
