package com.zahra.ninjagold.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/gold")
public class MainController {
	
	@RequestMapping("")
	public String home(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);			
		}
		if (session.getAttribute("activites") == null){
			session.setAttribute("activites", new ArrayList<String>());			
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/process_money")
	public String Process(@RequestParam (value="location") String location,
			HttpSession session, Model model) {
		ArrayList<String> activites = (ArrayList<String>) session.getAttribute("activites");
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDate = dateFormat.format(date);
		
		if (location.equals("farm")) {
			int random = (int) Math.floor(Math.random()*(20-10+1)+10);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + random);
			activites.add("You entered a " + location + " and earned " + random + " gold. (" + strDate +")");
		} else if (location.equals("cave")) {
			int random = (int) Math.floor(Math.random()*(10-5+1)+5);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + random);
			activites.add("You entered a " + location + " and earned " + random + " gold. (" + strDate +")");
		} else if (location.equals("house")) {
			int random = (int) Math.floor(Math.random()*(5-2+1)+2);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + random);
			activites.add("You entered a " + location + " and earned " + random + " gold. (" + strDate +")");
		} else if (location.equals("casino")) {
			int random = (int) Math.floor(Math.random()*(50-0+1)+0);
			int earnTake = (int) Math.floor(Math.random()*(1-0+1)+0);
			if (earnTake == 1) {				
				session.setAttribute("gold", (Integer) session.getAttribute("gold") + random);
				activites.add("You entered a " + location + " and earned " + random + " gold. (" + strDate +")");
			} else {
				session.setAttribute("gold", (Integer) session.getAttribute("gold") - random);
				activites.add("You entered a " + location + " and lost " + random + " gold. (" + strDate +")");
			}
		}
		
		
		
		return "redirect:/gold";
	}
	
}
