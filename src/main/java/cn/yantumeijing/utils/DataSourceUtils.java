package cn.yantumeijing.utils;

import cn.yantumeijing.mybatis.cfg.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rui
 * @create 2019-09-03 16:07
 */
public class DataSourceUtils {

    private DataSource dataSource;

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException("获取连接失败"+e);


        }

    }

}
