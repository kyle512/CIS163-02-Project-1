package project1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**********************************************************************
 *@author Kyle Scott  and Joseph Lentine
 * 1/25/22
 *
 *An API that allows users to create a count-down timer for dates
 * that are very fat in the future
 *
 **********************************************************************/

public class GeoCountDownTimer {

	/**
	 * ksdjgsidj gsdg sdfg  sdfg
	 */
	private int month;

	private int year;

	private int day;

	private List<String> months = Arrays.asList("", "January", "Febuary", "March", "April", "May"
			, "June", "July", "August", "September", "October", "November", "December");

	private static final int MIN_YEAR = 2022;

	/******************************************************************
	 * Default constructor that sets the GeoCountDownTimer to zero
	 */
	private GeoCountDownTimer() {
		this.month = 1;
		this.year = MIN_YEAR;
		this.day = 1;
	}

	/******************************************************************
	 * A constructor that initializes the instance variables with the
	 * provided values
	 *
	 * @param year the year that is applied to the object
	 * @param month the month that is applied to the object
	 * @param day the day that is applied to the object
	 *
	 * @throws IllegalArgumentException when date is out of range
	 */
	public GeoCountDownTimer(int year, int month, int day) {
		this.month = month;
		this.day = day;
		this.year = year;

		if (!isValidDate())
			throw new IllegalArgumentException();
	}

	/******************************************************************
	 *A constructor that initializes the instance variables with the
	 *other GeoCountDownTimer parameter.
	 *
	 * @param other GeoCountDownTimer broken up and applied
	 *           to the  object
	 *
	 * @throws IllegalArgumentException when date is out of range
	 */
	public GeoCountDownTimer(GeoCountDownTimer other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}
		this.month = other.getMonth();
		this.day = other.getDay();
		this.year = other.getYear();

		if (!isValidDate()) {
			month = 1;
			day = 1;
			year = MIN_YEAR;
			throw new IllegalArgumentException();
		}
	}

	/******************************************************************
	 * A constructor that accepts a string as a parameter with the
	 * following format: “5/10/2119” where 5 indicates the month, 10
	 * indicates the day,  and 2119 indicates the year.
	 *
	 * @param geoDate date in the form of a string that is
	 *             broken up and passed to the object
	 *
	 * @throws IllegalArgumentException when date is out of range
	 * 								or when null is passed in
	 */
	public GeoCountDownTimer(String geoDate) {
		if (geoDate == null) {
			throw new IllegalArgumentException();
		}
		String[] strings = geoDate.split("/");
		if (strings.length == 3) {
			this.month = Integer.parseInt(strings[0]);
			this.day = Integer.parseInt(strings[1]);
			this.year = Integer.parseInt(strings[2]);
		} else {
			throw new IllegalArgumentException();
		}
		if (!isValidDate()) {
			throw new IllegalArgumentException();
		}
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}

	/******************************************************************
	 * Checks to see if current year is leap year
	 *
	 * @return true if it is a leapYear, false if not
	 */
	public boolean isLeapYear() {
		if ((this.getYear() % 4 == 0) && (this.getYear() % 100 != 100))
			return true;
		else
			return false;
	}

	/******************************************************************
	 * Checks if current date is a valid date
	 *
	 * @return true if date is in range, false if not
	 */
	public boolean isValidDate() {
		if (this.getMonth() == 1 || this.getMonth() == 3 || this.getMonth() == 5 || this.getMonth() == 7 ||
				this.getMonth() == 8 || this.getMonth() == 10 || this.getMonth() == 12) {
			if (this.day > 31 || this.day < 1) {
				return false;
			}
		}
		if (this.getMonth() == 4 || this.getMonth() == 6 || this.getMonth() == 9 || this.getMonth() == 11) {
			if (this.day > 30 || this.day < 1) {
				return false;
			}
		}


		if (this.getMonth() == 2)
			if (isLeapYear()) {
				if (this.day > 29 || this.day < 1)
					return false;
			} else if (this.day > 28 || this.day < 1)
				return false;


		if (this.getYear() < MIN_YEAR) {
			return false;
		}
		if (this.getMonth() > 12 || this.getMonth() < 1) {
			return false;
		}
		return true;
	}

	/******************************************************************
	 * A method that returns true if “this” GeoCountDownTimer object
	 * is exactly the same as the other object
	 *
	 * @param other object compared to current date
	 *
	 * @return true if other and current date are equal, false if not
	 *
	 * @throws IllegalArgumentException when null is passed in
	 */
	public boolean equals(Object other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}

		// khbjhvbjkuh  kuhjhbjhb
		GeoCountDownTimer obj = (GeoCountDownTimer) other;
		if (this.day != obj.getDay()) {
			return false;
		}
		if (this.month != obj.getMonth()) {
			return false;
		}
		if (this.year != obj.getYear()) {
			return false;
		}
		return true;
	}

	/******************************************************************
	 *A method that returns 1 if “this” GeoCountDownTimer object is
	 * greater than the other GeoCountDownTimer object; returns -1 if
	 * the “this” GeoCountDownTimer object is less than the other
	 * GeoCountDownTimer; returns 0 if the “this” GeoCountDownTimer
	 * object is equal to the other GeoCountDownTimer object
	 *
	 * @param other GeoCountDownTimer object compared to current date
	 *
	 * @return 0 if current date and other are the same
	 * 			1 if current date is greater than other
	 * 		   -1 if current date is less than other
	 */
	public int compareTo(GeoCountDownTimer other) {
		if (this.year == other.getYear()) {
			if (this.month == other.getMonth()) {
				if (this.day == other.getDay()) {
					return 0;
				} else if (this.day > other.getDay()) {
					return 1;
				} else {
					return -1;
				}
			} else if (this.month > other.getMonth()) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.year > other.getYear()) {
			return 1;
		} else {
			return -1;
		}
	}

	/******************************************************************
	 * A method that subtracts the number of days from the “this”
	 * GeoCountDownTimer object  This will adjust the timer date down
	 * the number of days
	 *
	 * @param days number of days to decrement date by
	 *
	 * @throws IllegalArgumentException when date is out of range
	 * 							or given days is invalid number
	 */
	public void dec(int days) {
		if (days < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < days; i++) {
			dec();
		}
	}

	/******************************************************************
	 * A method that subtracts 1 day from the “this”
	 * GeoCountDownTimer object
	 *
	 * @throws IllegalArgumentException if date is out of range
	 */
	public void dec() {
		this.day = this.getDay() - 1;
		if (this.day < 1) {
			if (this.getMonth() == 5 || this.getMonth() == 7
					|| this.getMonth() == 10 || this.getMonth() == 12) {
				this.day = 30;
				this.month = this.getMonth() - 1;
			} else if (this.getMonth() == 4 || this.getMonth() == 6 || this.getMonth() == 9 || this.getMonth() == 11 ||
					this.getMonth() == 2 || this.getMonth() == 8) {
				this.day = 31;
				this.month = this.getMonth() - 1;
			} else if (this.getMonth() == 1) {
				this.year = this.getYear() - 1;
				this.month = 12;
				this.day = 31;
			} else {
				if (isLeapYear()) {
					this.day = 29;
					this.month = this.getMonth() - 1;
				} else {
					this.day = 28;
					this.month = this.getMonth() - 1;
				}
			}
		}
		if (!isValidDate()) {
			throw new IllegalArgumentException();
		}
	}

	/******************************************************************
	 * returns the maximum days for the current month
	 *
	 * @return The maximum days for the current month
	 */
	public int getMaxDays() {
		int maxDays;
		if (this.getMonth() == 1 || this.getMonth() == 3 || this.getMonth() == 5 || this.getMonth() == 7 ||
				this.getMonth() == 8 || this.getMonth() == 10 || this.getMonth() == 12) {
			maxDays = 31;
		} else if (this.getMonth() == 4 || this.getMonth() == 6 || this.getMonth() == 9 || this.getMonth() == 11) {
			maxDays = 30;
		} else {
			if (isLeapYear()) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
		}
		return maxDays;
	}

	/******************************************************************
	 * A method that adds the number of days to the “this”
	 * GeoCountDownTimer object  This will adjust the timer date up
	 * the number of days
	 *
	 * @param days number of days to increase current date by
	 *
	 * @throws IllegalArgumentException when given days is invalid
	 */
	public void inc(int days) {
		if (days < 0) {
			throw new IllegalArgumentException();
		}
		this.day = this.getDay() + days;
		while (this.getDay() > getMaxDays()) {
			if (this.getMonth() == 12) {
				this.day = this.day - getMaxDays();
				this.year = this.getYear() + 1;
				this.month = 1;
			} else {
				this.day = this.day - getMaxDays();
				this.month = this.getMonth() + 1;
			}
		}
	}

	/******************************************************************
	 * A method that adds 1 day from the “this”
	 * GeoCountDownTimer  object
	 */
	public void inc() {
		inc(1);
	}

	/******************************************************************
	 *Method that returns a string that represents a GeoCountDownTimer
	 * with the following format:  “month day, year”
	 *
	 * @return String version of current date
	 */
	public String toString() {
		return (months.get(this.month) + " " + this.day + "," + this.year);
	}

	/******************************************************************
	 * Method that returns a string that represents a GeoCountDownTimer
	 * with the following format:  “month/day/year”
	 *
	 * @return String version of the current date
	 */
	public String toDateString() {
		return (this.month + "/" + this.day + "/" + this.year);
	}

}