package com.js.research.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class StorageService {

    public String toFile(String result) {
	File record = new File(System.currentTimeMillis() + ".json");
	PrintWriter writer;
	try {
	    writer = new PrintWriter(record);
	    writer.append(result);
	    writer.flush();
	    writer.close();
	} catch (FileNotFoundException e) { }
	return record.getAbsolutePath();
    }

}
