package com.mandiri.controller;

import java.sql.Timestamp;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mandiri.model.Customer;
import com.mandiri.model.User;
import com.mandiri.model.UserActivity;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.service.CustomerService;
import com.mandiri.service.DashboardService;
import com.mandiri.service.UserService;

@Controller
public class HasilSearchController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	SessionController sessionController;
	
	@RequestMapping(value="/customer-edit-all/{cif}", method=RequestMethod.GET)
	public String customerEditAll(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		Customer customer = customerService.findCustomerByCif(Long.valueOf(cif));
		
		UserActivity ua = new UserActivity();
		ua.setAction("Melihat detail customer profile data dengan nama customer "+customer.getName());
		ua.setUser(user);
		ua.setCustomer(customer);
		ua.setCreatedon(new Timestamp(System.currentTimeMillis()));
		dashboardRepository.save(ua);
		
		return "redirect:/dashboard";
	}

}
