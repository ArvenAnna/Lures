package com.anna.lure.controller;

import com.anna.lure.dto.LureDto;
import com.anna.lure.service.ILureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LureController {

    @Autowired
    ILureService lureService;

 @RequestMapping(value = {"/lure.req"}, method = RequestMethod.POST,
            headers = "Accept=application/json")
    @ResponseBody
    protected Integer saveLure(@RequestBody LureDto lure) {
        return lureService.saveLure(lure);
    }

    @RequestMapping(value = {"/lure.req"}, method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    @ResponseBody
    public void deleteLure(@RequestParam("id") Integer id) {
        lureService.deleteLure(id);
    }

    @RequestMapping(value = {"/lures.req"}, method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public List<LureDto> fetchLures() {
        return lureService.findLures();
    }


    @RequestMapping(value = {"/lure.req"}, method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public LureDto findLure(@RequestParam("id") Integer id) {
        return lureService.findLure(id);
    }
}
