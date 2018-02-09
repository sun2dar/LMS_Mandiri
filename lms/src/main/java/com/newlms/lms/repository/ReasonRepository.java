package com.newlms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newlms.lms.model.Reason;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {

}
