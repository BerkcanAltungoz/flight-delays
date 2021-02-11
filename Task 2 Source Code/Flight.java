public class Flight implements Comparable<Flight>{
    private String year, month, day, dayOfWeek, airline, flightNumber, tailNumber, originAirport, destinationAirport, scheduledDeparture, departureTime;
    private String departureDelay, taxiOut, wheelsOff, scheduledTime, elapsedTime, airTime, distance, wheelsOn, taxiIn, scheduledArrival;
    private String arrivalTime, arrivalDelay, diverted, cancelled;
    private int noOfEntry;



    public Flight(int noOfEntry,String year, String month, String day, String dayOfWeek, String airline, String flightNumber, String tailNumber, String originAirport, String destinationAirport, String scheludedDeparture, String departureTime, String departureDelay, String taxiOut, String wheelsOff, String scheludedTime, String elapsedTime, String airTime, String distance, String wheelsOn, String taxiIn, String scheludedArrival, String arrivalTime, String arrivalDelay, String diverted, String cancelled) {
        this.noOfEntry = noOfEntry;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.tailNumber = tailNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.scheduledDeparture = scheludedDeparture;
        this.departureTime = departureTime;
        this.departureDelay = departureDelay;
        this.taxiOut = taxiOut;
        this.wheelsOff = wheelsOff;
        this.scheduledTime = scheludedTime;
        this.elapsedTime = elapsedTime;
        this.airTime = airTime;
        this.distance = distance;
        this.wheelsOn = wheelsOn;
        this.taxiIn = taxiIn;
        this.scheduledArrival = scheludedArrival;
        this.arrivalTime = arrivalTime;
        this.arrivalDelay = arrivalDelay;
        this.diverted = diverted;
        this.cancelled = cancelled;
    }
    public Flight(){

    }
    public int getNoOfEntry(){
        return noOfEntry;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getAirline() {
        return airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDepartureDelay() {
        return departureDelay;
    }

    public String getTaxiOut() {
        return taxiOut;
    }

    public String getWheelsOff() {
        return wheelsOff;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getAirTime() {
        return airTime;
    }

    public String getDistance() {
        return distance;
    }

    public String getWheelsOn() {
        return wheelsOn;
    }

    public String getTaxiIn() {
        return taxiIn;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalDelay() {
        return arrivalDelay;
    }

    public String getDiverted() {
        return diverted;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setNoOfEntry(int noOfEntry){
        this.noOfEntry = noOfEntry;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setScheduledDeparture(String scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDepartureDelay(String departureDelay) {
        this.departureDelay = departureDelay;
    }

    public void setTaxiOut(String taxiOut) {
        this.taxiOut = taxiOut;
    }

    public void setWheelsOff(String wheelsOff) {
        this.wheelsOff = wheelsOff;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setWheelsOn(String wheelsOn) {
        this.wheelsOn = wheelsOn;
    }

    public void setTaxiIn(String taxiIn) {
        this.taxiIn = taxiIn;
    }

    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setArrivalDelay(String arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public void setDiverted(String diverted) {
        this.diverted = diverted;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public int compareTo(Flight f){
        return (Integer.parseInt(departureDelay) - Integer.parseInt(f.getDepartureDelay()));
    }
}


