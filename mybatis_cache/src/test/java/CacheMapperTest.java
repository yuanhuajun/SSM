import com.mapper.CacheMapper;
import com.pojo.Emp;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 15:14
 * @Description
 */


public class CacheMapperTest {
    @Test
    public  void testGetEmpById(){
        /*
        一级缓存，SqlSession级别的，同一个SqlSession对象，获取相同的数据，只需查询一次，后面从缓存中获取
        一级缓存，默认开启
         */
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(18);
        System.out.println(empById);
        //手动清空缓存
        sqlSession.clearCache();
        Emp empById2 = mapper.getEmpById(56);
        System.out.println(empById2);

        /*
        不同的sqlsesion对象，获取相同的数据，需要多次查询，不能共享缓存
         */

        /*
         * 一级缓存失效的四种情况：
         * 1）不同的SqlSession对应不同的一级缓存
         * 2）同一个SqlSession但是查询条件不同
         * 3）同一个SqlSession两次查询期间执行了任何一次增删改操作
         *         SqlSession sqlSession = SqlSessionUtil.getSqlSession();
                   CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
                   Emp empById = mapper.getEmpById(56);
                   Emp empById1 = mapper.getEmpById(56);
         * 4）同一个SqlSession两次查询期间手动清空了缓存
         */

    }

    /*
     *mybaits二级缓存是SqlSessionFactory级别的，即通过一个SqlSessionFactory所获取的SqlSession查询的数据会被缓存
     *再次通过同一个SqlSessionFactory获取的SqlSession查询相同的数据从缓存中获取
     * 二级缓存开启的条件：
     * 1）在核心配置文件中，设置全局配置属性<cacheEnabled = "true">,默认为true 不需要设置
     * 2）在映射文件中设置标签</cache>
     * 3）二级缓存必须在SqlSession关闭或提交后有效
     * 4）查询的数据所转换的实体类类型必须实现序列化的接口
            二级缓存失效的情况：
            两次查询之间执行了任意的增删改操作，会使一级缓存二级缓存同时失效
     * */

    @Test
    public void testCache(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = mapper.getEmpById(56);
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = mapper2.getEmpById(56);
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
