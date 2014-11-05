/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class FileIO {
    
	
	
    //This is the random access file that will hold all student info
    private static RandomAccessFile gamesFile;
	
	
    //This is the size (in bytes) of each student
    private static final int RECORD_SIZE = 90;
    private int totalRecords;
    
    public static void init() throws IOException {
        try {
            gamesFile = new RandomAccessFile("gamefile.txt", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //All println statements were strictly for testing so please ignore, thanks
        System.out.println(FileIO.getTotalRecords());
    }
    
    public static void writeRecord(Game game) throws IOException {
            gamesFile.seek((FileIO.getTotalRecords())*RECORD_SIZE);
            gamesFile.writeBytes(game.getConsole());
            gamesFile.writeBytes(game.getName());
            gamesFile.writeBytes(game.getGenre());
            gamesFile.writeBytes(game.getRating());
            gamesFile.writeBytes(game.getYear());
            gamesFile.writeBytes(game.getPrice());

            System.out.println(FileIO.getTotalRecords());
		
	}
	/**
	 * Takes a record number from the user and outputs to a textarea all of that records' values.
	 * @param choice The record number the user wants to read
         * @return Array containing values of record
	 * @throws IOException
	 */
	public static String[] readRecords(int choice) throws IOException {


            gamesFile.seek((choice)*RECORD_SIZE);
            System.out.println("This game is game number " + (choice-1)*RECORD_SIZE);
            System.out.println(RECORD_SIZE);

            byte[] nameTemp = new byte[30];
            byte[] consoleTemp = new byte[30];
            byte[] genreTemp = new byte[15];
            byte[] ratingTemp = new byte[1];
            byte[] yearTemp = new byte[4];
            byte[] priceTemp = new byte[10];
            
            //converts the byte array to a string, using 8 bits (1 byte) per character.

            for (int j = 0; j < 30; j++) {
                    consoleTemp[j] = gamesFile.readByte();
            }
            String console = new String(consoleTemp, "UTF-8");

            for (int j= 0; j < 30; j++) {
                    nameTemp[j] = gamesFile.readByte();
            }
            String name = new String(nameTemp, "UTF-8");

            for (int j = 0; j < 15; j++) {
                    genreTemp[j] = gamesFile.readByte();
            }
            String genre = new String(genreTemp, "UTF-8");

            for (int j = 0; j < 1; j++) {
                    ratingTemp[j] = gamesFile.readByte();
            }
            String rating = new String(ratingTemp, "UTF-8");

            for (int j = 0; j < 4; j++) {
                    yearTemp[j] = gamesFile.readByte();
            }
            String year = new String(yearTemp, "UTF-8");
            
            for (int j = 0; j<10; j++) {
                priceTemp[j] = gamesFile.readByte();
            }
            String price = new String(priceTemp, "UTF-8");

            //Shows result for debugging
            System.out.println("Game info: \nGame name: " + name + "\nConsole: " + console + "\nGenre: " + genre + "\nRating" + rating + "\nYear" + year + "\nPrice" + price);
            
            //String containing values read from File
            String[] values = {name, console, genre, rating, year, price};
            
            return values;
            


	}
	
	/**
	 * Modifies an existing record with new values. Works like writeRecord but the record number is specified.
	 * @param choicer Record number to edit
         * @param game Game to modify with
	 * @throws IOException
	 */
	public static void modifyRecords(int choicer, Game game) throws IOException {
		
		//Seek to choice - record size to write from beginning of record
		gamesFile.seek((choicer - 1) * RECORD_SIZE);
		
		gamesFile.writeBytes(game.getConsole());
		gamesFile.writeBytes(game.getName());
		gamesFile.writeBytes(game.getGenre());
		gamesFile.writeBytes(game.getRating());
		gamesFile.writeBytes(game.getYear());
                gamesFile.writeBytes(game.getPrice());

	}
        
        /**
         * Returns total records in file
         * @return number of records in gamesFile.txt
         */
        public static int getTotalRecords() {
            try {
                System.out.println(gamesFile.length());
                return ((int)gamesFile.length())/RECORD_SIZE;
                
            } catch (IOException ex) {
                System.err.println("GAMEFILE LENGTH COULD NOT BE READ.");
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }
        }

        

}

