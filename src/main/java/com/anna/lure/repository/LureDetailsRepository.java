package com.anna.lure.repository;

import com.anna.lure.persist.LureDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LureDetailsRepository extends JpaRepository<LureDetail, Integer> {

}
