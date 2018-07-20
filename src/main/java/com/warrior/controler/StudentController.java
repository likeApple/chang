package com.warrior.controler;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.warrior.entity.Student;
import com.warrior.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Controller
@RequestMapping("/w")
public class StudentController {
    private final static Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    IStudentService iStudentService;

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello() {
        //insert
        Student student = new Student()
                .setStuName("zhangsan")
                .setStuNumber("54")
                .setAge(23);

        boolean res = student.insert();
        Student arr = student.selectById(student.getId());
        return arr;
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public List<Student> hello2() {
        logger.info("123");
        return iStudentService.selectStudentByStuName("zhangsan");
    }
    @RequestMapping("hello3")
    @ResponseBody
    public List<Student> hello3() {
        logger.info("123");
        EntityWrapper<Student> wrapper = new EntityWrapper<>();

        // 'last_name' 与 'age' 对应数据库中的字段
        wrapper.like("stu_name", "zhangsan");
        return iStudentService.selectListByWrapper(wrapper);
    }
}
