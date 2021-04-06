package com.mzr.service;

import java.util.List;

import com.mzr.dto.StudentDTO;

public interface StudentService {
	
	public List<StudentDTO> getAllService();
	public String insertService(StudentDTO dto);
	public StudentDTO getStudentByRollService(Integer roll);
	public String updateService(StudentDTO dto);
	public String delete(Integer roll);

}
