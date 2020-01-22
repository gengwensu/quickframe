package com.rest.example.h2crud.repository;

import com.rest.example.h2crud.model.ClassCount;
import com.rest.example.h2crud.model.QuickFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuickframeRepository extends JpaRepository<QuickFrame, Integer> {
    @Query("select q.classification as classification, count(q) as total from QuickFrame as q group by q.classification having q.classification is not NULL")
    List<ClassCount> groupByStats();
}
