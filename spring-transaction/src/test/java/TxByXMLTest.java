import com.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 22:37
 * @Description

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByXMLTest {
    @Autowired
    private BookController bookController;


    @Test
    public void testBuyBook(){
        bookController.byBook(1,1);
        //bookController.checkOut(1,new Integer[]{1,2});

    }
}
