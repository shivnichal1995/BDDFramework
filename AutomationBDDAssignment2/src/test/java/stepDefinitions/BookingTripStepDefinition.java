package stepDefinitions;



import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.test.pages.IbiboHomePage;
import com.test.utils.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class BookingTripStepDefinition extends TestBase {

	
	 Logger log = Logger.getLogger("devpinoyLogger");
	
	IbiboHomePage homePage= new IbiboHomePage(driver);
	
	
	@After
	public void tarDown()
	{
		driver.close();
		driver.quit();
	}
	

	@Given("^user is on home page of Goibibo$")
	public void user_is_on_home_page_of_Goibibo() throws Throwable {
		
		initialization();
		
		 log.debug("opening webiste");
		String actualtitle = driver.getTitle();
		// System.out.println(actualtitle);
		String expectedTitle = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
		//asserting the title
		Assert.assertEquals(actualtitle, expectedTitle);
	}

	
	@When("^user selects type of a trip: \"([^\"]*)\"$")
	public void user_selects_type_of_a_trip(String typeOfTrip) throws Throwable {
		
		 log.debug("selecting trip");
		homePage.selectTrip(typeOfTrip);
		
	}

	
	@And("^user select From: \"([^\"]*)\" & Destination: \"([^\"]*)\"$")
	public void user_select_From_Destination(String from, String dest) throws Throwable {

		log.debug("entering from location");
		homePage.enterFrom(from);
		log.debug("entering destination location");
		homePage.enterDestination(dest);
		
		
	}

	
	@And("^user select departure date: \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_select_departure_date(String date, String month_year) throws Throwable {

		
		log.debug("entering departure date");
		homePage.selectDepartureDate(date, month_year);
		
	}

	
	@And("^users enters details- adults: (\\d+) ,children: (\\d+) ,infants: (\\d+) &travelclass: \"([^\"]*)\"$")
	public void users_enters_details_adults_children_infants_travelclass(int adults, int children, int infants,
			String travelclass) {
		
		log.debug("entering details: adults, children, infants, travelclass");
		homePage.selectAdultsChildrenInfantsAndTravelclass(adults, children, infants, travelclass);

	}

	
	@And("^user clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
		
		log.debug("clicking on search button");
		homePage.clickOnSearchButton();
		Thread.sleep(10000);
		

		
	}

	
	@And("^user selects cheapest price and click on book now button$")
	public void user_selects_cheapest_price_and_click_on_book_now_button() throws Throwable {

		log.debug("selcting cheap price");
		homePage.selectCheapPriceBookButton();


	}
	
	
	@When("^user select return date: \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_select_return_date(String date, String month_year) throws Throwable {
	   
		log.debug("entering return date");
		homePage.selectReturenDate(date,month_year);
		
		

	}

	@Then("^Selected from: \"([^\"]*)\" , destination: \"([^\"]*)\" and departure date: \"([^\"]*)\" , \"([^\"]*)\" will be displayed on summary page$")
	public void selected_from_destination_and_departure_date_will_be_displayed_on_summary_page(String from, String dest, String date, String month_year) throws Throwable {
		
		log.debug("verifying details");
		homePage.verifySelectedFromDestinationAndDepartureDate(from, dest, date, month_year);
		
		
	
	    
	}

	@Then("^Return from: \"([^\"]*)\" , destination: \"([^\"]*)\" and return date: \"([^\"]*)\" , \"([^\"]*)\" will be displayed on summary page$")
	public void return_from_destination_and_return_date_will_be_displayed_on_summary_page(String returnFrom, String returnDest, String returnDate, String returnMonth_Year) throws Throwable {
	    
		log.debug("verifying return details");
		homePage.verifySelectedReturnFromDestinationAndDepartureDate(returnFrom, returnDest, returnDate, returnMonth_Year);
		
		
		
	}
	
	

}
