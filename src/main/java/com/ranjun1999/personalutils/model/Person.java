package com.ranjun1999.personalutils.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: ranjun
 * @Date: 2020/3/21 9:50
 */
@Component
@Data
public class Person {
    private String name;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
