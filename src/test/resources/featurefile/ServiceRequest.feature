@Service @Regression
Feature: owner service request


@ServiceRequestAccessCardValidation @Functionalitychange
  Scenario Outline: Service request Access card mandatory field validation
    Given user navigates to Arada login page
    When user login with "Owner" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    And user Request for Access Card with "<Building>" and "<Unit>" and "<Reason>" and "<Accesstype>" and "<NumberOfCard>" and "<Remark>" and "<CopyofReceipt>" and "<Tnc>"
    Then verify that validation message display as "<Message>"
    And user logout successfully from Arada
    Examples:
    |Building|Unit     |Reason|Accesstype|NumberOfCard|Remark|CopyofReceipt|Tnc|Message|
    |         |         |Damage|          |          |test  |             |checked|Select a valid unit number|
    #|         |         |Lost|           |          |test  |             |checked|Select a valid unit number|
    #|         |         |Additional|          |          |test  |             |checked|Select a valid unit number|
    #| Avenue 1|         |Damage|          |          |test  |             |checked|Select a valid unit number|
    #| Avenue 1|         |Lost|          |          |test  |             |checked|Select a valid unit number|
    #| Avenue 1|         |Additional|          |          |test  |             |checked|Select a valid unit number|
    #| Avenue 1|REHAN1316|Additional| Unchecked |  4        |test  |             |checked|The Reason for Request field is required.|
  
  
 @ServiceRequestAccessCard
  Scenario Outline: Owner raise access card request and Admin approve the request
    Given user navigates to Arada login page
     When user login with "Owner" user in Arada
     #When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    And user Request for Access Card with "<Building>" and "<Unit>" and "<Reason>" and "<Accesstype>" and "<NumberOfCard>" and "<Remark>" and "<CopyofReceipt>" and "<Tnc>"
    And user enter payment details
    And verify that payment is successfull
    #Then verify that service request is raised successfully
    And user logout successfully from Arada
    When user login with "SuperAdmin" user in Arada
    Then verify that Arada dashboard page is displayed
    When user select admin community "Aljada"
    And user click on admin service request
    And user click on admin action request
    And user search service request
    And user view and validate service request as "Open"
    Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    And user logout successfully from Arada
    Examples:
    |UserName|Password|Building|Unit     |Reason|Accesstype|NumberOfCard|Remark|CopyofReceipt|Tnc|ServiceStatus|Comment|
    |fatima_almazrouee@hotmail.com|owner123|Avenue 1|JADA-AVE1-REHN-REHN1-316|Damage|checked   |  1         |test  |             |checked|Approved|approved service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Rejected|rejected service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Cancelled|Cancelled service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|In progress|In progress service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Closed|Closed service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Request for Cancellation|Request for Cancellation service|
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Amenity Cancel Approved|Amenity Cancel Approved service| 
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Amenity Cancel Rejected|Amenity Cancel Rejected service| 
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Parking Cancel Approved|Parking Cancel Approved service| 
    |fatima_almazrouee@hotmail.com|owner123 |Avenue 1|REHAN1316|Damage|checked   |           |test  |             |checked|Parking Cancel Rejected|Parking Cancel Rejected service| 
    
    
  @ServiceRequestEmailUpdate
  Scenario Outline: Owner raise email update request and Admin approve thes request
    Given user navigates to Arada login page
    #When user login with "Owner" user in Arada
    When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    When user update email as "<Email>" and remark as "<Remark>"
    Then verify that service request is raised successfully
    And user logout successfully from Arada
    When user login with "SuperAdmin" user in Arada
    Then verify that Arada dashboard page is displayed
    When user select admin community "Aljada"
    And user click on admin service request
    And user click on admin action request
    And user search service request
    And user view and validate service request as "Open"
    Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    And user logout successfully from Arada
    
    Examples:
   |UserName|Password |Email|Remark|ServiceStatus|Comment|
    |fatima_almazrouee@hotmail.com|owner123|abc@gmail.com|email update|Rejected|rejected service|
    |fatima_almazrouee@hotmail.com|owner123 |abc@gmail.com|email update|Cancelled|Cancelled service|
    |fatima_almazrouee@hotmail.com|owner123|abc@gmail.com|email update|Cancelled|Cancelled service|
    
    @ServiceRequestMobileUpdate
  Scenario Outline: Owner raise mobile update request and Admin approve the request
    Given user navigates to Arada login page
    #When user login with "Owner" user in Arada
    When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    When user update mobile as "<Mobile>" and remark as "<Remark>"
    Then verify that service request is raised successfully
    And user logout successfully from Arada
    When user login with "SuperAdmin" user in Arada
    Then verify that Arada dashboard page is displayed
    When user select admin community "Aljada"
    And user click on admin service request
    And user click on admin action request
    And user search service request
    And user view and validate service request as "Open"
    Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    And user logout successfully from Arada
    
    Examples:
   |UserName|Password |Mobile        |Remark|ServiceStatus|Comment|
    |fatima_almazrouee@hotmail.com|owner123 |+91 1234567890|mobile update|Rejected|rejected service|
    |fatima_almazrouee@hotmail.com|owner123|+91 1234567890|mobile update|Request for Cancellation|Cancelled service|
    
    @ServiceRequestEmailMobileUpdate
  Scenario Outline: Owner raise email and mobile update request and Admin approve the request
    Given user navigates to Arada login page
    #When user login with "Owner" user in Arada
     When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    When user update email as "<Email>" and mobile as "<Mobile>" and remark as "<Remark>"
    Then verify that service request is raised successfully
    And user logout successfully from Arada
    When user login with "SuperAdmin" user in Arada
    Then verify that Arada dashboard page is displayed
    When user select admin community "Aljada"
    And user click on admin service request
    And user click on admin action request
    And user search service request
    And user view and validate service request as "Open"
    Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    And user logout successfully from Arada
    
    Examples:
    |UserName                     |Password |Email        |Mobile        |Remark      |ServiceStatus|Comment|
    |fatima_almazrouee@hotmail.com|owner123 |abc@gmail.com|+91 1234567890|email update|Rejected      |rejected service|
    |fatima_almazrouee@hotmail.com|owner123 |abc@gmail.com|+91 1234567890|Cancelled   |Cancelled|Cancelled service|
    
    
   @ServiceRequestMoveInRequest
   Scenario Outline: Owner raise move in request and Admin approve the request
    Given user navigates to Arada login page
    When user login with "Owner" user in Arada
   # When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    When user enter move in request unit details as community "<Community>" and unit as "<Unit>"
    And user enter move in request resident detail as Adult "1" and Children "1" and SrCitizen "1" and NoOfDetermination "0" and Nationality "United Arab Emirates" and Occupation "Managing director" and NoOfVechile "0" and VechileNumber "" and accessCard "1" and Pet "yes" 
    #When user update email as "<Email>" and mobile as "<Mobile>" and remark as "<Remark>"
    #Then verify that service request is raised successfully
    #And user logout successfully from Arada
    #When user login with "SuperAdmin" user in Arada
    #Then verify that Arada dashboard page is displayed
    #When user select admin community "Aljada"
    #And user click on admin service request
    #And user click on admin action request
   # And user search service request
    #And user view and validate service request as "Open"
    #Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    #And user logout successfully from Arada
     Examples:
    |UserName                     |Password |Community|Unit|Remark|ServiceStatus|Comment|
    |fatima_almazrouee@hotmail.com|owner123 |Aljada - Avenue 1|JADA-AVE1-REHN-REHN1-316|email update|Rejected|rejected service|
   # |fatima_almazrouee@hotmail.com|owner123 |Aljada - Avenue 1|JADA-AVE1-REHN-REHN1-316|moveein|Cancelled|Cancelled service|
    
    @ServiceRequestMoveOutRequest
   Scenario Outline: Owner raise moveout request and Admin approve the request
    Given user navigates to Arada login page
    When user login with "Owner" user in Arada
   # When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    When user click My Request
    And user click My Service
    When user enter move out request details as community "<Community>" and unit "<Unit>" and moveOut "<MoveOutDate>" and reason "<Reason>" and moveTo "<MoveTo>" and feedBack "<FeedBack>" and vendor "<Vendor>"
    #When user update email as "<Email>" and mobile as "<Mobile>" and remark as "<Remark>"
    #Then verify that service request is raised successfully
    #And user logout successfully from Arada
    #When user login with "SuperAdmin" user in Arada
    #Then verify that Arada dashboard page is displayed
    #When user select admin community "Aljada"
    #And user click on admin service request
    #And user click on admin action request
   # And user search service request
    #And user view and validate service request as "Open"
    #Then user update "<ServiceStatus>" of service request with comment as "<Comment>"
    #And user logout successfully from Arada
     Examples:
   |UserName                     |Password |Community|Unit|MoveOutDate|Reason|MoveTo|FeedBack|Vendor|ServiceStatus|Comment|
   |fatima_almazrouee@hotmail.com|owner123  |Aljada - Avenue 1|JADA-AVE1-REHN-REHN1-316|auto|test|better|feedback|P|Cancelled|Cancelled service|
 
    
    