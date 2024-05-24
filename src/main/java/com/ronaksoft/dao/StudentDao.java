package com.ronaksoft.dao;
import java.util.List;
import com.ronaksoft.entity.StudentEntity;

public interface StudentDao {

	public List<StudentEntity> getStudentsByCouse(String course1, String course2) throws Exception;
}
