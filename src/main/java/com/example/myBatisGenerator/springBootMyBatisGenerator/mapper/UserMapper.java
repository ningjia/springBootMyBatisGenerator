package com.example.myBatisGenerator.springBootMyBatisGenerator.mapper;

import com.example.myBatisGenerator.springBootMyBatisGenerator.model.User;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, username, ",
        "birthday, sex, address)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{sex,jdbcType=CHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @Select({
        "select",
        "id, username, birthday, sex, address",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="sex", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, username, birthday, sex, address",
        "from user"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="sex", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "sex = #{sex,jdbcType=CHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}