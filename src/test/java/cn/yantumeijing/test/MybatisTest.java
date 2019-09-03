package cn.yantumeijing.test;

import cn.yantumeijing.dao.UserDao;
import cn.yantumeijing.dao.impl.UserDaoImpl;
import cn.yantumeijing.domain.User;
import cn.yantumeijing.mybatis.SqlSession.SqlSession;
import cn.yantumeijing.mybatis.SqlSession.SqlSessionFactory;
import cn.yantumeijing.mybatis.SqlSession.SqlSessionFactoryBuilder;
import cn.yantumeijing.mybatis.io.Resources;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author rui
 * @create 2019-09-02 21:19
 */
public class MybatisTest {
    /**
     * 入门案例
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //使用SQLSession创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users
        ) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        in.close();
    }
}
