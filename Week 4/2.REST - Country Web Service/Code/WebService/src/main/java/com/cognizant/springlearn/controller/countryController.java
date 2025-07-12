package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.countryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class countryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(countryController.class);

    @Autowired
    private countryService countryService;

    // 🔁 Reuse from earlier assignment
    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START getCountry()");
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry()");
        return country;
    }

    // 🔹 New Method: /country
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country");
        LOGGER.info("END getCountryIndia()");
        return country;
    }
}
