package com.rest.example.h2crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "quickframe")
public class QuickFrame {
    public static final Logger log = LoggerFactory.getLogger(QuickFrame.class);
    @Id
    private Integer objectId;
    private String objectNumber;
    private String objectDate;
    private String classification;

    public Integer[] parseObjectDate() {
        Integer[] result = new Integer[2];
        result[0] = 0;
        result[1] = 0;
        String objDate = this.getObjectDate();
        if (!objDate.isEmpty()) {
            if (objDate.matches("\\d+")) {
                Integer iod = Integer.parseInt(this.getObjectDate());
                result[0] = iod;
                result[1] = iod;
            } else if (objDate.matches("\\d+–\\d+")) {
                /*log.info("objDate is " + objDate);*/
                String[] sod = objDate.split("–", 2);
                /*log.info("sod are ", sod.toString());*/
                result[0] = Integer.parseInt(sod[0]);
                result[1] = Integer.parseInt(sod[1]);
                if(sod[1].length()==2){
                    result[1]+=result[0]/100*100;
                }
            } else if (objDate.matches("ca\\. \\d+")) {
                String[] sod = objDate.split("ca\\. ");
                Integer iod = Integer.parseInt(sod[1]);
                result[0] = iod;
                result[1] = iod - 3;
            } else {
                result[0] = 1;
                result[1] = 1;
            }
        }
        return result;
    }
}
