package cn.yantumeijing.mybatis.SqlSession;

/**
 * @author rui
 * @create 2019-09-03 14:16
 */
public interface SqlSession {
    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
