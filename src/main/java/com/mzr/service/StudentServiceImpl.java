package com.mzr.service;

import java.util.ArrayList;
import java.util.List;

import com.mzr.bo.StudentBO;
import com.mzr.dao.StudentDAO;
import com.mzr.dao.StudentDAOImpl;
import com.mzr.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}

	@Override
	public List<StudentDTO> getAllService() {
		List<StudentDTO> listDTO = new ArrayList<>();
		dao.getAllStudent().forEach(bo->{
			StudentDTO dto = new StudentDTO();
			dto.setRoll(bo.getRoll());
			dto.setName(bo.getName());
			dto.setCourse(bo.getCourse());
			dto.setMarks(bo.getMarks());
			listDTO.add(dto);
		});		
		return listDTO;
	}

	@Override
	public String insertService(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		bo.setRoll(dto.getRoll());
		bo.setName(dto.getName());
		bo.setCourse(dto.getCourse());
		bo.setMarks(dto.getMarks());
		return dao.insert(bo)!=0?"Record saved":"Record not saved";
	}

	@Override
	public StudentDTO getStudentByRollService(Integer roll) {
		StudentDTO dto = new StudentDTO();
		StudentBO bo = dao.getStudentByRoll(roll);
		dto.setRoll(bo.getRoll());
		dto.setName(bo.getName());
		dto.setCourse(bo.getCourse());
		dto.setMarks(bo.getMarks());
		return dto;
	}

	@Override
	public String updateService(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		bo.setRoll(dto.getRoll());
		bo.setName(dto.getName());
		bo.setCourse(dto.getCourse());
		bo.setMarks(dto.getMarks());
		return dao.update(bo)!=0?"Record updated":"Record not updated";
	}

	@Override
	public String delete(Integer roll) {
		return dao.delete(roll)!=0?"Record deleted":"Record not deleted";
	}
}
