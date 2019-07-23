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

@RestController
@RequestMapping("/klaster")
public class listKlasterController
{
	@Autowired
	RepoKlas repoKlas;
	
	@GetMapping("getAll")
	public List<listKlaster> getAll(){
		List<listKlaster>result = new ArrayList<>();
		repoKlas.findAll().forEach(result::add);
		return result;
	}
	
	@PostMapping(value = "save")
	public String save(@RequestBody listKlaster listklaster) {
		try {
			repoKlas.save(listklaster);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			e.printStackTrace();
			return "Gagal Tersimpan";
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public HashMap<String, Object> delete(@PathVariable Integer id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		repoKlas.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

	@PutMapping(value = "/{id}")
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
