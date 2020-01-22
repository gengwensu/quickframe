package com.rest.example.h2crud.service;

import com.rest.example.h2crud.model.ClassCount;
import com.rest.example.h2crud.model.QFWithDates;

import java.util.List;

public interface QFService {
    List<QFWithDates> populateAndGet();
    List<ClassCount> getCountByClassification();
}
