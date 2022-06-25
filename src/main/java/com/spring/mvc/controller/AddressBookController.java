package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.AddNewContact;
import com.spring.mvc.model.UserDetails;
import com.spring.mvc.service.AddNewContactService;
import com.spring.mvc.service.UserService;

@Controller
public class AddressBookController {

	@Autowired
	UserService userService;

	@Autowired
	AddNewContactService addNewContactService;

	@Autowired
	private HttpSession httpSession;

	@RequestMapping("/")
	public String index(Model m) {

		UserDetails user = new UserDetails();
		m.addAttribute("userDetails", user);
		return "Index";
	}

	@RequestMapping("/validation")
	public String validateUser(@ModelAttribute("userDetails") UserDetails userDetails, Model model) {

		httpSession.setAttribute("userName", userDetails.getUserId());
		// User Validation Logic
		System.out.println(userDetails.toString());
		// System.out.println(httpSession.getAttribute("userName"));
		String userName = (String) httpSession.getAttribute("userName");
		model.addAttribute("userName", userName);
		return "welcome";
	}

	@RequestMapping("addNew")
	public String search(Model model) {

		return "AddNew";
	}

	@RequestMapping("/addnewuser")
	public String addnewuser(@ModelAttribute("newuser") AddNewContact addNewContact, Model model) {
		String str = (String) httpSession.getAttribute("userName");
		addNewContact.setUserName(str);
		AddNewContact anc = addNewContactService.addContact(addNewContact);
		System.out.println(addNewContact.toString());
		return "welcome";
	}

	@RequestMapping("myaddress")
	public String myaddress(ModelMap model) {
		// System.out.println(httpSession.getAttribute("userName"));
		String userName = (String) httpSession.getAttribute("userName");
		// AddNewContact anc = new AddNewContact();
		// AddNewContact ltr= addNewContactService.searchAddress(str);
		// System.out.println(name);
		// System.out.println(ltr.toString());
		List<AddNewContact> addressDetails = addNewContactService.getOtherUser(userName);
		model.put("addressDetails", addressDetails);
		addressDetails.stream().forEach(s -> System.out.println("loop" + s));

		List<AddNewContact> otherAddressDetails = addNewContactService.getOtherUser("Other Address Book");

		return "UserAddressBook";
	}

	@RequestMapping("HomePage")
	public String homePage(Model model) {

		return "welcome";
	}

	@RequestMapping("delete-person")
	public String deletePerson(@RequestParam("name") String name, ModelMap model) {

		addNewContactService.deleteContact(name);
		String userName = (String) httpSession.getAttribute("userName");
		List<AddNewContact> addressDetails = addNewContactService.getOtherUser(userName);

		model.put("addressDetails", addressDetails);
		return "UserAddressBook";
	}

	@RequestMapping("otheraddress")
	public String otherAddress(ModelMap model) {
		List<AddNewContact> otherAddressDetails = addNewContactService.getOtherUser("Other Address Book");
		model.put("otheraddressDetails", otherAddressDetails);
		otherAddressDetails.stream().forEach(s -> System.out.println("newLoop" + s));

		return "OtherAddressBook";
	}

	@RequestMapping("uniqueContacts")
	public String uniqueContacts(ModelMap model) {
		List<AddNewContact> otherAddressDetails = addNewContactService.getOtherUser("Other Address Book");

		String userName = (String) httpSession.getAttribute("userName");
		List<AddNewContact> addressDetails = addNewContactService.getOtherUser(userName);
		List<AddNewContact> lnt = new ArrayList<>();

		List<AddNewContact> finalList = new ArrayList<AddNewContact>();
		finalList.addAll(addressDetails);
		finalList.retainAll(otherAddressDetails);
		List<AddNewContact> commonInBothList = finalList;

		model.put("commonInBothList", commonInBothList);
		commonInBothList.stream().forEach(s -> System.out.println("XYZLoop" + s));

		return "UniqueContacts";
	}

}
