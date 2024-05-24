package com.ronaksoft.controller;

import java.util.*;

import org.springframework.beans.BeanUtils;

import com.ronaksoft.dto.StudentDto;
import com.ronaksoft.service.StudentService;
import com.ronaksoft.vo.*;

public class MainController {

	private StudentService service;

	public MainController(StudentService service) {
		this.service = service;
	}

	public List<StudentVo> getStudentRecord(String course1, String course2) throws Exception {
			//get dto list
			List<StudentDto> studentListByCourses = service.getStudentListByCourses(course1, course2);
			
			//covert the dto list into vo list....
			List<StudentVo>studentVoList = new ArrayList<StudentVo>();
			
			for(StudentDto entity : studentListByCourses) {
				
				StudentVo vo = new StudentVo();
				BeanUtils.copyProperties(entity, vo);
				vo.setId(String.valueOf(entity.getId()));			
				vo.setFee(String.valueOf(entity.getFee()));
				studentVoList.add(vo);
			}
			return studentVoList;
	}
}
