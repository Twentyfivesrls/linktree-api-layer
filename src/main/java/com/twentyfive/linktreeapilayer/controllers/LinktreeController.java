package com.twentyfive.linktreeapilayer.controllers;

import com.twentyfive.authorizationcontroller.services.AuthenticationService;
import com.twentyfive.linktreeapilayer.clients.InternalLinktreeController;
import com.twentyfive.twentyfivemodel.models.LinkTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linkTree")
@CrossOrigin(origins = "*")
public class LinktreeController {

    @Autowired
    private  InternalLinktreeController linktreeController;


    private AuthenticationService authenticationService = new AuthenticationService();

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody LinkTree linkTree, String username) {
        try{
            username = authenticationService.getUsername();
            return ResponseEntity.ok(linktreeController.add(linkTree, username));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/findByUser")
    public ResponseEntity<Object> getByUser(String username) {
        try{
            username = authenticationService.getUsername();
            return ResponseEntity.ok(linktreeController.getByUsername(username));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<Object> getByUsername(@RequestParam("username") String username) {
        try{
            return ResponseEntity.ok(linktreeController.getByUsername(username));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam("id") String id, String username, @RequestBody LinkTree linkTree){
        try{
            username = authenticationService.getUsername();
            return ResponseEntity.ok(linktreeController.update(id, username, linkTree));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(String username, @RequestParam("id") String id) {
        try{
            username = authenticationService.getUsername();
            return ResponseEntity.ok(linktreeController.delete(username,id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
