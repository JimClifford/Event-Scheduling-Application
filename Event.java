import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
  private String title;
  private String description;
  private LocalDate date;
  private LocalTime startTimeOfEvent;
  private LocalTime endTimeOfEvent;
  private String location;
  private boolean isRecurring; // Indicates whether the event is recurring.
  private boolean hasReminder; // Indicates whether the event has a reminder.
  private LocalDate reminderDate; // The date of the reminder.
  private LocalTime reminderTime; // Time of reminder

  public enum frequency {
    YEARLY, WEEKLY, DAILY, CUSTOM;
  }

  private frequency recurrence; // The frequency of recurrence for the event.

  // Constructors
  public Event(String title, String description, int year, int month, int day, int hour, int minutes,
      frequency recurring) {
    this.title = title;
    this.description = description;
    this.date = LocalDate.of(year, month, day);
    this.startTimeOfEvent = LocalTime.of(hour, minutes);
    this.reminderTime = startTimeOfEvent.minusMinutes(60); // automatic reminder one hour before
    if (reminderTime.getHour() < 23) {
      this.reminderDate = date;
    } else
      this.reminderDate = date.minusDays(1); // case the event is in the first hour of day, and reminder is in / //
                                             // preceeding day
    this.hasReminder = true;
    this.isRecurring = true;
    this.recurrence = recurring;
  }

  // Constructors
  public Event(String title, String description, int year, int month, int day) {
    this(title, description, year, month, day, 0, 0, null);
  }

  // Setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDate(int year, int month, int day) {
    this.date = LocalDate.of(year, month, day);
  }

  public void setStartTimeOfEvent(int hour, int minutes) {
    this.startTimeOfEvent = LocalTime.of(hour, minutes);
  }

  public void setEndTimeOfEvent(int hour, int minutes) {
    this.endTimeOfEvent = LocalTime.of(hour, minutes);
  }

  public void setLocation(String loc) {
    location = loc;
  }

  public void setReminder(LocalDate date, LocalTime time) {
    this.reminderDate = date;
    this.reminderTime = time;
    hasReminder = true;
  }

  public void setRecurrence(frequency r) {
    this.recurrence = r;
  }

  // Getters
  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getStartTimeOfEvent() {
    return startTimeOfEvent;
  }

  public LocalTime getEndTimeOfEvent() {
    return endTimeOfEvent;
  }

  public String getLocation() {
    return location;
  }

  public String toString() {
    return "Event Title: " + this.title + "\n" +
        "Event Description: " + this.description + "\n" +
        "Event Date: " + this.date + "\n" +
        "Event Starting Time: " + this.startTimeOfEvent + "\n" +
        "Ending Time: " + this.endTimeOfEvent + "\n" +
        "Location: " + this.location + "\n";
  }

}