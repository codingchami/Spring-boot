package com.iitpos.pos.Service;

import com.iitpos.pos.dto.request.CustomerSaveRequestDTO;
import com.iitpos.pos.dto.response.CustomerAllDeatilsResponseDTO;
import com.iitpos.pos.dto.response.CustomerResponseDTO;

import java.util.List;

//In the interface has abstract method
public interface CustomerService {

    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO requestDTO);

    CustomerResponseDTO getCustomerById(int customerID);

    List<CustomerResponseDTO> getAllCustomers();

    String deleteCustomer(int customerID);

    List<CustomerAllDeatilsResponseDTO> getAllCustomersByState(boolean state);
}
