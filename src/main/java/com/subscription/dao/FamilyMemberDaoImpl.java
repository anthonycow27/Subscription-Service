package com.subscription.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.subscription.dto.FamilyMemberRegistrationDto;
import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;
import com.subscription.repository.FamilyMemberRepository;

@Repository
@Qualifier("familyMemberDaoImpl")
public class FamilyMemberDaoImpl implements FamilyMemberDao{
	
	@Autowired
	private FamilyMemberRepository familyMemberRepository;

	@Override
	public void addFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user) {
		
		FamilyMember familyMember = new FamilyMember();
		familyMember.setName(familyMemberDto.getName());
		familyMember.setEmail(familyMemberDto.getEmail());
		familyMember.setAge(familyMemberDto.getAge());
		familyMember.setDescription(familyMemberDto.getDescription());
		familyMember.setUser(user);
		
		familyMemberRepository.save(familyMember);
		
	}

	@Override
	public List<FamilyMember> findUserFamilyMember(User user) {
		return familyMemberRepository.findByUser(user);
	}

	@Override
	public FamilyMember findByEmail(String email) {
		return familyMemberRepository.findByEmail(email);
	}



	@Override
	public void deleteFamilyMember(FamilyMember familyMember) {
		this.familyMemberRepository.delete(familyMember);
		
	}

	@Override
	public FamilyMember findByFamilyMemberId(Integer familyMemberId) {
		return this.familyMemberRepository.findById(familyMemberId).orElse(null);
	}

	@Override
	public void updateFamilyMember(FamilyMemberRegistrationDto familyMemberDto, User user) {
		FamilyMember familyMember = familyMemberRepository.findByEmail(familyMemberDto.getEmail());	
		familyMember.setName(familyMemberDto.getName());
		familyMember.setEmail(familyMemberDto.getEmail());
		familyMember.setAge(familyMemberDto.getAge());
		familyMember.setDescription(familyMemberDto.getDescription());
		familyMember.setUser(user);
		
		familyMemberRepository.save(familyMember);
		
	}

	
}
