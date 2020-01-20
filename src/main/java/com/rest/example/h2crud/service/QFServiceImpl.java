package com.rest.example.h2crud.service;

import com.rest.example.h2crud.controller.QFController;
import com.rest.example.h2crud.model.ClassicationCount;
import com.rest.example.h2crud.model.QFWithDates;
import com.rest.example.h2crud.model.QuickFrame;
import com.rest.example.h2crud.repository.QFRepository;
import com.rest.example.h2crud.repository.QuickframeRepository;
import com.rest.example.h2crud.repository.WithDatesRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QFServiceImpl implements QFService {
    public static final Logger log = LoggerFactory.getLogger(QFServiceImpl.class);

    private final QFRepository qfRepository;
    private final WithDatesRepository withDatesRepository;
    private final QuickframeRepository quickframeRepository;

    @Override
    public List<QFWithDates> populateAndGet() {
        log.info("Count is " + withDatesRepository.count());
        if (withDatesRepository.count() == 0) {//Empty table, populate
            log.info("Inside populate");
            List<QuickFrame> qfList = quickframeRepository.findAll();
            log.info("After findAll");
            List<QFWithDates> qfWithDatesList = qfList.stream()
                    .map(e -> new QFWithDates(
                            e.getObjectId(),
                            e.getObjectNumber(),
                            e.getObjectDate(),
                            e.getClassification(),
                            e.parseObjectDate()[0],
                            e.parseObjectDate()[1]))
                    .collect(Collectors.toList());
            log.info("before saveAll");
            withDatesRepository.saveAll(qfWithDatesList);
        }
        log.info("After saveAll");
        List<QFWithDates> result = withDatesRepository.findAll();
        log.info("After withDatesRepository.findAll");
        return result;
    }

    @Override
    public List<ClassicationCount> getCountByClassification() {
        List<ClassicationCount> result = qfRepository.findAll();
        return result;
    }
}