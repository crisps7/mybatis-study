import com.monet.dao.UserMapper;
import com.monet.pojo.User;
import com.monet.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();
    }


    //一级缓存默认开启
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("======================");
        //手动清理缓存
        sqlSession.clearCache();
        //mapper.updateUser(new User(2,"xiaoA","123456"));
        System.out.println("======================");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        sqlSession.close();
    }
}
