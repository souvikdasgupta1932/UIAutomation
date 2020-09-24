@Test
Feature: Flight Booking

  Background: 
    Given user is on the home page

  Scenario: Book flight and verify
    Then the user verify if the following cities are under "Departure Cities"
      | Paris        |
      | Philadelphia |
      | Boston       |
      | Portland     |
      | San Diego    |
      | Mexico City  |
      | São Paolo    |
    Then the user verify if the following cities are under "Destination Cities"
      | Buenos Aires |
      | Rome         |
      | London       |
      | Berlin       |
      | New York     |
      | Dublin       |
      | Cairo        |
    Then the user selects "departureCity" place as "Philadelphia"
    Then the user selects "destinationCity" place as "Rome"
    Then the user clicks on "Find Flights" button
    And the user verify flights from "Philadelphia" to "Rome" is displayed
    Then the user selects flight "Virgin America" and No "43"
    And verify the flight is reserved
    Then user fills in the purchase details
      | Name   | Address | City | State       | Zip Code | Card Type | Credit Card Number | Month | Year | Name on Card |
      | Souvik | Pune    | Pune | Maharashtra |   412207 | Visa      |         1234567890 |    11 | 2017 | Souvik       |
    Then the user clicks on "Purchase Flight" button
    And the user verify the purchase is successful
    And the user verify the correct fields have been populated
      | Id          |
      | Status      |
      | Amount      |
      | Card Number |
      | Expiration  |
      | Auth Code   |
      | Date        |
    Then the user verify ID is generated
    Then the user verify Status is generated
