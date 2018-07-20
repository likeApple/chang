package com.warrior.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.warrior.entity.Student;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
public interface IStudentService extends IService<Student> {
	List<Student> selectStudentByStuName(String student);

	/**
	 * @param wrapper
	 * @return
	 */
	 List<Student> selectListByWrapper(Wrapper wrapper);
}
