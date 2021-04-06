package com.mzr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mzr.dto.StudentDTO;
import com.mzr.service.StudentService;
import com.mzr.service.StudentServiceImpl;
@WebServlet("/std")
public class StudentController extends HttpServlet {
	private StudentService service;
	@Override
	public void init() throws ServletException {
		service = new StudentServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession ses = req.getSession();
		String msg = req.getParameter("msg");
		
		if(msg.equals("getall")) {
			ses.setAttribute("allRec", service.getAllService());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/showAll.jsp");
			rd.include(req, res);
		}
		else if(msg.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/insert.jsp");
			rd.include(req, res);
		}
		else if(msg.equals("i")) {
			StudentDTO dto = new StudentDTO();
			dto.setRoll(Integer.parseInt(req.getParameter("roll")));
			dto.setName(req.getParameter("name"));
			dto.setCourse(req.getParameter("course"));
			dto.setMarks(Double.valueOf(req.getParameter("marks")));
			ses.setAttribute("insertStd", service.insertService(dto));
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/insert.jsp");
			rd.include(req, res);
		}
		else if(msg.equals("up")) {
			StudentDTO dto = service.getStudentByRollService(Integer.parseInt(req.getParameter("r")));		
			ses.setAttribute("getStd", dto);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/update.jsp");
			rd.include(req, res);
		}
		else if(msg.equals("u")) {
			StudentDTO dto = new StudentDTO();
			dto.setRoll(Integer.parseInt(req.getParameter("roll")));
			dto.setName(req.getParameter("name"));
			dto.setCourse(req.getParameter("course"));
			dto.setMarks(Double.valueOf(req.getParameter("marks")));
			ses.setAttribute("updateStd", service.updateService(dto));
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/update.jsp");
			rd.include(req, res);
		}
		else if(msg.equals("del")) {
			ses.setAttribute("deleteStd", service.delete(Integer.parseInt(req.getParameter("r"))));
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/showAll.jsp");
			rd.include(req, res);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
