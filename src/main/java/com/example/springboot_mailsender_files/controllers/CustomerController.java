package com.example.springboot_mailsender_files.controllers;

import com.example.springboot_mailsender_files.models.Customer;
import com.example.springboot_mailsender_files.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
    }
    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("")
    public void deleteAllCustomers(){
        customerService.deleteAll();
    }
    @GetMapping("/activate/{id}")
    public void activateCustomer(@PathVariable int id){
      Customer customer= customerService.findById(id);
      customer.setActivated(true);
      customerService.updateCustomer(customer);
    }
}