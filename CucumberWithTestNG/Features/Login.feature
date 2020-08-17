Feature: Login feature

	Scenario: User is able to Login the application
	Given user launches browser and opens the application	
 	Then clicks on SignIn link to open Sign In details
 	Then User enters valid credentials and home page of the application displays
 	
	Scenario: Short sleeve T Shirt added to a cart
	Given user launches browser and opens the application	
 	Then clicks on SignIn link to open Sign In details
 	Then User enters valid credentials and home page of the application displays
 	Then HomePage title is validated
 	Then Short sleeve T-Shirt is selectd under T-Shirt category added added to Cart
 	Then Product details verified
 	Then ProceedToCheckout button is clicked