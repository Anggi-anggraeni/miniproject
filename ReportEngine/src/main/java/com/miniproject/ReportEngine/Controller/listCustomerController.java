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

@RestController
@RequestMapping("/list")
public class listCustomerController 
{
	
	@Autowired
	private CustService custService;
	
	@Autowired
	RepoCust repoCust;

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
	
	@PostMapping(value = "save")
	public String save(@RequestBody listCustomer listcustomer) {
		try {
			repoCust.save(listcustomer);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			e.printStackTrace();
			return "Gagal Tersimpan";
		}
	}
	
	@DeleteMapping(value = "delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		repoCust.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

	@PutMapping(value = "update/{id}")
	public listCustomer update (@RequestBody listCustomer listcustomer, @PathVariable Long id) {			
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
