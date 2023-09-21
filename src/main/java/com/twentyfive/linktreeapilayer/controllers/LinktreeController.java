package com.twentyfive.linktreeapilayer.controllers;

import com.twentyfive.authorizationcontroller.services.AuthenticationService;
import com.twentyfive.linktreeapilayer.clients.InternalLinktreeController;
import com.twentyfive.twentyfivemodel.models.linktreeModels.LinkTree;
import com.twentyfive.twentyfivemodel.models.linktreeModels.UserLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linkTree")
@CrossOrigin(origins = "*")
public class LinktreeController {

    @Autowired
    private InternalLinktreeController linktreeController;


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody LinkTree linkTree) {
        String username = authenticationService.getUsername();
        UserLink result = linktreeController.add(linkTree, username);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findByUser")
    public ResponseEntity<Object> getByUser() {
        String username = authenticationService.getUsername();
        UserLink response = linktreeController.getByUser(username);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<Object> getByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok(linktreeController.getByUsername(username));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam("id") String id, @RequestBody LinkTree linkTree) {
        String username = authenticationService.getUsername();
        return ResponseEntity.ok(linktreeController.update(id, username, linkTree));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam("id") String id) {
        String username = authenticationService.getUsername();
        return ResponseEntity.ok(linktreeController.delete(username, id));
    }

    @RequestMapping("/test")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("Hello from private resource");
    }

}
