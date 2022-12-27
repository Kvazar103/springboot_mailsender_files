package com.example.springboot_mailsender_files.services;

import com.example.springboot_mailsender_files.dao.CustomerDAO;
import com.example.springboot_mailsender_files.models.ActivationToken;
import com.example.springboot_mailsender_files.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerDAO customerDAO;
    private MailService mailService;

    public void save(Customer customer){
        customer.setActivationToken(new ActivationToken());
        customerDAO.save(customer);
        mailService.send(customer);
    }
    public List<Customer> getAllCustomers(){
       List<Customer> customers= customerDAO.findAll();
        return customers;
    }
    public void deleteAll(){
        customerDAO.deleteAll();
    }
    public Customer findById(int id){
      Customer customer=  customerDAO.findById(id).get();
      return customer;
    }
    public void updateCustomer(Customer customer){
        customerDAO.save(customer);
    }
    public Customer byToken(String token){

       return customerDAO.byToken(token);
    }
    public void activate(Customer customer){
        if(customer.getActivationToken().getExpire().isAfter(LocalDateTime.now())){
            customer.setActivated(true);
            updateCustomer(customer);
        }
    }

}
