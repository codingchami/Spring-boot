package com.iitpos.pos.controller;

import com.iitpos.pos.dto.request.CustomerSaveRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping(path = "/save.customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){
        return saveRequestDTO.getCustomerName();
    }
}
