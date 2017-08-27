package com.libertymutual.goforcode.timeless.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.Timeless;

@Service
public class TimelessRepository {
	
	Timeless tracker; 
	List<Timeless> submission = new ArrayList<Timeless>(); //this will be used when importing all data from entries array below and print to browser when submitted
	//String[] rowEntries = new String[7];
	String[] entries = new String[7]; //this will store date, all the days' hrs...
	Timeless currentWeek = new Timeless();
	
//	//when user enters time and hits update
    public void update(Timeless time) {

    	CSVFormat csvFileFormat = CSVFormat.DEFAULT;
    	
    	try (FileWriter writer = new FileWriter("time.csv", true); 
    		BufferedWriter buffer = new BufferedWriter(writer);
    		CSVPrinter printer = new CSVPrinter(buffer, csvFileFormat)) {
    		
    		
    	}  catch (IOException e) {
    		
    		System.out.println("could not read file");
		}

    }
    
    //saving, writing and updating to the browser (when user hits submit)
    public void submit(Timeless time) {
    	
    	CSVFormat csvFileFormat = CSVFormat.DEFAULT;
	
    	try (FileWriter writer = new FileWriter("tracker.csv", true); 
    		BufferedWriter bufferW = new BufferedWriter(writer);
    		CSVPrinter printer = new CSVPrinter(bufferW, csvFileFormat)) { 
    			
    			String date = time.getWeek();
    			String monday = Double.toString(time.getMondayHours());
    			String tuesday = Double.toString(time.getTuesdayHours());
    			String wednesday = Double.toString(time.getWednesdayHours());
    			String thursday = Double.toString(time.getThursdayHours());
    			String friday = Double.toString(time.getFridayHours());
    			String total = Double.toString(time.calculateTotalHours());
    			
    			entries[0] = date;
    			entries[1] = monday;
    			entries[2] = tuesday;
    			entries[3] = wednesday;
    			entries[4] = thursday;
    			entries[5] = friday;
    			entries[6] = total;
    			
    			printer.printRecord(entries);
    		
    	} catch (FileNotFoundException e) {
			
    		System.out.println("file not found");
    		
		} catch (IOException e) {
			
			System.out.println("error reading file");

		}
    	
    }

	public List<Timeless> getAll() {
    	CSVFormat csvFileFormat = CSVFormat.DEFAULT;
    	
		try(FileReader reader = new FileReader("tracker.csv"); 
			BufferedReader buffer = new BufferedReader(reader);
	    	CSVParser parser = new CSVParser(buffer, csvFileFormat)) {
			
			Iterable<CSVRecord> records = csvFileFormat.parse(buffer);
			
			Timeless entry = new Timeless();
			
			for (CSVRecord record : records) {
				
				String week = record.get(0);
				entry.setWeek(week);
				
			    String monday = record.get(1);
			    Double mondayHours = Double.parseDouble(monday);
			    entry.setMondayHours(mondayHours);
			    
			    String tuesday = record.get(2);
			    Double tuesdayHours = Double.parseDouble(tuesday);
			    entry.setTuesdayHours(tuesdayHours);
			    
			    String wednesday = record.get(3);
			    Double wednesdayHours = Double.parseDouble(wednesday);
			    entry.setWednesdayHours(wednesdayHours);
			    
			    String thursday = record.get(4);
			    Double thursdayHours = Double.parseDouble(thursday);
			    entry.setThursdayHours(thursdayHours);
			    
			    String friday = record.get(5);
			    Double fridayHours = Double.parseDouble(friday);
			    entry.setFridayHours(fridayHours);
			    
			    String total = record.get(6);
			    Double totalHours = Double.parseDouble(total);
			    entry.setTotalHours(totalHours);
			   
			}
			submission.add(0, entry);
			

		} catch (FileNotFoundException e) {
			
			System.out.println("could not find file");
			
		} catch (IOException e) {
			System.out.println("could not render file");
		}
		return submission;
	}
	
}
