package com.lms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
