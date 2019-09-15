package com.subscription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subscription.entity.FamilyMember;
import com.subscription.entity.User;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer>{

	List<FamilyMember> findByUser(User user);
	
	FamilyMember findByEmail(String email);

}
