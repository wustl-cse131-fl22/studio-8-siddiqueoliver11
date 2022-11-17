package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Time {

	private int hour;
	private int minute;
	private boolean is24Hr;

	/**
	 * @param hour     the hour.
	 * @param minute   the minute of the time.
	 * @param is24Hr   whether or not the time is shown in 24 hr format.
	 *                 true if 24 hr, false is 12 hr.
	 */
	public Time(int hour, int minute, boolean is24Hr) {
		this.hour = hour;
		this.minute = minute;
		this.is24Hr = is24Hr;
	}

	public String toString() {
		String result = "";
		if (is24Hr == true) {
			result = hour + ":" + minute;
		}	else if (is24Hr == false && hour > 12) {
			result = hour - 12 + ":" + minute + " PM";
		} else if (is24Hr == false && hour <= 12){
			result = hour + ":" + minute + " AM";
		}
		return result;
	}

	public static void main(String[] args) {
  
		Time t1= new Time(13,27,false);
		System.out.println(t1);
		
		Time t2 = new Time(23, 11, true);
		Time t3 = new Time(11, 11, false);
		Time t4 = new Time(12,16,false);
		Time t5 = new Time(14,27,true);
		System.out.println(t1.equals(t2));
		LinkedList<Time> list  = new LinkedList<Time>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t5);
		System.out.println(list);
		
		HashSet<Time> set = new HashSet<Time>();
		set.add(t1);
		set.add(t2);
		set.add(t1);
		System.out.println(set);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, minute);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && minute == other.minute;
	}

}