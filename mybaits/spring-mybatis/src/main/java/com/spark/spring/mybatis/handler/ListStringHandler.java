package com.spark.spring.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Spark.tang
 * @create: 2020-05-09 11:40
 **/
@MappedTypes(value = {List.class})
public class ListStringHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> list, JdbcType jdbcType) throws SQLException {

        if (CollectionUtils.isEmpty(list)) return;
        StringBuffer sb = new StringBuffer();
        list.forEach(l -> sb.append(l).append(","));
        char[] chars = sb.toString().toCharArray();
        chars[chars.length - 1] = ' ';
        ps.setString(i, new String(chars).trim());
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, String s) throws SQLException {

        String str = resultSet.getString(s.trim());

        if (StringUtils.isEmpty(str)) return null;

        return Arrays.stream(str.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
