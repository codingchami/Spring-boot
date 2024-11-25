package com.iitpos.pos.Service.impl;

import com.iitpos.pos.Service.CustomerService;
import com.iitpos.pos.dto.request.CustomerSaveRequestDTO;
import com.iitpos.pos.dto.response.CustomerAllDeatilsResponseDTO;
import com.iitpos.pos.dto.response.CustomerResponseDTO;
import com.iitpos.pos.entity.Customer;
import com.iitpos.pos.exception.NotFoundException;
import com.iitpos.pos.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {
        Customer customer = new Customer(

                saveRequestDTO.getCustomerID(),
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getCustomerAddress(),
                saveRequestDTO.getSalary(),
                saveRequestDTO.getContacts(),
                saveRequestDTO.getNic(),
                saveRequestDTO.isActiveState()
        );

        customerRepo.save(customer);
        return "saved";
    }

    @Override
    public String updateCustomer(CustomerSaveRequestDTO requestDTO) {
        if (customerRepo.existsById(requestDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(requestDTO.getCustomerID());

            customer.setCustomerName(requestDTO.getCustomerName());
            customer.setCustomerAddress(requestDTO.getCustomerAddress());
            customer.setCustomerID(requestDTO.getCustomerID());
            customer.setActiveState(requestDTO.isActiveState());

            customerRepo.save(customer);
            return requestDTO.getCustomerName() + "has been updated...!";
        }else{
            return "something went wrong...!";
        }
    }

    @Override
    public CustomerResponseDTO getCustomerById(int customerID) {
        if(customerRepo.existsById(customerID)){
            Customer customer = customerRepo.getReferenceById(customerID);

//            CustomerResponseDTO responseDTO = new CustomerResponseDTO(
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getSalary(),
//                    customer.getContacts(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//            return responseDTO;

            return new CustomerResponseDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            );
        }else{
            return null;
        }
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();

        List<CustomerResponseDTO> responseDTOS = new ArrayList<>();

        if(!customers.isEmpty()){
            for (Customer customer:customers){
                responseDTOS.add(new CustomerResponseDTO(
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContacts(),
                        customer.getNic(),
                        customer.isActiveState()
                ));
            }
            return responseDTOS;
        }else{
            throw new NotFoundException("Customer is not Found!...");    //handle exception in company standard
        }

    }

    @Override
    public String deleteCustomer(int customerID) {
        if(customerRepo.existsById(customerID)){
            customerRepo.deleteById(customerID);
            return customerID+" Customer has been deleted...!";
        }else{
            return "Customer is not found!.........";
        }
    }

    @Override
    public List<CustomerAllDeatilsResponseDTO> getAllCustomersByState(boolean state) {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(state);

        List<CustomerAllDeatilsResponseDTO> responseDTOS = new ArrayList<>();

        for (Customer customer:customers){
            responseDTOS.add(new CustomerAllDeatilsResponseDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            ));
        }

        return responseDTOS;
    }

}
