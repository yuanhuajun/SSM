
import com.mapper.UserMapper;
import com.mysql.cj.protocol.ReadAheadInputStream;
import com.pojo.User;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/9 16:51
 * @Description
 */


public class MyBatisTest {
1
    @Test
    public void testInsert() throws IOException {


        // //获取核心配置文件输入流
        // InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // //获取SqlSessionFactoryBuilder对象
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // //获取SqlSessionFactory对象
        // SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // //获取sql的绘画对象SqlSession，是Mybatis提供的操作数据库的对象，传参true，即可自动提交事务
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper接口中的方法，实现添加用户信息的功能
        int i = mapper.insertUser();
        System.out.println("结果：" + i);
        sqlSession.close();
    }


    @Test
    public void testUpdate() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testDelete() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById();
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }


    @Test
    public void test() {
        int count = 0;
        label:
        for (int i = 2; i <= 100000; i++) {
            for (int j = 2; j <=Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue label;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
