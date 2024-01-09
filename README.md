# Event Scheduler and Calendar

## Overview

Welcome to the Event Scheduler and Calendar project! This software is designed to help you efficiently manage your events and schedule. The project incorporates a modular structure, making it easy to understand and extend. Users can create, modify, remove, view, and manage events with details such as title, description, date, time, and location. The application supports daily and monthly views and provides reminders for daily events. Below are instructions on how to use the software.

## Instructions

1. **Run the Application:**
    - Compile and run the `CalendarGUI` class, which contains the main method.

2. **Add an Event:**
    - Fill in the event details in the corresponding text fields.
    - Click the "Add Event" button.
    - A confirmation message will be displayed if the event is added successfully.

3. **View Daily Events:**
    - Click the "Events Daily View" button.
    - Enter a date in the format (YYYY-MM-DD) when prompted.
    - View the events for the specified date.

4. **Event Reminders:**
    - Click the "Reminders" button to view reminders for today's events.

5. **View Monthly Events:**
    - Click the "Events Monthly View" button.
    - Select a month and enter the year when prompted.

6. **Exit the Application:**
    - Close the application window.
  
## Features

- **Modular Design:** The project is divided into four components: Event, Day, Calendar, and Graphic User Interface (GUI), enhancing code readability and maintainability.
- **Efficient Data Structures:** Utilizes binary heaps, priority queues and hashtables to ensure efficient event sorting and calendar access.
- **Simple GUI:** Implemented using JavaX.Swing, providing a user-friendly interface for seamless interaction.


### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) - [Download here](https://www.oracle.com/java/technologies/javase-downloads.html)

## Classes

### CalendarGUI Class
- This class provides a graphical user interface for interacting with the calendar.
- Includes fields for entering event details such as title, description, date, time, and location. 
- Allows users to add events, view daily and monthly events, and set event reminders.

### Calendar Class
- Manages a calendar with a Hashtable to store events for each date.
- Provides methods to add, remove, and modify events.
- Supports functionalities such as showing daily events and generating reminders.

### Test Class
- This class provides a test for our methods. 
- To modify the test cases you can do the following, feel free to change them as you wish: 
    - Removing an Event

        - To remove an event, follow these steps:

            1. Run the `Test` class.
            2. Choose the option to remove an event.
            3. Select the event you want to remove.

    - Modifying an Event

        - To modify an event, follow these steps:

            1. Run the `Test` class.
            2. Choose the option to modify an event.
            3. Select the event you want to modify.
            4. Follow the prompts to update the event details.

    - Viewing Events for a Specific Day

        - To view events for a specific day, follow these steps:

            1. Run the `Test` class.
            2. Choose the option to view events for a day.
            3. Enter the date for which you want to see events.
- kindly follow the same steps to test any other method of your choice.
  
### Event Class
- Represents an event with attributes such as title, description, date, time, and location.
- Provides methods to set and get event details.

### Day Class
- Represents a day with a priority queue to manage daily events.
- Provides methods to add, remove, and show events for a specific day.

