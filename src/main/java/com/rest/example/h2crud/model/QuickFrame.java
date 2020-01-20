package com.rest.example.h2crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "quickframe")
public class QuickFrame {
    @Id
    private Integer objectId;
    private String objectNumber;
    private String objectDate;
    private String classification;

    public Integer[] parseObjectDate() {
        Integer[] result = new Integer[2];
        String objDate = this.getObjectDate();
        if(!objDate.isEmpty()) {
            if (objDate.matches("\\d+")) {
                Integer iod = Integer.parseInt(this.getObjectDate());
                result[0] = iod;
                result[1] = iod;
            } else if (objDate.matches("\\d+-\\d+")) {
                String[] od = objDate.split("-");
                result[0] = Integer.parseInt(od[0]);
                result[1] = Integer.parseInt(od[1]);
            } else if (objDate.matches("\\d+ - \\d+")) {
                String[] od = objDate.split(" - ");
                result[0] = Integer.parseInt(od[0]);
                result[1] = Integer.parseInt(od[1]);
            } else if (objDate.matches("Ca. \\d+")) {
                String[] sod = objDate.split("Ca.");
                Integer iod = Integer.parseInt(sod[1]);
                result[0] = iod;
                result[1] = iod - 3;
            }
        }
        return result;
    }
}
