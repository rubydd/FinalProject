package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Activity {
    private String description;
    private String location; 
    private String date;
    private String attendees;
    private String expense;

    public Activity(String description, String location, String date, String attendees, String expense) {
        this.description = description;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getAttendees() {
        return attendees;
    }

    public String getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Activity: " + description + ", Location: " + location + ", Date: " + date + ", Attendees: " + attendees + ", Expense: " + expense;
    }
}

class Accommodation {
    private String name;
    private String expense;

    public Accommodation(String name, String expense) {
        this.name = name;
        this.expense = expense;
    }

    public String getName() {
        return name;
    }

    public String getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Accommodation: " + name + ", Expense: " + expense;
    }

}

class Destination {
    private String location;
    private String date;
    private List<Activity> activityList = new ArrayList<>();
    private List<Accommodation> accommodationList = new ArrayList<>();

    public Destination(String location, String date) {
        this.location = location;
        this.date = date;
    }

    public boolean containActivity(Activity activity) {
        return activityList.contains(activity);
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void removeActivityRow(int selectRow) {
        activityList.remove(selectRow);
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodationList.add(accommodation);
    }

    public List<Accommodation> getAccommodationList() {
        return accommodationList;
    }

    public void removeAccommodationRow(int selectRow) {
        accommodationList.remove(selectRow);
    }

    @Override
    public String toString() {
        return "Destination: " + location + ", Date: " + date;
    }   

}

public class DataBase {
    private static DataBase instance;
    private List<Destination> destinationList = new ArrayList<>();

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public boolean containsLocation(String location) {
        for (Destination destination : destinationList) {
            if (destination.getLocation().equalsIgnoreCase(location)) {
                return true;
            }
        }
        return false;
    }

    public boolean addDestination(Destination destination) {
        if (containsLocation(destination.getLocation())) return false;
        destinationList.add(destination);
        return true;
    }

    public boolean addDestination(String location, String date) {
        return addDestination(new Destination(location, date));
    }

    public List<Destination> getDestinations() {
        return destinationList;
    }

    public void removeRow(int selectRow) {
        destinationList.remove(selectRow);
    }

    public Destination getSelectedRow(int selectRow) {
        return destinationList.get(selectRow);
    }

    public boolean addAccommodationToDestination(Destination destination, Accommodation accommodation) {
        if (destination == null) return false;
        destination.addAccommodation(accommodation);
        return true;
    }

    public boolean updateDestination(Destination destination) {
        for (int i = 0; i < destinationList.size(); i++) {
            if (destinationList.get(i).getLocation().equalsIgnoreCase(destination.getLocation())) {
                destinationList.set(i, destination); // Update the destination
                return true;
            }
        }
        return false;
    }

    public boolean addActivityToDestination(Destination destination, Activity activity) {
        if (destination == null) return false;
        destination.addActivity(activity);
        return true;
    }

    public boolean addActivityToDestination(Destination destination, String description, String location, String date, String attendees, String expense) {
        Activity activity = new Activity(description, location, date, attendees, expense);
        return addActivityToDestination(destination, activity);
    }
}

