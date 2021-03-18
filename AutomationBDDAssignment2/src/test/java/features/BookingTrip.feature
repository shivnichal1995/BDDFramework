Feature: Booking Trip Feature
 
#Scenario: Booking One Way Trip
#Given user is on home page of Goibibo
#When user selects type of a trip: "One way"
#And user select From: "Mumbai" & Destination: "Goa"
#And  user select departure date: "20" , "March 2021"
#And users enters details- adults: 1 ,children: 1 ,infants: 1 &travelclass: "Economy" 
#And user clicks on search button
#And user selects cheapest price and click on book now button
#Then Selected from: "Mumbai" , destination: "Goa" and departure date: "20" , "March 2021" will be displayed on summary page 


Scenario: Booking Round Trip
Given user is on home page of Goibibo
When user selects type of a trip: "Round trip"
And user select From: "Mumbai" & Destination: "Goa"
And  user select departure date: "20" , "March 2021"
And  user select return date: "30" , "March 2021"
And users enters details- adults: 1 ,children: 1 ,infants: 1 &travelclass: "Economy" 
And user clicks on search button
And user selects cheapest price and click on book now button
Then Selected from: "Mumbai" , destination: "Goa" and departure date: "20" , "March 2021" will be displayed on summary page 
And  Return from: "Goa" , destination: "Mumbai" and return date: "30" , "March 2021" will be displayed on summary page 
