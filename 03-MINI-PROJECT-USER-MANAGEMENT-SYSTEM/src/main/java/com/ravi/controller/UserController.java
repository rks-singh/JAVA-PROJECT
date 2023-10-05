package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.entitymodel.UserLogin;
import com.ravi.entitymodel.UserSignUp;
import com.ravi.service.CountryService;
import com.ravi.service.ForgetPasswordService;
import com.ravi.service.StateService;
import com.ravi.service.UnlockAccountService;
import com.ravi.service.UserSignInService;
import com.ravi.service.UserSignUpService;

@Controller
public class UserController {

	@Autowired
	private UserSignInService userSignInService;

	@Autowired
	private UserSignUpService userSignUpService;

	@Autowired
	private UnlockAccountService unlockAccountService;

	@Autowired
	private ForgetPasswordService forgetPasswordService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@GetMapping("/")
	public String loadSignInFrom(Model model) {
		model.addAttribute("login", new UserLogin());
		return "login";
	}

	public String handleSignInFrom(UserLogin user, Model model) {
		return null;
	}

	@GetMapping("/signup")
	public String loadSignUpForm(Model model) {

		List<Object[]> allCountries = countryService.getAllCountries();

		model.addAttribute("signUp", new UserSignUp());
		model.addAttribute("country", allCountries);
		return "signup";
	}

	@PostMapping("/submit")
	public String handleSignUpFrom(UserSignUp signUp, Model model) {
		System.out.println(signUp);
		return "login";
	}

	@GetMapping("/getStates")
	@ResponseBody
	public String getStates(@RequestParam("countryId") Integer countryId) {
		String json = null;
		List<Object[]> list = countryService.getStatesByCountry(countryId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	@GetMapping("/getCities")
	@ResponseBody
	public String getCities(@RequestParam("stateId") Integer stateId) {
		String json = null;
		List<Object[]> list = stateService.getCitiesByState(stateId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("/validateemail")
	@ResponseBody
	public String validateEmail(@RequestParam("email")String email) {
		return userSignUpService.findByEmail(email);	
	}
	
	
	@GetMapping("/unlock")
	public String loadUnlockAccountForm(Model model) {
		model.addAttribute("login", new UserLogin());
		return "unlockaccount";
	}

	public String handleUnlockAccountFrom(UserLogin user, Model model) {
		return null;
	}

	@GetMapping("/forgotpassword")
	public String loadForgetPasswordForm(Model model) {
		model.addAttribute("login", new UserLogin());
		return "forgotpassword";
	}

	public String handleForgetPasswordFrom(UserLogin user, Model model) {
		return null;
	}

	@GetMapping("/dashboard")
	public String loadDashboardPage(Model model) {
		return "dashboard";
	}

}
