import com.mapper.SelectMapper;
import com.mapper.SpecialMapper;
import com.mapper.UserMapper;
import com.pojo.User;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/11 7:52
 * @Description
 */


public class SelectMapperTest {

    @Test
    public  void  testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        //{password=123, id=1, age=20, email=1121455582@qq.com, username=yhj}
        //如果某个字段值为null，是不会放到map中的
        System.out.println(map);
    }


    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        //{1={password=123, id=1, age=20, email=1121455582@qq.com, username=yhj}, 2={password=123, id=2, age=20, email=1121455582@qq.com, username=yhj}, 3={password=zxc, id=3, age=20, email=1121455582@qq.com, username=abc}, 4={password=123, id=4, age=20, email=1121455582@qq.com, username=yhj}, 6={password=123, id=6, age=20, email=1121455582@qq.com, username=yhj}, 7={password=123, id=7, age=20, email=1121455582@qq.com, username=yhj}, 8={password=123, id=8, age=20, email=1121455582@qq.com, username=yhj}, 9={password=123, id=9, age=20, email=1121455582@qq.com, username=yhj}, 10={password=123, gender=男, id=10, age=20, email=1121455582@qq.com, username=yhj}, 11={password=123456, gender=男, id=11, age=24, email=11@qq.com, username=root}}
        System.out.println(allUserToMap);
    }


    @Test
    public void  testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        List<User> user = mapper.getUserByLike("a");
        System.out.println(user);
    }


    @Test
    public void  testDelMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        mapper.deleteMoreUser("5,6");
    }


    @Test
    public void  testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        List<User> t_user = mapper.getUserList("t_user");
        System.out.println(t_user);
    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        User user = new User(null,"xiaoming","123456",23,"男","1212@qq.com");
        mapper.insertUser(user);
        System.out.println(user);

    }
}
