package com.warrior.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.warrior.entity.Student;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from tb_student where stu_name=#{stuName}")
    List<Student> selectStudentByStuName(@Param("stuName")String stuName);
    @Select("select * from tb_student  ${ew.sqlSegment}")
    List<Student> selectListByWrapper(@Param("ew") Wrapper<Student> wrapper);

}