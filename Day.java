import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day {

  private PriorityQueue<Event> eventList;
  private LocalDate date;

  public Day(LocalDate date) {
    // Using a custom comparator to handle events with the same start time
    this.eventList = new PriorityQueue<>(Comparator
        .<Event, LocalTime>comparing(Event::getStartTimeOfEvent)
        .thenComparing(Event::getEndTimeOfEvent));
    this.date = date;
  }

  public void addEvent(Event ev) throws ConflictingEventsException, InvalidTimeRangeException {
    for (Event event : eventList) {
      if (ev.getStartTimeOfEvent().isBefore(event.getEndTimeOfEvent()) &&
          ev.getEndTimeOfEvent().isAfter(event.getStartTimeOfEvent())) {
        throw new ConflictingEventsException(
            "Conflicting times, already have an event overlapping with the specified time.");
      }
    }

    if (ev.getStartTimeOfEvent().isBefore(LocalTime.MIN) || ev.getEndTimeOfEvent().isBefore(ev.getStartTimeOfEvent())) {
      throw new InvalidTimeRangeException("Invalid time range. Please check the start and end times of the event.");
    }
    this.eventList.add(ev);
  }

  public boolean removeEvent(Event ev) {
    return eventList.remove(ev);
  }

  public void showEvents() {
    for (Event e : this.eventList) {
      System.out.println(e.toString());
    }
  }

  public Event getEvent(String title) {
    for (Event event : eventList) {
      if (event.getTitle().equals(title)) {
        return event;
      }
    }
    return null; // Event with the specified title not found
  }

  public PriorityQueue<Event> getPriorityQueue() {
    return this.eventList;
  }

  public String listEvents() {
    StringBuilder events = new StringBuilder();
    for (Event e : this.eventList) {
      events.append(e.toString()).append(" \n");
    }
    return events.toString();
  }

  public LocalDate getDate() {
    return date;
  }
}

// Custom exception for conflicting events
class ConflictingEventsException extends Exception {
  public ConflictingEventsException(String message) {
    super(message);
  }
}

// Custom exception for invalid time range
class InvalidTimeRangeException extends Exception {
  public InvalidTimeRangeException(String message) {
    super(message);
  }
}