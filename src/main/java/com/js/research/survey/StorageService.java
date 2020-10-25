package com.js.research.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class StorageService {

    public String toFile(String result) {
	File record = new File("results/" + System.currentTimeMillis() + ".json");
	PrintWriter writer;
	try {
	    writer = new PrintWriter(record);
	    writer.append(result);
	    writer.flush();
	    writer.close();
	    System.out.println(">>>>> New result written to " + record.getPath());
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return record.getAbsolutePath();
    }

}
