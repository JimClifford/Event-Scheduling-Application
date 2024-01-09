import java.util.Hashtable;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

/*
This class creates the calendar object that will allow a user to:
 - create events with a title, description, date, and time.
 - edit or delete events after they are created.
 - display all events for a single day, using a list or stack to manage
daily events.
- quickly access events on any given day within
a month.
- receive a warning on conflicts about event
scheduling conflicts.
*/

public class Calendar {

  public Hashtable<LocalDate, Day> dates; // hashtable to keep all dates with events

  // Constructor
  public Calendar() {
    dates = new Hashtable<LocalDate, Day>();
  }

  // Method to add an event to the calendar
  public void addEvent(LocalDate date, Event event) {
    if (dates.containsKey(date)) {
      try {
        dates.get(date).addEvent(event);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    } else {
      Day day = new Day(date);
      try {
        day.addEvent(event);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
      dates.put(date, day);
    }
  }

  // Method to edit an event in the calendar
  public void modifyEvent(Event event) {

    Scanner input = new Scanner(System.in);
    System.out.println("What would you like to modify?");
    System.out.println("1. Date");
    System.out.println("2. Time");
    System.out.println("3. Name");
    System.out.println("4. Description");
    System.out.println("5. Location");
    int response = input.nextInt();

    if (response == 1) {
      System.out.println("What is the new date?");
      System.out.println("Enter day:");
      int day = input.nextInt();
      System.out.println("Enter Month:");
      int month = input.nextInt();
      System.out.println("Enter Year:");
      int year = input.nextInt();
      event.setDate(day, month, year);

    } else if (response == 2) {
      System.out.println("What is the new start time?");
      System.out.println("Enter hour:");
      int hour = input.nextInt();
      System.out.println("Enter minute:");
      int minute = input.nextInt();
      event.setStartTimeOfEvent(hour, minute);

      System.out.println("What is the new end time?");
      System.out.println("Enter hour:");
      int hour2 = input.nextInt();
      System.out.println("Enter minute:");
      int minute2 = input.nextInt();
      event.setEndTimeOfEvent(hour2, minute2);
    }

    else if (response == 3) {
      System.out.println("What is the new Title?");
      String name = input.nextLine();
      event.setTitle(name);
    }

    else if (response == 4) {
      System.out.println("What is the new description?");
      String description = input.nextLine();
      event.setDescription(description);
    }

    else if (response == 5) {
      System.out.println("What is the new location?");
      String location = input.nextLine();
      event.setLocation(location);

    }
    //input.close();
  }

  // for use in the CalendarGUI class
  public Hashtable<LocalDate, Day> getHashTable() {
    return this.dates;
  }

  // Method to show all events on a particular day
  public void showEvents(LocalDate date) {
    dates.get(date).showEvents();
  }

  public String reminders() {
    String reminder = "";
    LocalDate today = LocalDate.now();
    for (LocalDate date : dates.keySet()) {
      if (date.isEqual(today)) {
        reminder += dates.get(date).listEvents();
      }
    }
    return reminder;
  }

  public String monthlyView(int month) {
    String mView = "";
    for (Day day : dates.values()) {
      if (day.getDate().getMonthValue() == month) {
        mView += day.listEvents();
      }
    }
    return mView;
  }

  public void deleteEvent(Event e) {
    dates.get(e.getDate()).removeEvent(e);
  }

}