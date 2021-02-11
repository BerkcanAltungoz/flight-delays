import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class MainClass {




    private static final String STRING_ARRAY_SAMPLE = "D:\\Users\\Berkcan\\Desktop\\Resources\\1.Homeworks\\Data Structures\\0.Term Project\\Generated Flights\\";
    private static final String SAMPLE_CSV_FILE_PATH = "D:\\Users\\Berkcan\\Desktop\\Resources\\1.Homeworks\\Data Structures\\0.Term Project\\Flight Delays\\flights.csv";

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
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

        String filename;
        int count = 0;
        while (count < 5) {
            count++;
            Flight flight = myUserIterator.next();
            System.out.println("Airline: " + flight.getAirline());
            System.out.println("Flight Number: " + flight.getFlightNumber());
            filename = STRING_ARRAY_SAMPLE + flight.getAirline() + "-" + flight.getFlightNumber() + ".csv";
            Writer writer = Files.newBufferedWriter(Paths.get(filename));
            System.out.println("CSV File Created Successfully");
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] headerRecord = {"AIRLINE", "FLIGHT_NUMBER"};
            String[] airlineFlightCode = {flight.getAirline(),flight.getFlightNumber()};
            csvWriter.writeNext(headerRecord);
            csvWriter.writeNext(airlineFlightCode);
            csvWriter.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Running Time: " + (endTime - startTime) + "ms");
    }
}
