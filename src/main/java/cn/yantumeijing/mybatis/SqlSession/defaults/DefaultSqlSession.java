package cn.yantumeijing.mybatis.SqlSession.defaults;

import cn.yantumeijing.mybatis.SqlSession.SqlSession;
import cn.yantumeijing.mybatis.SqlSession.proxy.MapperProxy;
import cn.yantumeijing.mybatis.cfg.Configuration;
import cn.yantumeijing.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 *
 * @author rui
 * @create 2019-09-03 15:34
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtils.getConnection(cfg);
    }

    /**
     * 创建代理对象
     *
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));

    }

    /**
     * 用于释放资源
     */
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
