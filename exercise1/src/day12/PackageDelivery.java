package day12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PackageDelivery {
	
	public static void main(String[] args) {
		Item item = new Item(6720,"phone");
		
		Courier courier = new DeliveryService(60,16);
		
		System.out.println("item : "+item.name+" Wil be delivered by : "+courier.deliverPack(item));
		
		Item item2 = new Item(240,"laptop");
		
		//Courier courier = new DeliveryService(60,16);
		
		System.out.println("item : "+item2.name+" Wil be delivered by : "+courier.deliverPack(item2));
	}

}

interface Courier{
	public LocalDateTime deliverPack(Item item);
}

class DeliveryService implements Courier{
	int travel_speed,workinghours;
	
	
	
	public DeliveryService(int travel_speed, int workinghours) {
		super();
		this.travel_speed = travel_speed;
		this.workinghours = workinghours;
	}

	public static boolean isHoliday(LocalDateTime ldt) {
		Holidays[] h = Holidays.values();
		for(Holidays day:h) {
			if(ldt.getDayOfWeek()== DayOfWeek.SUNDAY || (day.getDate()==ldt.getDayOfMonth() && day.getMonth() == ldt.getMonth())) {
				System.out.println(day);
				return true;
			}
		}
		return false;
	}

	@Override
	public LocalDateTime deliverPack(Item item) {	
		LocalDate date = LocalDate.of(2021, Month.OCTOBER, 1);
		LocalDateTime dispatch = LocalDateTime.of(date, LocalTime.now());
		

		int timetodeliver = (((item.destination_distance))/this.travel_speed);
		LocalDateTime arrival =expectedArrival(dispatch,timetodeliver);
		
		
		return arrival;
	}

	private LocalDateTime expectedArrival(LocalDateTime dispatch, int timetodeliver) {
//		System.out.println(timetodeliver);
		while(timetodeliver>0) {
			timetodeliver-=workinghours;
			dispatch = dispatch.plus(1,ChronoUnit.DAYS);
			System.out.println(dispatch.getDayOfWeek());
			if(isHoliday(dispatch)) {
				dispatch = dispatch.plus(1,ChronoUnit.DAYS);
			}
			
			
		}
		
		return dispatch.plus(timetodeliver,ChronoUnit.HOURS);
		
	}
	
	
}

class Item{
	int destination_distance;
	String name;
	public Item(int destination_distance, String name) {
		super();
		this.destination_distance = destination_distance;
		this.name = name;
	}
	
}

enum Holidays{
	RepublicDay(Month.JANUARY, 26),IndependenceDay(Month.AUGUST, 15),NewYear(Month.JANUARY, 1),GandhiJeyanthi(Month.OCTOBER, 2);
	Month month;
	int date;
	public Month getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}
	private Holidays(Month month, int date) {
		this.month = month;
		this.date = date;
	}
	
	
}
