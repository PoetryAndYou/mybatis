package cn.yantumeijing.mybatis.SqlSession.defaults;

import cn.yantumeijing.mybatis.SqlSession.SqlSession;
import cn.yantumeijing.mybatis.SqlSession.SqlSessionFactory;
import cn.yantumeijing.mybatis.cfg.Configuration;

/**
 * @author rui
 * @create 2019-09-03 15:28
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
