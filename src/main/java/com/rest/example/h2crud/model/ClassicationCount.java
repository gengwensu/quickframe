package com.rest.example.h2crud.model;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "classificationcount")
public class ClassicationCount {
    @Id @GeneratedValue
    private Integer id;
    private String classification;
    private Integer total;
}
