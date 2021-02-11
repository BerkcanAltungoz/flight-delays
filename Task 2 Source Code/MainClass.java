import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class MainClass {


    private static final String SAMPLE_CSV_FILE_PATH = "D:\\Users\\Berkcan\\Desktop\\Resources\\1.Homeworks\\Data Structures\\0.Term Project\\Flight Delays\\flights.csv";

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        //Create CSVReader
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));

        ColumnPositionMappingStrategy<Flight> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Flight.class);
        String[] memberFieldsToBindTo = {"year", "month","day", "dayOfWeek", "airline", "flightNumber", "tailNumber", "originAirport", "destinationAirport", "scheduledDeparture", "departureTime", "departureDelay", "taxiOut", "wheelsOff", "scheduledTime", "elapsedTime", "airTime", "distance","wheelsOn", "taxiIn", "scheduledArrival", "arrivalTime", "arrivalDelay", "diverted", "cancelled"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean<Flight> csvToBean = new CsvToBeanBuilder<Flight>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Flight> myUserIterator = csvToBean.iterator();
        //end

        //User Inputs Dates
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        try{
            System.out.print("Please Enter The Start Date Formatted As 'DD-MM-YYYY': ");
            String date1 = scan.nextLine();
            Date startDate = formatter.parse(date1);


            System.out.print("Please Enter The End Date Formatted As 'DD-MM-YYYY': ");
            String date2 = scan.nextLine();
            Date endDate = formatter.parse(date2);

            System.out.println("Please Enter An Airline Code From The Instructions Below");
            System.out.println("Enter UA for United Air Lines Inc.");
            System.out.println("Enter AA for American Airlines Inc.");
            System.out.println("Enter US for US Airways Inc.");
            System.out.println("Enter F9 for Frontier Airlines Inc.");
            System.out.println("Enter B6 for JetBlue Airways");
            System.out.println("Enter OO for Skywest Airlines Inc.");
            System.out.println("Enter AS for Alaska Airlines Inc.");
            System.out.println("Enter NK for Spirit Air Lines");
            System.out.println("Enter WN for Southwest Airlines Co.");
            System.out.println("Enter DL for Delta Air Lines Inc.");
            System.out.println("Enter EV for Atlantic Southeast Airlines");
            System.out.println("Enter HA for Hawaiian Airlines Inc.");
            System.out.println("Enter MQ for American Eagle Airlines Inc.");
            System.out.println("Enter VX for Virgin America");
            System.out.print("Enter Your Code: ");
            String airlineCode = scan.nextLine();
            System.out.println("Entered Start Date: " + startDate);
            System.out.println("Entered End Date: " + endDate);
            System.out.println("Entered Airline Code: " + airlineCode);



            int count = 0;
            int minDepartureDelay = Integer.MAX_VALUE;
            int maxDepartureDelay = Integer.MIN_VALUE;
            int averageDepartureDelay = 0;
            int totalDepartureDelay = 0;

            String dayOfFlight;
            String monthOfFlight;
            String yearOfFlight;
            String formattedDateOfFlight = "1-1-2014";
            ArrayList<Flight> arrayOfFlight = new ArrayList<>();


            while (myUserIterator.hasNext()) {
                count++;
                Flight flight = myUserIterator.next();
                dayOfFlight = flight.getDay();
                monthOfFlight = flight.getMonth();
                yearOfFlight = flight.getYear();
                formattedDateOfFlight = dayOfFlight + "-" + monthOfFlight + "-" + yearOfFlight;
                try {
                    Date dateOfFlight = formatter.parse(formattedDateOfFlight);
                    if(!startDate.after(dateOfFlight) && !endDate.before(dateOfFlight) && flight.getAirline().equals(airlineCode)){
                        if(flight.getDepartureDelay() != null && !flight.getDepartureDelay().trim().equals("")  ){
                            flight.setNoOfEntry(count);
                            arrayOfFlight.add(flight);
                            if(Integer.parseInt(flight.getDepartureDelay()) > maxDepartureDelay){
                                maxDepartureDelay = Integer.parseInt(flight.getDepartureDelay());
                            }
                            if(Integer.parseInt(flight.getDepartureDelay()) < minDepartureDelay){
                                minDepartureDelay = Integer.parseInt(flight.getDepartureDelay());
                            }
                            totalDepartureDelay += Integer.parseInt(flight.getDepartureDelay());
                        }
                        else{
                            continue;
                        }

                    }
                    else if(dateOfFlight.before(startDate)){
                        System.out.println("Continued While Loop");
                        continue;
                    }
                    else if(endDate.before(dateOfFlight)){
                        System.out.println("Broke While Loop");
                        break;
                    }
                }
                catch(ParseException e){
                    System.out.println("Invalid Date Format");
                    e.printStackTrace();
                }
            }
            Collections.sort(arrayOfFlight);
            Collections.reverse(arrayOfFlight);
            for(int i = 0; i < arrayOfFlight.size() ;i++){
                System.out.println("Origin Airport: " + arrayOfFlight.get(i).getOriginAirport());
                System.out.println("Destination Airport: " + arrayOfFlight.get(i).getDestinationAirport());
                System.out.println("Departure Delay: " + arrayOfFlight.get(i).getDepartureDelay());
                System.out.println("Number Of Entry: " + arrayOfFlight.get(i).getNoOfEntry());
                System.out.println("---------------------------");
            }
            averageDepartureDelay = totalDepartureDelay / count;
            System.out.println("Minimum Departure Delay: " + minDepartureDelay);
            System.out.println("Maximum Departure Delay: " + maxDepartureDelay);
            System.out.println("Average Departure Delay: " + averageDepartureDelay);
            System.out.println("---------------------------");

        }
        catch(ParseException e){
            System.out.println("Invalid Date Format");
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Running Time: " + (endTime - startTime) + "ms");
    }

}