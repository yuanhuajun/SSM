import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmpMapper;
import com.pojo.Emp;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 18:16
 * @Description
 */


public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前，开启分页功能
        Page<Object> objects = PageHelper.startPage(2, 5);
        List<Emp> emps = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);
        emps.forEach(System.out::println);
        System.out.println(objects);
        System.out.println(pageInfo);


    }
}
