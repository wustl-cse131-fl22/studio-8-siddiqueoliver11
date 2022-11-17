package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Date {

	private String month;
	private int day;
	private int year;
	private boolean isHoliday;

	
	/**
	 * @param month    the month that this date is in.
	 * @param day      the day (1-31) of the month.
	 * @param year     the year that this date is in.
	 * @param isHoliday whether or not this day is a holiday.
	 *                 true if holiday, false otherwise.
	 */
	public Date (String month, int day, int year, boolean isHoliday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.isHoliday = isHoliday;
	}
	
	public String toString() {
		String result =  month + " " + day + ", " + year;
		if (isHoliday) {
			result = result + "\nThis is a holiday!";
		} else {
			result = result + " \nThis is not a holiday.";
		}
		return result;
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && Objects.equals(month, other.month) && year == other.year;
	}

	public static void main(String[] args) {
    	
    	Date d1=new Date("December",25,2008,true);
    	System.out.println(d1);
    	Date d2 = new Date("December", 25, 2008, false);
    	Date d3 = new Date("January", 3, 2006, false);
    	Date d4 = new Date("March", 21, 2016, true);
    	Date d5 = new Date("February", 5, 2011, false);
    	System.out.println(d1.equals(d2));
    	LinkedList<Date> list  = new LinkedList<Date>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		list.add(d5);
		list.add(d5);
		System.out.println(list);
		
		HashSet<Date> set = new HashSet<Date>();
		set.add(d1);
		set.add(d5);
		set.add(d1);
		System.out.println(set);
    }

}
