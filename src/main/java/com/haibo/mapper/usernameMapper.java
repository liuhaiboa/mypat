package com.haibo.mapper;

import com.haibo.model.username;
import com.haibo.model.usernameExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface usernameMapper {
    @SelectProvider(type=usernameSqlProvider.class, method="countByExample")
    int countByExample(usernameExample example);

    @DeleteProvider(type=usernameSqlProvider.class, method="deleteByExample")
    int deleteByExample(usernameExample example);

    @Delete({
        "delete from account",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String username);

    @Insert({
        "insert into account (username, password, ",
        "email, xm, address)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{xm,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(username record);

    @InsertProvider(type=usernameSqlProvider.class, method="insertSelective")
    int insertSelective(username record);

    @SelectProvider(type=usernameSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="xm", property="xm", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<username> selectByExample(usernameExample example);

    @Select({
        "select",
        "username, password, email, xm, address",
        "from account",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="xm", property="xm", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    username selectByPrimaryKey(String username);

    @UpdateProvider(type=usernameSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") username record, @Param("example") usernameExample example);

    @UpdateProvider(type=usernameSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") username record, @Param("example") usernameExample example);

    @UpdateProvider(type=usernameSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(username record);

    @Update({
        "update account",
        "set password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "xm = #{xm,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(username record);
}