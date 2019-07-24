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

import com.miniproject.ReportEngine.Model.listKlaster;
import com.miniproject.ReportEngine.Repo.RepoKlas;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/klaster")

@RequestMapping(value="/miniprojectapi/v1")
@Api(tags = "Data Klaster")
public class listKlasterController
{
	@Autowired
	RepoKlas repoKlas;
	
	//postman
//	@GetMapping("getAll")
	
	@GetMapping("/klas")
	@ApiOperation(
			value = "API to retrieve all klaster's data",
			notes = "Return data with JSON format",
			tags = "Get Data API"
			)
	public List<listKlaster> getAll(){
		List<listKlaster>result = new ArrayList<>();
		repoKlas.findAll().forEach(result::add);
		return result;
	}
	
	//postman
//	@PostMapping(value = "save")
	
	@PostMapping("/klas")
	@ApiOperation(
			value = "Add new klaster data",
			notes = "Add new klaster data to database",
			tags = "Data Manipulation API"
			)
	
	public String save(@RequestBody listKlaster listklaster) {
		try {
			repoKlas.save(listklaster);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			e.printStackTrace();
			return "Gagal Tersimpan";
		}
	}
	
	
	//postman
//	@DeleteMapping(value = "/{id}")
	
	@DeleteMapping(value = "/klas/{id}")
	@ApiOperation(
			value = "Delete klaster data",
			notes = "Delete klaster data based on provided ID and remove data",
			tags = "Data Manipulation API"
			)
	
	public HashMap<String, Object> delete(@PathVariable Integer id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		repoKlas.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

	//postman
//	@PutMapping(value = "/{id}")
	
	@ApiOperation(
			value = "Update klaster data",
			notes = "Update klaster data based on provided ID and attached data",
			tags = "Data Manipulation API"
			)
	@PutMapping("/klas/{id}")
	
	public listKlaster update (@RequestBody listKlaster listklaster, @PathVariable Integer id) {			
		listKlaster klasterSelected = repoKlas.findById(id).orElse(null) ;
		if (klasterSelected !=null) {
			klasterSelected.setTitleklaster(listklaster.getTitleklaster());
			klasterSelected.setDataSource(listklaster.getDataSource());
			klasterSelected.setContact(listklaster.getContact());
			klasterSelected.setDateOfFilling(listklaster.getDateOfFilling());
			klasterSelected.setUpdateOfKlaster(listklaster.getUpdateOfKlaster());
			repoKlas.save(klasterSelected);
			return repoKlas.save(klasterSelected);
		} else {
			return null;
		}	
}
	
}
