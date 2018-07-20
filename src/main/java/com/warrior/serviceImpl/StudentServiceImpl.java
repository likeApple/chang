package com.warrior.serviceImpl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.warrior.entity.Student;
import com.warrior.mapper.StudentMapper;
import com.warrior.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
@Autowired
StudentMapper studentMapper;

    @Override
    public List<Student> selectStudentByStuName(String student) {
        return this.baseMapper.selectStudentByStuName(student);
    }

    @Override
    public List<Student> selectListByWrapper(Wrapper wrapper) {
        return studentMapper.selectListByWrapper(wrapper);
    }
}
