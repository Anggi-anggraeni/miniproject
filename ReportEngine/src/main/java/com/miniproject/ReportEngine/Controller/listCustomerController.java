package com.miniproject.ReportEngine.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.miniproject.ReportEngine.Model.listCustomer;
import com.miniproject.ReportEngine.Repo.RepoCust;
import com.miniproject.ReportEngine.Service.CustService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

//@RequestMapping("/list")

//swagger
@RequestMapping(value="/miniprojectapi/v1")
@Api(tags = "Data Profile")
public class listCustomerController 
{
	
	@Autowired
	private CustService custService;
	
	@Autowired
	RepoCust repoCust;

	// postman
//	@GetMapping("getAll")
	
	@GetMapping("/cust")
	@ApiOperation(
			value = "API to retrieve all customer's data",
			notes = "Return data with JSON format",
			tags = "Get Data API"
			)
	public List<listCustomer> getAll(){
		List<listCustomer> result = new ArrayList<>();
		repoCust.findAll().forEach(result::add);
		return result;
	}
	
	@GetMapping(value="/report")
	public String generateReport() {
		return custService.generateReport();
	}
	
	//postman
//	@PostMapping(value = "save")
	
	@PostMapping("/cust")
	@ApiOperation(
			value = "Add new customer data",
			notes = "Add new customer data to database",
			tags = "Data Manipulation API"
			)
	
	public String save(@RequestBody listCustomer listcustomer) {
		try {
			repoCust.save(listcustomer);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			e.printStackTrace();
			return "Gagal Tersimpan";
		}
	}
	
	//postman
//	@DeleteMapping(value = "/{id}")
	
	@DeleteMapping(value = "/cust/{id}")
	@ApiOperation(
			value = "Delete customer data",
			notes = "Delete customer data based on provided ID and remove data",
			tags = "Data Manipulation API"
			)
	public HashMap<String, Object> delete(@PathVariable Integer id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		repoCust.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

	//postman
//	@PutMapping(value = "/{id}")
	
	@ApiOperation(
			value = "Update customer data",
			notes = "Update customer data based on provided ID and attached data",
			tags = "Data Manipulation API"
			)
	@PutMapping("/cust/{id}")
	public listCustomer update (@RequestBody listCustomer listcustomer, @PathVariable Integer id) {			
		listCustomer customerSelected = repoCust.findById(id).orElse(null) ;
		if (customerSelected !=null) {
			customerSelected.setName(listcustomer.getName());
			customerSelected.setAddress(listcustomer.getAddress());
			customerSelected.setPhone(listcustomer.getPhone());
			customerSelected.setGender(listcustomer.getGender());
			customerSelected.setEmail(listcustomer.getEmail());
			customerSelected.setDateOfRegister(listcustomer.getDateOfRegister());
			customerSelected.setActiveAccount(listcustomer.getActiveAccount());
			repoCust.save(customerSelected);
			return repoCust.save(customerSelected);
		} else {
			return null;
		}	
}
}
