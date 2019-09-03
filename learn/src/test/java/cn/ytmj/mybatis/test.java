package cn.ytmj.mybatis;


import cn.ytmj.mybatis.dao.UserDao;
import cn.ytmj.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author rui
 * @create 2019-09-03 19:48
 */
public class test {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //获取配置文件

        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        sqlSession = build.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }

    @After
    public void destory() {
        sqlSession.close();
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FindAll() {
        List<User> users = userDao.findAll();
        for (User user : users
        ) {
            System.out.println(user);
        }

    }
}
