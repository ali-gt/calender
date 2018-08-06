To run the application, in CalenderApplication class right click and run as java application.

There are three endpoints for this service. They are:

localhost:8080/create

localhost:8080/retrieve

localhost:8080/remove

To create an event, use the following JSON:

    {
       "User" : "Ali",
       "Title" : "Calender Event Meeting",
       "EventDate" : "2018-08-06 11:06",
       "Location" : "Home",
       "Remainder" : "Yes",
       "RemainderFlag" : "true",
       "Duration" : 30
    }

To retrieve an event, use the following JSON:

    {
       "User" : "Ali"
    }

To remove an event, use the following JSON:

    {
       "User" : "Ali"
    }
  
