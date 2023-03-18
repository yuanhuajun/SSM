import com.mapper.DynamicSQLMapper;
import com.pojo.Emp;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 13:10
 * @Description
 */


public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpyByCondition(new Emp(null, "", 22, ""));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empyByChoose = mapper.getEmpyByChoose(new Emp(null, "", 22, ""));
        System.out.println(empyByChoose);
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"小明",20,"男");
        Emp emp2 = new Emp(null,"小明2", 20,"男");
        Emp emp3 = new Emp(null,"小明3",20,"男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insetMoreEmp(emps);
    }


    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] integers = new Integer[]{36,37,38};
        mapper.deleteMoreEmp(integers);
    }
}
