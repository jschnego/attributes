package com.js.research.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class SurveyRestController {

    @Autowired
    private StorageService storage;

    @PostMapping("/store")
    public void store(@RequestBody String result) {
	storage.toFile(result);
    }

}
