package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ravi.entity.UserAccount;
import com.ravi.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;

	// ========== Loading index.html =============

	@GetMapping("/")
	public String loadIndexForm(Model model) {
		model.addAttribute("user", new UserAccount());
		model.addAttribute("info", "Register Here");
		model.addAttribute("lable", "Register");
		return "index";
	}

	// ========== Handling Submit button ==========

	@PostMapping("/submit")
	public String handleSubmitButton(@ModelAttribute("user") UserAccount userAccount, Model model) {
		String status = userAccountService.saveOrUpdateUserAccount(userAccount);
		if (status == "saved") {
			// To handle double posting problems.
			model.addAttribute("user", new UserAccount());
			model.addAttribute("msg", "Form Submited Successfully. !!");
			model.addAttribute("lable", "Register");
			return "index";
		} else {
			model.addAttribute("user", new UserAccount());
			model.addAttribute("msg", "Form Updated Successfully. !!");
			model.addAttribute("lable", "Update");
			return "index";
		}
	}

	// ========== Handling view user functionality ==========

	@GetMapping("/view")
	public String viewUsersAccount(Model model) {
		List<UserAccount> users = userAccountService.getAllUserAccount();
		if (!(users.isEmpty())) {
			model.addAttribute("users", users);
			return "view_users";
		} else {
			model.addAttribute("msg", "Record Not found. !!");
			return "view_users";
		}

	}

	// ========== Handling update functionality ============

	@GetMapping("/update/{id}")
	public String editUserAccount(@PathVariable("id") Integer id, Model model) {
		UserAccount userAccount = userAccountService.getUserAccount(id);
		model.addAttribute("user", userAccount);
		model.addAttribute("info", "Update Here");
		model.addAttribute("lable", "Update");
		return "index";
	}

	// ========== Handling delete functionality ===========

	@GetMapping("/delete/{id}")
	public String deleteUserAccount(@PathVariable("id") Integer id, Model model) {
		userAccountService.deleteUserAccount(id);
		model.addAttribute("msg", "User Record Deleated.!!");
		return "forward:/view";
	}

	// ========== Handling user account status functionality =========

	@GetMapping("/active/{id}")
	public String changeUserAccountStatus(@PathVariable("id") Integer id, Model model) {
		String status = userAccountService.getUserAccountStatus(id);
		if ("Y".equals(status)) {
			userAccountService.updateUserAccountStatus(id, "N");
			model.addAttribute("msg", "User Account De-Activated. !!");
		} else {
			userAccountService.updateUserAccountStatus(id, "Y");
			model.addAttribute("msg", "User Account Activated. !!");
		}
		return "forward:/view";

	}
}
