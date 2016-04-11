/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

/**
 *
 * @author james
 * @author rcatlett
 */

import java.io.BufferedReader;
import java.io.FileReader;
import static temperature.analyzer.project.TemperatureAnalyzerProject.databaseCon;
import static temperature.analyzer.project.TemperatureAnalyzerProject.debug;

public class CSVParser {
    /** Parser algorithm to move data points to database.
     * @param filename The name of the file to be parsed.
     * @return 
     * @throws Exception Because non-generic exceptions are too
     * obnoxious to actually invest time in.
    */
   
    public static boolean uploadFile(String filename)
        throws Exception {
            boolean uploaded = false;
            /* Inform client about input requirements, demonstrate how gnarly
                    an xls file is under the hood to support this point.
            */
            if (!filename.contains(".csv")) {
                    MessageDialogs.UploadError("Error! Not a .csv file!");
            } 

            FileReader fr = null;
            BufferedReader bufr = null;

            /* Initialize file I/O resources. */
            try {
                    fr = new FileReader(filename);
            } catch (Exception e) {
                    // This shouldn't happen unless the user manages to type in a bogus filename.
                    MessageDialogs.UploadError(e.getMessage());
                    throw new Exception("Bad filepath!");
            }
            try {
                    bufr = new BufferedReader(fr);
            } catch (Exception e) { // TODO: use more specific exceptions later
                    MessageDialogs.UploadError("BufferedReader failed!");
                    throw new Exception("BufferedReader failed!");
            }

            /* Grab the header for the location code. */
            String line, location, date, time, temp;
            try { // XXX: this try-block might not be necessary
                    line = bufr.readLine();
                    location = line.split(",")[1];
            } catch (Exception e) { // TODO: use more specific exceptions later
                   MessageDialogs.UploadError("Issue with header capture!");
                   throw new Exception("Issue with header capture!");
            }
            
            if (databaseCon.checkDependency(location)) {

                /* Obtain one line at a time and write the temperature data to DB.*/
                line = bufr.readLine();
                String[] point;

                MessageDialogs.DEBUG("Reading File", debug);
                String[] dateAndTime;
                String[] dateParts;
                while (line != null) {
                        line = bufr.readLine();
                        if (line != null) {
                            point = line.split(",");
                            dateAndTime = point[0].split(" ");
                            dateParts = dateAndTime[0].split("/");
                            date = dateParts[0] + "/" + dateParts[1]+ "/20" + dateParts[2];
                            time = dateAndTime[1];
                            /* Assign NaN if no measurement was recorded at this time. */
                            if (point.length == 2) {
                                    temp = point[1];
                            } else {
                                    temp = "null";
                            }

                            /* we have proven that the parser can loop through the file,
                                so we'll hide this dialogue box pop-up to avoid prompting the
                                user 50,000+ times
                            */
                            //MessageDialogs.showData(location, date, time, temp, debug);
                            databaseCon.addData(databaseCon, location, date, time, temp);

                        }
                }
                MessageDialogs.UploadSuccess();
                uploaded=true;
            }
            else {
                MessageDialogs.UploadFail();
            }
        return uploaded;
    }
}
