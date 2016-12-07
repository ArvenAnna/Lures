package com.anna.lure.repository;

import com.anna.lure.persist.Color;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    List<Color> findByLureId(Integer lureId);

}
