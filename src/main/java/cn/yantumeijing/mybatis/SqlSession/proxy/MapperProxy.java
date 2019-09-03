package cn.yantumeijing.mybatis.SqlSession.proxy;

import cn.yantumeijing.mybatis.cfg.Mapper;
import cn.yantumeijing.utils.Executor;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author rui
 * @create 2019-09-03 15:42
 */
public class MapperProxy implements InvocationHandler {
    /*
    key:全限定类名+方法名
     */
    private Map<String, Mapper> mappers;

    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 增强代理对象，这里增强其实是调用selectList方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类的名成
        String className = method.getDeclaringClass().getName();
        //组合
        String key = className + "." + methodName;
        System.out.println("key:"+key);
        //获取mappers对象中的Mapper对象
        Mapper mapper = mappers.get(key);
        //判断是否有mapper;
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类查询所有
        return new Executor().selectList(mapper, conn);
    }
}
