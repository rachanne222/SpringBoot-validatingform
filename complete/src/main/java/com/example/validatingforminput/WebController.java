package com.example.validatingforminput;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {
	//This controller has a GET method and a POST method. Both methods are mapped to /

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}
    //The showForm method returns the form template
	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	
	//The checkPersonInfo method accepts two arguments:
		//1. A personForm object marked with @Valid to gather the attributes filled out in the form
	    //2. A bindingResult object so that you can test for and retrieve validation errors.
//	You can retrieve all the attributes from the form, which is bound to the PersonForm object. In the code, you test for errors. If you encounter an error, you can send the user back to the original form template. 
//	In that situation, all the error attributes are displayed.
//	If all of the person’s attribute are valid,
//	it redirects the browser to the final results template.
	
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/results";
	}
}
