package com.mzr.dao;

import java.util.List;

import com.mzr.bo.StudentBO;

public interface StudentDAO {
	
	public List<StudentBO> getAllStudent();
	public int insert(StudentBO bo);
	public StudentBO getStudentByRoll(Integer roll);
	public int update(StudentBO bo);
	public int delete(Integer roll);

}
