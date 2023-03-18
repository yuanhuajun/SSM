import com.mapper.EmpMapper;
import com.pojo.Emp;
import com.pojo.EmpExample;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 16:55
 * @Description
 */


public class MBGTest {
    @Test
    public  void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        /*
        查询单条数据
         */
        // Emp emp = mapper.selectByPrimaryKey(1);
        /*
        // 查询所有数据
        //  */
        // List<Emp> emps = mapper.selectByExample(null);
        // System.out.println(emps);

        /*
         * 根据条件查询
         */
        // EmpExample example = new EmpExample();
        // example.createCriteria().andAgeBetween(32,35);
        // List<Emp> emps1 = mapper.selectByExample(example);
        // System.out.println(emps1);

        //测试普通修改
        Emp emp = new Emp(1,"小黑",20,"男",null);
        // mapper.updateByPrimaryKey(emp);

        //测试选择性修改 (值为null的属性对应的字段不会被修改）
        int i = mapper.updateByPrimaryKeySelective(emp);

    }
}
