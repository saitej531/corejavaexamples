package org.cap.customermgt.controller;

import org.cap.customermgt.dto.AddCustomerRequestData;
import org.cap.customermgt.exceptions.UnAuthorizedException;
import org.cap.customermgt.service.ICustomerService;
import org.cap.customermgt.entities.Customer;
import org.cap.customermgt.exceptions.CustomerNotFoundException;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/customers")
public class CustomersController {
    private static final Logger Log = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    private ICustomerService service;


    /**
     *
     * Case when only user can fetch his information, not of any other user
     * Admin can fetch information of other users too
     */
    @GetMapping("/getbyid/{id}")
    public Customer findById(@PathVariable("id") int id, HttpServletRequest request) {
        String requestSenderUsername= request.getHeader("requestsender");
        Customer requestSender=service.findByUsername(requestSenderUsername);
        if(requestSender.getId()==id || "admin".equals(requestSender.getRole()))  {
            Customer desiredUser=service.findById(id);
            return desiredUser;
        }
        throw new UnAuthorizedException("you are not authorized");
    }


    /**
     *
     * Case when only user can fetch his information, not of any other user
     * Admin can fetch information of other users too
     */
    @GetMapping("/getbyusername/{username}")
    public Customer findByUsername( @PathVariable("username") String username, HttpServletRequest request) {
        String requestSenderUsername= request.getHeader("requestsender");
        Customer requestSender=service.findByUsername(requestSenderUsername);
        if(requestSenderUsername.equals(username) || "admin".equals(requestSender.getRole()))  {
            Customer desiredUser=service.findByUsername(username);
            return desiredUser;
        }
        throw new UnAuthorizedException("you are not authorized");
    }

    @PostMapping("/add")
    public  Customer addCustomer(@RequestBody AddCustomerRequestData requestData) {
        Customer customer = convert(requestData);
        customer=service.save(customer);
        return customer;
    }

    public Customer convert(AddCustomerRequestData dto) {
        Customer customer = new Customer();
        customer.setUsername(dto.getUsername());
        customer.setPassword(dto.getPassword());
        customer.setRole(dto.getRole());
        return customer;
    }

}
