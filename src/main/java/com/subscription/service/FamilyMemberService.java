package com.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.subscription.dao.FamilyMemberDao;
import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;

@Service
public class FamilyMemberService {

	@Autowired
	@Qualifier("familyMemberDaoImpl")
	private FamilyMemberDao familyMemberDao;
	
	
	public void addFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user) {
		this.familyMemberDao.addFamilyMember(familyMemberDto, user);
	}
	public void deleteFamilyMember(FamilyMember familyMember) {
		this.familyMemberDao.deleteFamilyMember(familyMember);
	}
	
	public void updateFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user) {
		this.familyMemberDao.updateFamilyMember(familyMemberDto, user);
	}
	
	public List<FamilyMember> findUserFamilyMember(User user){
		return this.familyMemberDao.findUserFamilyMember(user);
	}
	
	public FamilyMember findByEmail(String email) {
		return this.familyMemberDao.findByEmail(email);
	}
	
	public FamilyMember findByFamilyMemberId(Integer familyMemberId) {
		return this.familyMemberDao.findByFamilyMemberId(familyMemberId);
	}
}
