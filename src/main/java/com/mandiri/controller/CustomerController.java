package com.mandiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mandiri.model.Customer;
import com.mandiri.model.CustomerCampaign;
import com.mandiri.model.CustomerProduct;
import com.mandiri.model.Product;
import com.mandiri.model.Reason;
import com.mandiri.model.Status;
import com.mandiri.model.User;
import com.mandiri.repository.CustomerCampaignRepository;
import com.mandiri.repository.CustomerProductRepository;
import com.mandiri.repository.CustomerRepository;
import com.mandiri.repository.ProductRepository;
import com.mandiri.repository.ReasonRepository;
import com.mandiri.repository.StatusRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository cRepo; 
	
	@Autowired
	private CustomerProductRepository cpRepo;
	
	@Autowired
	private CustomerCampaignRepository campaignRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ReasonRepository reasonRepo;
	
	@Autowired
	private StatusRepository statusRepo;
	
	Long cif = 1111L;
	
	@GetMapping(value={"/customer"})
	public String customerSingleView(ModelMap model){
		//Hardcode user's cif number
		//Long cif = 1111L;
		//customer information
		System.out.println(System.getProperty("catalina.base"));
		
		Customer cust = new Customer();
		cust = cRepo.findOne(cif);
		System.out.println(cust.toString());
		model.addAttribute("customer", cust);
		
		//Produk
		List<CustomerProduct> listOwned = cpRepo.findbyCif(cif);
		model.addAttribute("ownedProduct", listOwned);
		
		//Customer Campaign
		List<CustomerCampaign> listCampaign = campaignRepo.findbyCif(cif);
		List<CustomerCampaign> campaign0 = listCampaign.stream().filter(p->p.getStatus().getId() == 0).collect(Collectors.toList());
		List<CustomerCampaign> campaign1 = listCampaign.stream().filter(p->p.getStatus().getId() == 1).collect(Collectors.toList());
		
		model.addAttribute("offered", campaign1);
		model.addAttribute("newproduct", campaign0);
		
		//Select list product
		List<Product> listProduct = productRepo.findAll();
		model.addAttribute("listProduct", listProduct);
		
		//Select list product
		List<Reason> listReason = reasonRepo.findAll();
		model.addAttribute("listReason", listReason);
		
		//Button group status
		//List<Status> listStatus = statusRepo.findAll();
		//model.addAttribute("listStatus", listStatus);
		
		//Blank Customer Campaign for form purpose
		CustomerCampaign blankCampaign = new CustomerCampaign();
		model.addAttribute("blankCampaign", blankCampaign);
		
		return "CustomerView";
	}
	
	@PostMapping(value={"/campaignSave"})
//	public String customerSingleView(@ModelAttribute("blankCampaign") CustomerCampaign blankCampaign){
//		System.out.println(blankCampaign.toString());
	public @ResponseBody String campaignSave(@ModelAttribute(value="blankCampaign") CustomerCampaign blankCampaign, HttpEntity<String> httpEntity) {
		blankCampaign.setCreatedon(new Timestamp(System.currentTimeMillis()));
		User createdby = new User();
		createdby.setUsername("bayu");
		blankCampaign.setUser1(createdby);;
		
		//SET CIF by session
		blankCampaign.setCustomer(new Customer(cif));
		
	    String json = httpEntity.getBody();
		System.out.println(json);
		//System.out.println(blankCampaign.getEmail());
//		if (result.hasErrors()) {
//	        System.out.println(result.getGlobalError() + "" + result.getFieldError());
//	    }
		System.out.println(blankCampaign.toString());
		System.out.println(blankCampaign.getProduct().getName());
		//System.out.println(blankCampaign.getStatus().getName());
		campaignRepo.save(blankCampaign);
		
		return "test";
	}
	
	
	//Testing post from ajax
	@GetMapping(value={"/Test"})
	public String mytest(ModelMap model){
		Reason reason = new Reason();
		model.addAttribute("reason", reason);
		return "Test";
	}

	@PostMapping(value={"/Test"})
	@ResponseBody
	public String mytestPost(@ModelAttribute(value="reason") Reason reason, HttpEntity<String> httpEntity){
		String json = httpEntity.getBody();
		System.out.println(json.toString());
		System.out.println(reason.toString());
		return "Test";
	}
	
	//TEST1
	@GetMapping(value={"/myNewHello"})
	public ModelAndView myNewHello(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("myNewHello");
		return modelAndView;
	}
	
	//TEST2
	@GetMapping(value={"/MyHelloWorld"})
	public String helloWorldvariable(ModelMap model){
		model.addAttribute("myFirstVariable", "Hehe");
		return "MyHelloWorld";
	}
}
