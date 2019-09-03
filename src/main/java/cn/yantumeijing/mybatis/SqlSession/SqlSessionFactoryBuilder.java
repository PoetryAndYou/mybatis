package cn.yantumeijing.mybatis.SqlSession;

import cn.yantumeijing.mybatis.SqlSession.defaults.DefaultSqlSessionFactory;
import cn.yantumeijing.mybatis.cfg.Configuration;
import cn.yantumeijing.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 创建SqlSessionFactoryBuilder对象
 * @author rui
 * @create 2019-09-03 14:11
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建SqlSessionFactoryBuilder工厂
     * @param in
     * @return
     */
    public  SqlSessionFactory build(InputStream in){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
