import com.proxy.*;
import org.junit.Test;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 19:08
 * @Description
 * 动态代理有两种：
 * 1、jdk动态代理，要求必须有接口，最终生成的代理类在com.sum。proxy下，类名为$proxy2
 * 2、cglib动态代理,最终生成的代理类会继承目标类，并且和目标类在相同的包下
 */


public class ProxyTest {
    @Test
    public void testProxy(){
        //静态代理
        // Calculator calculator = new CalculatorImpl();
        // CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        // calculatorStaticProxy.add(1,3);
        //动态代理
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(3,5);

    }
}
