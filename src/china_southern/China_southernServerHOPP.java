package china_southern;

import dao.DAOImpl;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class China_southernServerHOPP {
	
	public static String Departure;
	public static String Arrive;
	public static String Airline;
	public static String DepartDate;
	public static String temp;
	
	//public static ArrayList<String> dataList;
	
	DAOImpl query = new DAOImpl();
	
	public synchronized ArrayList<String> BookTicket(String str )
	{
		String[] strarray = str.split( "," );
		Departure = strarray[1];
		Arrive = strarray[2];
		String DepartDate = strarray[4];
		String ReturnDate = strarray[5];
		String username = strarray[6];
		String phone = strarray[7];
		String email = strarray[8];
		String creditno = strarray[9];
		ArrayList<String> ticketList = new ArrayList<String>( 
				query.bookTicket( Departure, Arrive, "China_southern", DepartDate, ReturnDate, username, phone, email, creditno) );
		return ticketList;
	}
	
	public ArrayList<String> QueryVacantSeat( String str )
	{
		String[] strarray = str.split( "," );
		Departure = strarray[1];
		Arrive = strarray[2];
		//Airline = strarray[3];
		DepartDate = strarray[4];
		
		//DAOImpl query = new DAOImpl();
		ArrayList<String> seatList = new ArrayList<String>( query.queryTicketNum(Departure, Arrive, "China_southern", DepartDate) );
		return seatList;
	}
	
	public ArrayList<String> QueryPrice( String str )
	{
		String[] strarray = str.split( "," );
		Departure = strarray[1];
		Arrive = strarray[2];
		//Airline = strarray[3];
		
		//DAOImpl query = new DAOImpl();
		//query.queryFlightRate(Departure, Arrive, "China_eastern" );
		ArrayList<String> priceList = new ArrayList<String>( query.queryFlightRate( Departure, Arrive, "China_southern") );
		return priceList;
	}
	
	public ArrayList<String> QueryAirline( String str )
	{
		String[] strarray = str.split( "," );
		Departure = strarray[1];
		Arrive = strarray[2];
		
		//DAOImpl query = new DAOImpl();
		
		//query.queryAirline(Departure, Arrive);
		ArrayList<String> airlineList = new ArrayList<String>( query.queryAirline(Departure, Arrive, "China_southern") );
		return airlineList;
	}

	public ArrayList<String> QueryCity( )
	{
		//DAOImpl query = new DAOImpl();
		ArrayList<String> cityList = new ArrayList<String>( query.queryCity("China_southern") );
		return cityList;
	}
	
	public void exit( Socket incoming )
	{
		try {
			incoming.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
