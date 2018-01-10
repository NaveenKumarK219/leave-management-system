package com.lms.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lms.models.LeaveDetails;
import com.lms.models.UserInfo;
import com.lms.service.LeaveManageService;
import com.lms.service.UserInfoService;

@Controller
public class LeaveManageController {

    @Autowired
    private LeaveManageService leaveManageService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user/apply-leave", method = RequestMethod.GET)
    public ModelAndView applyLeave(ModelAndView mav) {

	mav.addObject("leaveDetails", new LeaveDetails());
	mav.setViewName("applyLeave");
	return mav;
    }

    @RequestMapping(value = "/user/apply-leave", method = RequestMethod.POST)
    public ModelAndView submitApplyLeave(ModelAndView mav, @Valid LeaveDetails leaveDetails,
	    BindingResult bindingResult) {

	UserInfo userInfo = userInfoService.getUserInfo();
	if (bindingResult.hasErrors()) {
	    mav.setViewName("applyLeave");
	} else {
	    leaveDetails.setEmployeeName(userInfo.getFirstName() + " " + userInfo.getLastName());
	    leaveManageService.applyLeave(leaveDetails);
	    mav.addObject("successMessage", "Your Leave Request is registered!");
	    mav.setView(new RedirectView("/leave-management-system/user/home"));
	}
	return mav;
    }

    @RequestMapping(value = "/user/all-leaves", method = RequestMethod.GET)
    public @ResponseBody String getAllLeaves() throws Exception {

	Iterator<LeaveDetails> iterator = leaveManageService.getAllLeaves().iterator();
	JSONArray jsonArr = new JSONArray();
	SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	Calendar calendar = Calendar.getInstance();

	while (iterator.hasNext()) {
	    LeaveDetails leaveDetails = iterator.next();
	    calendar.setTime(leaveDetails.getToDate());
	    calendar.add(Calendar.DATE, 1);

	    JSONObject jsonObj = new JSONObject();
	    jsonObj.put("title", leaveDetails.getEmployeeName());
	    jsonObj.put("start", dateFormat.format(leaveDetails.getFromDate()));
	    jsonObj.put("end", dateFormat.format(calendar.getTime()));
	    if (leaveDetails.isActive())
		jsonObj.put("color", "#0878af");
	    if (!leaveDetails.isActive() && leaveDetails.isAcceptRejectFlag())
		jsonObj.put("color", "green");
	    if (!leaveDetails.isActive() && !leaveDetails.isAcceptRejectFlag())
		jsonObj.put("color", "red");
	    jsonArr.put(jsonObj);
	}

	return jsonArr.toString();
    }
    
    @RequestMapping(value="/user/manage-leaves",method= RequestMethod.GET)
    public ModelAndView manageLeaves(ModelAndView mav) {

	mav.addObject("leavesList", leaveManageService.getAllActiveLeaves());
	mav.setViewName("manageLeaves");
	return mav;
    }

    @RequestMapping(value = "/user/manage-leaves/{action}/{id}", method = RequestMethod.GET)
    public ModelAndView acceptOrRejectLeaves(ModelAndView mav, @PathVariable("action") String action,
	    @PathVariable("id") int id) {
	LeaveDetails leaveDetails = leaveManageService.getLeaveDetailsOnId(id);
	if (action.equals("accept")) {
	    leaveDetails.setAcceptRejectFlag(true);
	    leaveDetails.setActive(false);
	} else if (action.equals("reject")) {
	    leaveDetails.setAcceptRejectFlag(false);
	    leaveDetails.setActive(false);
	}
	leaveManageService.updateLeaveDetails(leaveDetails);
	mav.addObject("successMessage", "Updated Successfully!");
	mav.setView(new RedirectView("/leave-management-system/user/manage-leaves"));
	return mav;
    }
}
