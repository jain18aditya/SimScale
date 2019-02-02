Feature: Place online order
  I want to use this feature to test product shopping over a website

  @ha
  Scenario: Register new user and place order
    Given Launch browser with url "housinganywhere.url"
		When search "product.name" and select product
		And Select product details and add to cart
		And Register new user
		And Proceed to payment
		And Complete the payment details
  	Then Order should be placed successfully
		And Logout the user
	
  Scenario: Login with existing user and place order
    Given Launch browser with url "housinganywhere.url"
	  And User log in with UserName "user.email" and password "password"
		When search "product.name" and select product
		And Select product details and add to cart
		And Proceed to payment
		And Complete the payment details
		Then Order should be placed successfully
		And Logout the user
		And close the browser
