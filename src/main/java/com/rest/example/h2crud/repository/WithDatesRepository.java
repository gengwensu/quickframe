package com.rest.example.h2crud.repository;

import com.rest.example.h2crud.model.QFWithDates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithDatesRepository extends JpaRepository<QFWithDates, Integer> {
}
