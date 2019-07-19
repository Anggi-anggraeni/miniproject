package com.miniproject.ReportEngine.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.miniproject.ReportEngine.Model.listCustomer;
import com.miniproject.ReportEngine.Repo.RepoCust;
import com.miniproject.ReportEngine.Service.CustService;

@RestController
@RequestMapping("/list")
public class listCustomerController 
{
	@Autowired
	RepoCust repoCust;
	
	@Autowired
	CustService custService;

	@GetMapping("getAll")
	public List<listCustomer> getAll(){
		List<listCustomer> result = new ArrayList<>();
		repoCust.findAll().forEach(result::add);
		return result;
	}
	
	@GetMapping(value="/report")
	public String generateReport() {
		return custService.generateReport();
	}
	
	@PostMapping("save")
	public listCustomer save(@RequestBody listCustomer customer) {
		return repoCust.save(customer);
	}
	
	@DeleteMapping("delete/{id}")	
	public String delete(@PathVariable int id) {
	
		return "berhasil dihapus";
	}

}
