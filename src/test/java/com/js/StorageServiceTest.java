package com.js;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.js.research.survey.StorageService;

public class StorageServiceTest {

    private final StorageService storage = new StorageService();

    @BeforeClass
    public static void init() {
	File dir = new File("results");
	dir.mkdir();
    }
    
    @Test
    public void shouldCreateNewFileOnInvocation() throws IOException {
	String fileName = storage.toFile("{}");
	File created = new File(fileName);
	assertTrue(created.exists());
	created.delete();
    }

    @Test
    public void argumentShouldBeWrittenToFile() throws FileNotFoundException {
	String testString = "{'name' : 'test'}";
	String fileName = storage.toFile(testString);
	String content = getFileContent(fileName);
	
	assertEquals(testString, content);
	new File(fileName).delete();
    }

    private String getFileContent(String fileName) throws FileNotFoundException {
	Scanner scanner = new Scanner(new File(fileName));
	StringBuilder builder = new StringBuilder();

	while (scanner.hasNext()) {
	    builder.append(scanner.nextLine());
	}
	
	return builder.toString();
    }
    
    @AfterClass
    public static void cleanUp() {
	File dir = new File("results");
	dir.deleteOnExit();
    }

}
