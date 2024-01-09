import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class CalendarGUI extends JFrame {
    private Calendar calendar;
    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField locationField;


    public CalendarGUI() {
        calendar = new Calendar();

        // GUI setup
        setTitle("Event Scheduler and Calendar");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Creating GUI components
        titleField = new JTextField();
        descriptionField = new JTextField();
        yearField = new JTextField();
        monthField = new JTextField();
        dayField = new JTextField();
        startTimeField = new JTextField();
        endTimeField = new JTextField();
        locationField = new JTextField();


        JButton addEventButton = new JButton("Add Event");
        JButton showEventsButton = new JButton("Events Daily View");
        JButton setEventReminderButton = new JButton("Reminders");
        JButton showMonthlyEventsButton = new JButton("Events Monthly View");

        // Adding components to the frame
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Description:"));
        add(descriptionField);
        add(new JLabel("Year (YYYY):"));
        add(yearField);
        add(new JLabel("Month (1-12):"));
        add(monthField);
        add(new JLabel("Day (DD):"));
        add(dayField);
        add(new JLabel("Start Time (HH:MM):"));
        add(startTimeField);
        add(new JLabel("End Time (HH:MM):"));
        add(endTimeField);
        add(new JLabel("Location:"));
        add(locationField);
        add(addEventButton);
        add(showEventsButton);
        add(setEventReminderButton);
        add(showMonthlyEventsButton);

        // Event listeners
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });

        showEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvents();
            }
        });

        setEventReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEventReminder();
            }
        });

        showMonthlyEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMonthlyEvents();
            }
        });

        // Displays the frame
        setVisible(true);
    }

    private void addEvent() {
        try {
            String title = titleField.getText();
            String description = descriptionField.getText();
            int year = Integer.parseInt(yearField.getText());
            int month = Integer.parseInt(monthField.getText());
            int day = Integer.parseInt(dayField.getText());
            LocalTime startTime = LocalTime.parse(startTimeField.getText());
            LocalTime endTime = LocalTime.parse(endTimeField.getText());
            String location = locationField.getText();

            // Creating an Event object using the provided data
            Event event = new Event(title, description, year, month, day);
            event.setStartTimeOfEvent(startTime.getHour(), startTime.getMinute());
            event.setEndTimeOfEvent(endTime.getHour(), endTime.getMinute());
            event.setLocation(location);

            // Adding the event to the calendar
            calendar.addEvent(event.getDate(), event);

            // Clearing text fields after adding an event
            clearTextFields();

            JOptionPane.showMessageDialog(this, "Event added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Please fill in all fields.");
        }
    }

    private void showEvents() {
        try {
          // Prompting the user for a date
          String dateString = JOptionPane.showInputDialog(this, "Enter the date (YYYY-MM-DD):");

          // Checking if the user clicked Cancel or entered an empty string
          if (dateString == null || dateString.trim().isEmpty()) {
            return; // Exiting method if no date is provided
          }

          // Parsing the user input into a LocalDate
          LocalDate date = LocalDate.parse(dateString);

          // Showing events for the specified date
          JOptionPane.showMessageDialog(this, calendar.getHashTable().get(date).getPriorityQueue().toString());
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(this, "No event found on this day");
        }
      }


    private void setEventReminder() {
        try {
            // Getting the reminders for the current date
            String reminder = calendar.reminders();

            // Displaying the reminders
            if (!reminder.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Reminders for Today:\n" + reminder);
            } else {
                JOptionPane.showMessageDialog(this, "No reminders for today.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void showMonthlyEvents() {
        try {
            // Prompting the user to select a month
            String[] months = new DateFormatSymbols().getMonths();
            String selectedMonth = (String) JOptionPane.showInputDialog(
                    this,
                    "Select a month to view events:",
                    "Monthly View",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    months,
                    months[0]
            );

            // Checking if the user clicked Cancel
            if (selectedMonth == null) {
                return;
            }

            // Prompting the user for the year
            String selectedYear = JOptionPane.showInputDialog(
                    this,
                    "Enter the year (YYYY):",
                    "Monthly View",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Checking if the user clicked Cancel or entered an empty string
            if (selectedYear == null || selectedYear.trim().isEmpty()) {
                return;
            }

            // Parsing the user input into YearMonth
            YearMonth selectedYearMonth = YearMonth.parse(selectedYear + "-" + (Arrays.asList(months).indexOf(selectedMonth) + 1));

            // Retrieving monthly view using the Calendar's MonthlyView method
            String monthlyView = calendar.MonthlyView(selectedYearMonth.getMonthValue());

            if (!monthlyView.isEmpty()) {
                // Displaying events for the specified month
                JOptionPane.showMessageDialog(this, monthlyView);
            } else {
                JOptionPane.showMessageDialog(this, "No events found for the specified month.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No event set for this particular month");
        }
    }    

    private void clearTextFields() {
        titleField.setText("");
        descriptionField.setText("");
        yearField.setText("");
        monthField.setText("");
        dayField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");
        locationField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalendarGUI();
            }
        });
    }
}
