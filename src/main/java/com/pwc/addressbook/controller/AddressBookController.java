package com.pwc.addressbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.pwc.addressbook.exception.ContactAlreadyExistsException;
import com.pwc.addressbook.exception.ErrorResponse;
import com.pwc.addressbook.model.AddressBookEntity;
import com.pwc.addressbook.model.UserDetails;
import com.pwc.addressbook.service.AddressBookServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddressBookController {

	private static final Logger log = LoggerFactory.getLogger(AddressBookController.class);

	@Autowired
	AddressBookServiceImpl addressBookServiceImpl;

	@Autowired
	private HttpSession httpSession;

	// ContactAlreadyExistsException Exception Handler
	@ExceptionHandler(value = ContactAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ModelAndView handleContactAlreadyExistsException(ContactAlreadyExistsException ex) {
		new ErrorResponse(ex.getMessage());

		ModelAndView mav = new ModelAndView("addnewcontacts");
		mav.addObject("message", ex.getLocalizedMessage());

		return mav;
	}

	@GetMapping("/")
	public String index(Model m) {
		UserDetails user = new UserDetails();
		log.info("Application Entry point!!");
		m.addAttribute("userDetails", user);
		return "index";
	}

	@GetMapping("/validation")
	public String validateUser(@ModelAttribute("userDetails") UserDetails userDetails, Model model) {
		httpSession.setAttribute("userName", userDetails.getUserId());
		log.info(userDetails.toString());
		String userName = (String) httpSession.getAttribute("userName");
		model.addAttribute("userName", userName);
		return "welcome";
	}

	@GetMapping("/addNewContacts")
	public String addNewContacts(Model model) {

		log.info("Add New Contacts page");
		return "addnewcontacts";
	}

	@PostMapping("/addNewUser")
	public String addNewUser(@ModelAttribute("newuser") AddressBookEntity addressBookEntity, Model model) {
		String str = (String) httpSession.getAttribute("userName");
		addressBookEntity.setUserName(str);
		String addContact = addressBookServiceImpl.addContact(addressBookEntity);
		log.info(addContact);
		return "welcome";
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam("name") String name, ModelMap model) {
		addressBookServiceImpl.deleteContact(name);
		String userName = (String) httpSession.getAttribute("userName");
		List<AddressBookEntity> addressDetails = addressBookServiceImpl.getOtherUser(userName);
		model.put("addressDetails", addressDetails);
		return "useraddressbook";
	}

	@RequestMapping("/deleteContact")
	public String deletePerson(@RequestParam("name") String name, ModelMap model) {
		addressBookServiceImpl.deleteContact(name);
		String userName = (String) httpSession.getAttribute("userName");
		List<AddressBookEntity> addressDetails = addressBookServiceImpl.getOtherUser(userName);
		model.put("addressDetails", addressDetails);
		return "useraddressbook";
	}

	@GetMapping("/myAddress")
	public String myaddress(ModelMap model) {
		String userName = (String) httpSession.getAttribute("userName");
		List<AddressBookEntity> addressDetails = addressBookServiceImpl.getOtherUser(userName);
		model.put("addressDetails", addressDetails);
		List<AddressBookEntity> otherAddressDetails = addressBookServiceImpl.getOtherUser("Other Address Book");
		return "useraddressbook";
	}

	@GetMapping("/homePage")
	public String homePage(Model model) {
		log.info("Returning to Home Page");
		return "welcome";
	}

	@GetMapping("/otherAddress")
	public String otherAddress(ModelMap model) {
		List<AddressBookEntity> otherAddressDetails = addressBookServiceImpl.getOtherUser("Other Address Book");
		model.put("otheraddressDetails", otherAddressDetails);
		log.info("otheraddressDetails" + otherAddressDetails);
		return "otheraddressbooks";
	}

	@GetMapping("/uniqueContacts")
	public String uniqueContacts(ModelMap model) {

		String userName = (String) httpSession.getAttribute("userName");
		List<AddressBookEntity> commonInBothList = addressBookServiceImpl.getUniqueContacts(userName,"Other Address Book");
		model.put("commonInBothList", commonInBothList);
		return "uniquecontacts";
	}

}
