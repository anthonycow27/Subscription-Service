package com.subscription.dao;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;

public interface FamilyMemberDao {
	
	void addFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user);
	void deleteFamilyMember(FamilyMember familyMember);
	void updateFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user);
	List<FamilyMember> findUserFamilyMember(User user);
	FamilyMember  findByFamilyMemberId(Integer familyMemberId);
	FamilyMember findByEmail(String email);
	
}
