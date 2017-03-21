package com.iyl.stock.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iyl.stock.service.impl.DrugServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

    @Autowired(required = false)
    DrugServiceImpl drugService;

    //    Log log = LogFactory.getLog(MainController.class);
    //    static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        model.addAttribute("drugSelect", drugService.selectDrug());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "home";
    }

}
