package Utils;


import config.ConfigManager;

import java.io.*;
import java.util.*;

//Suppose that I am given a csv file containing what tests to run, the goal of this class is to be able to read
//that file, and run specific those specific tests, specifically those marked with the flag "Y".
public class CSVReader {
    public Map<String, List<String>> testsToRun = new HashMap<>(); //once we read the contents of the CSV file, we will store them in here.

    //get contents of CSV file
    public void checkConditionOfExecuteColumn() {
        String fileName = ConfigManager.getTestCSVFIle();
        String line = "";

        //read the contents of the CSV file. Using a try-with-resources block...
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            //We will now read the csv file, and read its contents.
            //Skip the first line as it is just our header.
            br.readLine();

            //We will now begin reading the following lines on the csv file.
            //start by creating a while loop...
            while((line = br.readLine()) !=null){

                //split rows by comma.
                String[] row = line.split(",");

                //Recall the goal of this CSV, we want to ONLY run tests that are marked with "Y" in the execute column.
                //To start, lets begin by creating some strings so we can work with them.
                String testCaseID = row[0]; //TestCaseID
                String executeFlag = row[1]; //Execute data "Y" or "N"

                // The meat of the problem. we will now introduce a conditional to check if the executeFlag is "Y"
                if("Y".equalsIgnoreCase(executeFlag)){
                    List<String> data = new ArrayList<>(); //Test cases that have Y flag will be stored here. Add remaining datapoints
                    data.add(row[2]);
                    data.add(row[3]);
                    data.add(row[4]);

                    testsToRun.put(testCaseID, data);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Only obtaining the Keys (TestCaseIDs) to test them for later. (verifying to make sure our hash map keys have the correct tests. aka those marked with Y.
    public String getTestIDs(){
        return testsToRun.keySet().toString();
    }




}
