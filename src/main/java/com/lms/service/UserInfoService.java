package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.models.UserInfo;
import com.lms.repository.UserInfoRepository;

@Service(value = "userInfoService")
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserInfo getUserInfo(){

	 return this.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
	
    }
    
    public UserInfo findUserByEmail(String email) {
	return userInfoRepository.findByEmail(email);
    }

    public void saveUser(UserInfo userInfo) {
	userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
	userInfo.setActive(false);
	userInfoRepository.save(userInfo);

    }

    public List<UserInfo> getUsers() {

	return userInfoRepository.findAllByOrderById();
    }

    public UserInfo getUserById(int id) {

	return userInfoRepository.findById(id);
    }

    public void deleteUser(int id) {
	userInfoRepository.delete(id);
    }

    public void blockUser(int id) {

	userInfoRepository.blockUser(id);

    }

    public void unBlockUser(int id) {

	userInfoRepository.unBlockUser(id);
    }

}
