package com.ronaksoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.ronaksoft.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao {

	private DataSource datasource;
	private final String GET_STUDENT_BY_COURSES = "select id, name, course, fee, batch from student where course IN (?, ?) ";

	public StudentDaoImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public List<StudentEntity> getStudentsByCouse(String course1, String course2) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement statement = null;
		List<StudentEntity> studentlist = null;
		ResultSet rs = null;

		try {

			connection = datasource.getConnection();
			statement = connection.prepareStatement(GET_STUDENT_BY_COURSES);
			statement.setString(1, course1);
			statement.setString(2, course2);
			rs = statement.executeQuery();
			studentlist = new ArrayList<StudentEntity>();
			while (rs.next()) {

				StudentEntity entity = new StudentEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setCourse(rs.getString(3));
				entity.setFee(rs.getFloat(4));
				entity.setBatch(rs.getString(5));
				
				studentlist.add(entity);
			}

			return studentlist;
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			// Try catch for closing resources first try-catch we used for close our
			// resultSet object

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				throw se;
			}

			// This try-catch block is used for closing prepare statement object.
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException se) {
				throw se;
			}

			// This try-catch block is used for closing connection object.
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				throw se;
			}
		}
	}
}