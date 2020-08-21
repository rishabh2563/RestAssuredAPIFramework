Feature: Validate ADDPlace API's 

@AddPlace
Scenario Outline: Verify if Place is being Successfuly Added
    Given Add Place Payload "<name>" "<address>" "<language>"
    When User calls "AddPlaceAPI" using "Post" Http Request
    Then Verifying The Staus Code as 200
    And "status" in Response is "OK"
    And "scope" in Response is "APP"
    And verify place_ID created maps to "<name>" using "GetPlaceAPI"
    
    
 Examples:
 			|name           ||address                  ||language|
 			|Frontline house||29, side layout, cohen 10||French-IN|
 		#	|World Centre   ||29, sea  layout, cohen 11||English|

@DeletePlace 			
Scenario: Verify if Delete Place API is working Properly or not
      Given Delete Place Payload 
      When User calls "DeletePlaceAPI" using "Post" Http Request
      Then Verifying The Staus Code as 200
      And "status" in Response is "OK"