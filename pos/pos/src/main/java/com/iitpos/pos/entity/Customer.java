package com.iitpos.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Customer")
@TypeDef(name = "json",typeClass = JsonType.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @Column(name = "customer_id",length = 10)
    private int customerID;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",nullable = false)
    private String customerAddress;

    @Column(name = "salary",nullable = false)
    private double salary;

    @Type(type = "json")
    @Column(name = "contacts",columnDefinition = "json")
    private ArrayList<String> contacts;

    @Column(name = "nic",nullable = false)
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

}
