package com.ronaksoft.service;

import java.util.List;
import com.ronaksoft.dto.*;

public interface StudentService {

	public List<StudentDto> getStudentListByCourses(String course1, String course2) throws Exception;
}
