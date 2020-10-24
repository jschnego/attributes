package com.js.research.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyRestController {

    @Autowired
    private StorageService storage;

    @PostMapping("/api/store")
    public ResponseEntity<Void> store(@RequestBody String result) {
	storage.toFile(result);
	return ResponseEntity.ok().build();
    }

}