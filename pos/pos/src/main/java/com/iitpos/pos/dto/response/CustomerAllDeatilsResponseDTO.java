package com.iitpos.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerAllDeatilsResponseDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double salary;
    private ArrayList contscts;
    private String nic;
    private boolean activities;
}
