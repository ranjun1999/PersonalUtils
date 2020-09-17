package com.ranjun1999.personalutils.service;

import com.ranjun1999.personalutils.model.Vehicle;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:22
 */
public interface VehicleService {

    void addVehicle(List<Vehicle> vehicles);

    void delVehicle(Vehicle vehicle);
}
