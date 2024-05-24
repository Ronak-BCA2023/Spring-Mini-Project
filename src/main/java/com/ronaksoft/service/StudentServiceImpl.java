package com.ronaksoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ronaksoft.dao.StudentDao;
import com.ronaksoft.dto.StudentDto;
import com.ronaksoft.entity.StudentEntity;

public class StudentServiceImpl implements StudentService {
	
	public StudentDao dao;
	
	public StudentServiceImpl(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public List<StudentDto> getStudentListByCourses(String course1, String course2) throws Exception {
		List<StudentEntity> studentEntityList = dao.getStudentsByCouse(course1, course2);
		
		//convert the studentEntity list to studentdto list.
		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
		
		//we use one inbuild method copyProperties of BeanUtils Class.
		for(StudentEntity entity : studentEntityList) {
			
			StudentDto dto = new StudentDto();
			//copying the properties of  a entity to a dto.....
			BeanUtils.copyProperties(entity, dto);
			studentDtoList.add(dto);
		}
		return studentDtoList;
	}
}
