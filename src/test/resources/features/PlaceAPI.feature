
#feature file which covers add place and get place api requests

Feature: Google Map Place API calls
	@AddPlace
	Scenario Outline: Add place api call with a valid address
	
	Given Add Place payload with "<name>" "<language>" and "<address>"
	When user calls "ADD_PLACE" api with Post http request
	Then API call is success with the status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
Examples:

	|name	|	language	|	address		|
	|chinna	|	telugu		|	1-64 Ndm	|
	|kanna	|	hindi		|	2-77 Db		|
	|nanna	|	kannada		|	3-65 NDM	|
