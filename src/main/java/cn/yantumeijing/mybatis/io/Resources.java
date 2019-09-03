package cn.yantumeijing.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 * @author rui
 * @create 2019-09-03 14:08
 */
public class Resources {
    public static InputStream getResourceAsStream(String filename){
        return Resources.class.getClassLoader().getResourceAsStream(filename);
    }
}
