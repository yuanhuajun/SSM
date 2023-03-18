import com.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 20:42
 * @Description
 * 基于xml
 */


public class AOPTest2 {

    @Test
    public void testAOPByXML(){
        ApplicationContext bean = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator bean1 = bean.getBean(Calculator.class);
        bean1.div(3,2);
    }
}
