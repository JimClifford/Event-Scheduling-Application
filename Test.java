import java.util.Hashtable;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Test {

  public static void main(String[] args) {
    // Test constructor with all parameters
    Event event1 = new Event("Meeting", "Discuss project", 2023, 12, 1, 14, 30, Event.frequency.WEEKLY);
    System.out.println("Event 1:\n" + event1);

    // Test constructor with minimal parameters
    Event event2 = new Event("Birthday Party", "Celebrate", 2023, 12, 15);
    event2.setStartTimeOfEvent(18, 0);
    event2.setEndTimeOfEvent(22, 0);
    event2.setLocation("Friend's House");
    event2.setRecurrence(Event.frequency.YEARLY);
    event2.setReminder(LocalDate.of(2023, 12, 14), LocalTime.of(18, 0));
    System.out.println("Event 2:\n" + event2);

    // Test setters and getters
    event1.setTitle("Updated Meeting");
    event1.setDescription("Discuss new project details");
    event1.setDate(2023, 12, 8);
    event1.setStartTimeOfEvent(15, 0);
    event1.setEndTimeOfEvent(16, 30);
    event1.setLocation("Conference Room");
    event1.setRecurrence(Event.frequency.DAILY);
    event1.setReminder(LocalDate.of(2023, 12, 7), LocalTime.of(15, 0));

    System.out.println("Updated Event 1:\n" + event1);

    LocalDate today = LocalDate.now();
    LocalTime timeNow = LocalTime.now();

    System.out.println("The Date Is: " + today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear());
    System.out.println("");
    System.out.println("The Time Is: " + timeNow.getHour() + ":" + timeNow.getMinute());

    Calendar calendar1 = new Calendar();

    Event event3 = new Event("AI Final Project discussion", "This is event 3", 2020, 10, 20);
    event3.setStartTimeOfEvent(15, 30);
    event3.setEndTimeOfEvent(17, 30);
    event3.setLocation("Computer Lab");
    event3.setDescription("This meeting is for us to dicuss the use of the CNN architecure in our model");

    Event event4 = new Event("DSA Revision", "This is event 4", 2020, 10, 20);
    event4.setStartTimeOfEvent(15, 30);
    event4.setEndTimeOfEvent(17, 30);
    event4.setLocation("Computer Lab");
    event4.setDescription("This meeting is for us to discuss hasstables");

    Event event5 = new Event("Data Structures Project Discussion", "This is event 1", 2020, 11, 11);
    event5.setStartTimeOfEvent(11, 00);
    event5.setEndTimeOfEvent(13, 30);
    event5.setLocation("Hall 2C");
    event5.setDescription("Meeting to have final discussion about project");

    Event event6 = new Event("Leadership Class", "A discussion on African leadership thought", 2020, 9, 11);
    event6.setStartTimeOfEvent(13, 30);
    event6.setEndTimeOfEvent(14, 30);
    event6.setLocation("Computer Lab");
    event6.setDescription("This meeting is for Pan Africanist");

    calendar1.addEvent(event1.getDate(), event1);
    calendar1.addEvent(event2.getDate(), event2);
    calendar1.addEvent(event3.getDate(), event3);
    calendar1.addEvent(event4.getDate(), event4);
    calendar1.addEvent(event5.getDate(), event5);
    calendar1.addEvent(event6.getDate(), event6);

    calendar1.showEvents(event4.getDate());

    System.out.println(calendar1.monthlyView(10));


    calendar1.modifyEvent(event6);
  }

}