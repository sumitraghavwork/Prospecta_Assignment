package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.model.Category;
import com.prospecta.model.Entry;

@RestController
public class ProspectaController {

	private static List<Object> entries = new ArrayList<>();

	private static List<Category> categories = new ArrayList<>();

	@GetMapping("/categories")
	public void getCategories(@RequestParam String category) {

		String uri = "https://api.publicapis.org/categories?category=" + category;
		RestTemplate restTemplate = new RestTemplate();

		Category saved_category = restTemplate.getForObject(uri, Category.class);
		System.out.println(saved_category);

		categories.add(saved_category);

	}
	
	@GetMapping("/entries")
	public void getEntries(@Valid @RequestBody Entry entry) {

		String uri = "https://api.publicapis.org/entries?title="+entry.getTitle()+"&description="+entry.getDescription()+"&auth="+entry.getAuth()+"&https="+entry.isHttps()+"&category="+entry.getCategory()+"&cors="+entry.getCors();
		RestTemplate restTemplate = new RestTemplate();

		Object saved_entries = restTemplate.getForObject(uri, Object.class);
		System.out.println(saved_entries);


	}
}
