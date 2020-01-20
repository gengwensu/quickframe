package com.rest.example.h2crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "qfwithdates")
public class QFWithDates {
    @Id
    private Integer objectId;
    private String objectNumber;
    private String objectDate;
    private String classification;
    private Integer objectStartDate;
    private Integer objectEndDate;
}
