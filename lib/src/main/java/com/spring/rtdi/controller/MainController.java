package com.spring.rtdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.spring.rtdi.dto.EmployeeDTO;
import com.spring.rtdi.service.IEmployeeService;
import com.spring.rtdi.vo.EmployeeVO;

//@Component("controller")
@Controller("controller")
public class MainController {
	
		@Autowired
		private IEmployeeService service;

		// alt+shift+s, o
		public MainController(IEmployeeService service) {
			System.out.println("MainController.1-param constructor");
			this.service = service;
		}
		
		public String   processEmployee(EmployeeVO vo)throws Exception{
			//convert EmployeeVO class object to EmployeDTO class obj
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEname(vo.getEname());
			dto.setDesg(vo.getDesg());
			dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
			//use service
			String result=service.registerEmployee(dto);
			
			return result;
		}

}
