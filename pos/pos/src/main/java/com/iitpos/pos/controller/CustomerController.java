package com.iitpos.pos.controller;

import com.iitpos.pos.Service.CustomerService;
import com.iitpos.pos.dto.request.CustomerSaveRequestDTO;
import com.iitpos.pos.dto.response.CustomerAllDeatilsResponseDTO;
import com.iitpos.pos.dto.response.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;        //property dependent injection
    @PostMapping(path = "/save-customer")   //create customer
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){
        String message = customerService.saveCustomer(saveRequestDTO);
        return message;
    }

    @PutMapping(path = "/update-customer")   //update customer
    public String updateCustomer(@RequestBody CustomerSaveRequestDTO requestDTO){
        String message = customerService.updateCustomer(requestDTO);
        return message;
    }
    @GetMapping(
            path = "/get-customer-by-id",
            params = "id"
    )
    public CustomerResponseDTO getCustomerById(@RequestParam(value = "id")int customerID){
        return customerService.getCustomerById(customerID);
    }
    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerResponseDTO> getAllCustomers(){
//        List<CustomerResponseDTO> dtoList =  customerService.getAllCustomers();
//        return dtoList;

        return customerService.getAllCustomers();
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerID){
//        String message = customerService.deleteCustomer(customerID);
//        return message;

        return customerService.deleteCustomer(customerID);
    }

    @GetMapping(
            path = "/get-all-customer-by-state",
            params = "state"
    )

    public List<CustomerAllDeatilsResponseDTO> getCustomeerByState(@RequestParam(value = "state")boolean state){
        List<CustomerAllDeatilsResponseDTO> dtoList = customerService.getAllCustomersByState(state);
        return dtoList;
    }

}
