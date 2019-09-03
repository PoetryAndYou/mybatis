package cn.yantumeijing.mybatis.cfg;

/**
 * @author rui
 * @create 2019-09-03 14:49
 */
public class Mapper {
    private String queryString;//SQL语句
    private String resultType;//

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
