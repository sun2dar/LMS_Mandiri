package com.newlms.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newlms.lms.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
