
package io;

/**
 * Class: Game
 * @author Kevin Stewart <kevinjstew@gmail.com>
 */

public class Game {
	
        
	private String rating;	 //1 byte
	private String year;	 //4 bytes
	private String genre;    //15 bytes
	private String name;     //30 bytes
	private String console;  //30 bytes
        private String price;    //10 bytes
        
	protected final int RECORD_SIZE = 90;
	
        /**
         * New Game object to be written to a file
         * @param name name of game
         * @param rating rating of game
         * @param year year released
         * @param genre genre of game
         * @param console console the game is for
         * @param price price of game
         */
	public Game (String name, String rating, String year, String genre, String console, String price) {
		this.rating = rating;
		this.year = year;
		this.genre = genre;
		this.name = name;
		this.console = console;
                this.price = price;
	}
	
	
	public String getGenre() {
            StringBuilder temp = new StringBuilder(this.genre);
            temp.setLength(15);
            this.genre = temp.toString();
            return this.genre;
	}
	
	public String getConsole() {
            StringBuilder temp = new StringBuilder(this.console);
            temp.setLength(30);
            this.console = temp.toString();
            return this.console;
	}
	
	public String getName() {
            StringBuilder temp = new StringBuilder(this.name);
            temp.setLength(30);
            this.name = temp.toString();
            return this.name;
	}
	
	public String getRating() {
            StringBuilder temp = new StringBuilder(this.rating);
            temp.setLength(1);
            this.rating = temp.toString();
            return this.rating;
	}
	
	public String getYear() {
            StringBuilder temp = new StringBuilder(this.year);
            temp.setLength(4);
            this.year = temp.toString();
            return this.year;
	}
        
        public String getPrice() {
            StringBuilder temp = new StringBuilder(this.price);
            temp.setLength(10);
            this.price = temp.toString();
            return this.price;
        }
	
	public void setName(String name) {
            StringBuilder temp = new StringBuilder(name);
            temp.setLength(30);
            name = temp.toString();
            this.name = name;
	}
	
	public void setGenre(String genre) {
            StringBuilder temp = new StringBuilder(genre);
            temp.setLength(15);
            genre = temp.toString();
            this.genre = genre;
	}
	
	public void setConsole(String console) {
            StringBuilder temp = new StringBuilder(console);
            temp.setLength(30);
            console = temp.toString();
            this.console = console;
	}
	
	
	public void setRating(String rating) {
            StringBuilder temp = new StringBuilder(rating);
            temp.setLength(1);
            rating = temp.toString();
            this.rating = rating;
	}
	
	public void setYear(String year) {
            StringBuilder temp = new StringBuilder(year);
            temp.setLength(4);
            year = temp.toString();
            this.year = year;
	}
        
        public void setPrice(String price) {
            StringBuilder temp = new StringBuilder(price);
            temp.setLength(10);
            price = temp.toString();
            this.price = price;
        }
        
	
}
