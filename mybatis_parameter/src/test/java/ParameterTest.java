import com.mapper.UserMapper;
import com.pojo.User;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/10 21:03
 * @Description
 */


public class ParameterTest {

    @Test
    public void testGetUserByUserName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("abc");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("abc", "zxc");
        System.out.println(user);
    }

    @Test
    /**
     * 自定义map集合传参
     */
    public  void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","abc");
        map.put("password","zxc");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test

    /**
     * 若mapper接口方法的参数为实体类类型
     */
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"root","123456",24,"男","11@qq.com");
        mapper.insertUser(user);
        System.out.println(user.getId());
    }

@Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("root", "123456");
        System.out.println(user);

    }

}
