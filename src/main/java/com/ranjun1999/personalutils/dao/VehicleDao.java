package com.ranjun1999.personalutils.dao;

import com.ranjun1999.personalutils.model.Vehicle;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:14
 */
public interface VehicleDao {

    void addVehicle(List<Vehicle> vehicles);

    void delVehicle(Vehicle vehicle);

    List<Vehicle> selectVehicles(int QuestionId);
}
