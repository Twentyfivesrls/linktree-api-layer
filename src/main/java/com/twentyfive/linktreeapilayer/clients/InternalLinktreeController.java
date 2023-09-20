package com.twentyfive.linktreeapilayer.clients;

import com.twentyfive.twentyfivemodel.models.LinkTree;
import com.twentyfive.twentyfivemodel.models.UserLink;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "InternalLinktreeController", url = "http://80.211.123.167:8091/twentyfive-db")
public interface InternalLinktreeController {

    @RequestMapping(method = RequestMethod.POST, value="/linkTree/add")
    UserLink add(@RequestBody LinkTree linkTree, @RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.GET, value="/linkTree/findByUsername")
    UserLink getByUsername(@RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.GET, value="/linkTree/findByUsername")
    UserLink getByUser(@RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.PUT, value="/linkTree/update")
    UserLink update(@RequestParam("id") String id,@RequestParam("username") String username, @RequestBody LinkTree linkTree);

    @RequestMapping(method = RequestMethod.DELETE, value="/linkTree/delete")
    UserLink delete(@RequestParam("username") String username, @RequestParam("id") String id);


}
