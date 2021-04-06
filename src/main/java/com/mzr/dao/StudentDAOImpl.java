package com.mzr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mzr.bo.StudentBO;
import com.mzr.connection.Connect;

public class StudentDAOImpl implements StudentDAO {
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static final String GET_ALL_STUDENT = "SELECT ROLL,NAME,COURSE,MARKS FROM STUDENT";
	private static final String INSERT_STUDENT = "INSERT INTO STUDENT(ROLL,NAME,COURSE,MARKS) VALUES(?,?,?,?)";
	private static final String GET_STUDENT_BY_ROLL = "SELECT ROLL,NAME,COURSE,MARKS FROM STUDENT WHERE ROLL=?";
	private static final String UPDATE_STUDENT_BY_ROLL = "UPDATE STUDENT SET NAME=?,COURSE=?,MARKS=? WHERE ROLL=?";
	private static final String DELETE_STUDENT_BY_ROLL = "DELETE FROM STUDENT WHERE ROLL=?";
	@Override
	public List<StudentBO> getAllStudent() {
		List<StudentBO> listBO = new ArrayList<>();
		try {
			ps = Connect.getCon().prepareStatement(GET_ALL_STUDENT);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				StudentBO bo = new StudentBO();
				bo.setRoll(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setCourse(rs.getString(3));
				bo.setMarks(rs.getDouble(4));
				listBO.add(bo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBO;
	}

	@Override
	public int insert(StudentBO bo) {
		int result = 0;
		try {
			ps = Connect.getCon().prepareStatement(INSERT_STUDENT);
			ps.setInt(1, bo.getRoll());
			ps.setString(2, bo.getName());
			ps.setString(3, bo.getCourse());
			ps.setDouble(4, bo.getMarks());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public StudentBO getStudentByRoll(Integer roll) {
		StudentBO bo = new StudentBO();
		try {
			ps = Connect.getCon().prepareStatement(GET_STUDENT_BY_ROLL);
			ps.setInt(1, roll);
			rs = ps.executeQuery();
			if(rs.next()) {
				bo.setRoll(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setCourse(rs.getString(3));
				bo.setMarks(rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	@Override
	public int update(StudentBO bo) {
		int result = 0;
		try {
			ps = Connect.getCon().prepareStatement(UPDATE_STUDENT_BY_ROLL);
			ps.setString(1, bo.getName());
			ps.setString(2, bo.getCourse());
			ps.setDouble(3, bo.getMarks());
			ps.setInt(4, bo.getRoll());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Integer roll) {
		int result = 0;
		try {
			ps = Connect.getCon().prepareStatement(DELETE_STUDENT_BY_ROLL);
			ps.setInt(1, roll);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
