@RegisterUser @Regression 
Feature: User Registration 


@UserRegistervalidation 
Scenario Outline: Register new user as tenant field validation
	Given user navigates to Arada login page 
	And user click register button 
	When user enter tenant details as "<Community>" and "<Building>" and "<Unit>" 
	Then verify that validation message should display as "<Message>" 
	
	
	Examples: 
		|Community|Building|Unit      |Message|
		|         |        |          |Please Select Community,Please Select Building,Please Select Unit Number|
		|Aljada     |        |          |Please Select Building,Please Select Unit Number|
		|Aljada     |Avenue 1|          |Please Select Unit Number|
		
		@UserRegister1 @tenant 
		Scenario Outline: Register new user as tenant 
			Given user navigates to Arada login page 
			And user click register button 
			When user enter tenant details as "<Community>" and "<Building>" and "<Unit>" 
			Then user navigate to Resident Details screen 
			
			Examples: 
				|Community|Building|Unit|
				| Aljada |Avenue 1|JADA-AVE1-AREJ-ARJ1-105|
				
				@UserRegister2 @owner 
				Scenario Outline: Register new user as owner
					Given user navigates to Arada login page 
					And user click register button 
					When user enter owner details as "<Community>" and "<Building>" and "<Unit>" 
					Then user navigate to Resident Details screen 
					
					Examples: 
						|Community|Building|Unit|
						|Aljada|Avenue 1|JADA-AVE1-AREJ-ARJ1-101|
						
@ResidentDetailsValidations @owner 
Scenario Outline: validation message in ResidentDetails screeen for tenant
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen 
When user enter resident details ApplyFor as "<ApplyFor>" and Adult as "<Adult>" and Children as "<Children>" and SrCitizen as "<SrCitizen>" and NoOfDetermination as "<NoOfDetermination>" and Name as "<Name>" and ContactNo as "<ContactNo>" and Email as "<Email>" and Nationality as "<Nationality>" and Occupation as "<Occupation>" and NoOfVechile as "<NoOfVechile>" and VechileNumber as "<VechileNumber>" and Pet as "<Pet>" 
Then verify that validation message should display as "<Message>"							
Examples: 
|ApplyFor|Adult|Children|SrCitizen|NoOfDetermination|Name|ContactNo     |Email        |Nationality         |Occupation       |NoOfVechile|VechileNumber|Pet|Message|
|tenant  |     |1       |1        |0                |Test|+91 1234567890|abc@gmail.com|United Arab Emirates|Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |        |1        |0                |Test|+91 1234567890|abc@gmail.com|United Arab Emirates|Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |         |0                |Test|+91 1234567890|abc@gmail.com|United Arab Emirates|Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |1        |0                |    |+91 1234567890|abc@gmail.com|United Arab Emirates|Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |1        |0                |Test|              |abc@gmail.com|United Arab Emirates|Managing director|1          |A12-1234     |yes|Please enter valid phone number|
|tenant  |1    |1       |1        |0                |Test|+91 1234567890|             |United Arab Emirates|Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |1        |0                |Test|+91 1234567890|abc@gmail.com|                    |Managing director|1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |1        |0                |Test|+91 1234567890|abc@gmail.com|United Arab Emirates|                 |1          |A12-1234     |yes|This field is required.|
|tenant  |1    |1       |1        |0                |Test|+91 1234567890|abc@gmail.com|United Arab Emirates|Managing director|1          |             |yes|This field is required.|



@EmergencyContactscreenDisplay @owner 
Scenario Outline: verify that emergency contact screen should display
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen 
When user enter resident details ApplyFor as "<ApplyFor>" and Adult as "<Adult>" and Children as "<Children>" and SrCitizen as "<SrCitizen>" and NoOfDetermination as "<NoOfDetermination>" and Name as "<Name>" and ContactNo as "<ContactNo>" and Email as "<Email>" and Nationality as "<Nationality>" and Occupation as "<Occupation>" and NoOfVechile as "<NoOfVechile>" and VechileNumber as "<VechileNumber>" and Pet as "<Pet>" 
Then verify that Emergency contact screen should display							
Examples: 
|ApplyFor    |Adult|Children|SrCitizen|NoOfDetermination|Name|ContactNo     |Email        |Nationality         |Occupation       |NoOfVechile|VechileNumber|Pet|
|tenant      |1     |1       |1        |0                |Test|+91 1234567890|auto|United Arab Emirates|Managing director|1          |A12-1234     |yes|
|corporate   |1     |1       |1        |0                |Test|+91 1234567890|auto|United Arab Emirates|Managing director|1          |A12-1234     |yes|
|company     |1     |1       |1        |0                |Test|+91 1234567890|auto|United Arab Emirates|Managing director|1          |A12-1234     |yes|


@EmergencyContactscreenvalidation @owner 
Scenario Outline: Emergency screen validation
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen 
When user enter resident details ApplyFor as "tenant" and Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "<Name>" and email as "<Email>" and contactNo as "<ContactNo>" and residence as "<Residence>"
Then verify that validation message should display as "<Message>"							
Examples: 
|Name  |Email        |ContactNo     |Residence|Message|
|      |abc@gmail    |+91 1234567890|Abu Dhabi       |This field is required.|
|Test  |    |+91 1234567890       |Abu Dhabi      |This field is required.|
|Test  | abc@gmail   |       |Abu Dhabi      |Please enter valid phone number|
|Test  | abc@gmail   |+91 1234567890       |      |This field is required.|

@OccupancyDetialsscreen @tenant 
Scenario Outline: verify that tenant navigate to occupancy details page
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter resident details ApplyFor as "tenant" and Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "<Name>" and email as "<Email>" and contactNo as "<ContactNo>" and residence as "<Residence>"
Then verify that Occupancy Details screen is displayed						
Examples: 
|Name|Email        |ContactNo     |Residence|
| Test   |abc@gmail    |+91 1234567890|Abu Dhabi       |


@OccupancyDetialsScreenOwner @owner 
Scenario Outline: verify that owner navigate to occupancy details page
Given user navigates to Arada login page 
And user click register button 
When user enter owner details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen 
When user enter owner resident details Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes"
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "<Name>" and email as "<Email>" and contactNo as "<ContactNo>" and residence as "<Residence>"
Then verify that Occupancy Details screen is displayed						
Examples: 
|Name|Email        |ContactNo     |Residence|
| Test   |abc@gmail    |+91 1234567890|Abu Dhabi       |

@VendorDetialsScreenTenant @tenant 
Scenario Outline: verify that tenant navigate to vendor details page
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter resident details ApplyFor as "tenant" and Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "test" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed	
When user enter tenants occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and moveinStartDate as "<MoveInStartDate>" and moveInEndDate as "<MoveInEndDate>" and tenantDeed as "<TenantDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" and ejariCopy as "<EjariCopy>"		
Then verify that Vendor Details screen is displayed
Examples: 
|MoveIn|MoveInDate  |Slot          |MoveInStartDate|MoveInEndDate|TenantDeed |GasActivation|Passport|EjariCopy|
| yes  |auto        |1             |30             |     5       |Passport.jpg|Passport.jpg|Passport.jpg|Passport.jpg|

@VendorDetialsScreenOwner @owner
Scenario Outline: verify that owner navigate to vendor details page
Given user navigates to Arada login page 
And user click register button 
When user enter owner details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter owner resident details Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "abc123@gmail.com" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "test" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed
When user enter owner occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and titleDeed as "<TitleDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" 		
Then verify that Vendor Details screen is displayed
Examples: 
|MoveIn|MoveInDate  |Slot          |TitleDeed   |Passport|GasActivation|
| yes  |auto   |1|Passport.jpg|Passport.jpg|Passport.jpg|

@RequestSent @owner
Scenario Outline: verify that owner submit the registration request successfull
Given user navigates to Arada login page 
And user click register button 
When user enter owner details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter owner resident details Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "tester" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed
When user enter owner occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and titleDeed as "<TitleDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" 		
Then verify that Vendor Details screen is displayed
When user select vendor name as "<VendorName>"
Then verify that request sent screen is displayed
Examples: 
|MoveIn|MoveInDate  |Slot|TitleDeed   |Passport    |GasActivation|VendorName|
| yes  |auto        |0   |Passport.jpg|Passport.jpg|Passport.jpg |P|

@RequestSentVendorOther @owner
Scenario Outline: verify that owner submit the registration request successfully with vendor as Others
Given user navigates to Arada login page 
And user click register button 
When user enter owner details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter owner resident details Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "tester" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed
When user enter owner occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and titleDeed as "<TitleDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" 		
Then verify that Vendor Details screen is displayed
When user select vendor name as "<VendorName>" and companyName as "<CompanyName>" and contactName as "<ContactName>" and contactNo as "<ContactNumber>" and email as "<Email>"
Then verify that request sent screen is displayed
Examples: 
|MoveIn|MoveInDate|Slot|TitleDeed   |Passport    |GasActivation|VendorName|CompanyName|ContactName  |ContactNumber  |Email|
| yes  |auto      |0   |Passport.jpg|Passport.jpg|Passport.jpg |Others    |company name|conatct name|+91 1234567890|abc@gmail|


@RequestSentTenant @tenant 
Scenario Outline: verify that tenant submit the registration request successfull
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter resident details ApplyFor as "tenant" and Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "test" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed	
When user enter tenants occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and moveinStartDate as "<MoveInStartDate>" and moveInEndDate as "<MoveInEndDate>" and tenantDeed as "<TenantDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" and ejariCopy as "<EjariCopy>"		
Then verify that Vendor Details screen is displayed
When user select vendor name as "<VendorName>"
Then verify that request sent screen is displayed
Examples: 
|MoveIn|MoveInDate  |Slot          |MoveInStartDate|MoveInEndDate|TenantDeed |GasActivation|Passport|EjariCopy|VendorName|
| yes  |auto        |1             |30             |     5       |Passport.jpg|Passport.jpg|Passport.jpg|Passport.jpg|P|


@RequestSentTenantOther @tenant 
Scenario Outline: verify that tenant submit the registration request successfully with vendor as Others
Given user navigates to Arada login page 
And user click register button 
When user enter tenant details as "Aljada" and "Avenue 1" and "JADA-AVE1-AREJ-ARJ1-105" 
Then user navigate to Resident Details screen
When user enter resident details ApplyFor as "tenant" and Adult as "1" and Children as "1" and SrCitizen as "1" and NoOfDetermination as "0" and Name as "test" and ContactNo as "+91 1234567890" and Email as "auto" and Nationality as "United Arab Emirates" and Occupation as "Managing director" and NoOfVechile as "0" and VechileNumber as "" and Pet as "yes" 
Then verify that Emergency contact screen should display
When user enter emergency contact details name as "test" and email as "abc@gmail" and contactNo as "+91 1234567890" and residence as "Abu Dhabi"
Then verify that Occupancy Details screen is displayed	
When user enter tenants occupancy details moveIn as "<MoveIn>" and moveInDate as "<MoveInDate>" and slot as "<Slot>" and moveinStartDate as "<MoveInStartDate>" and moveInEndDate as "<MoveInEndDate>" and tenantDeed as "<TenantDeed>" and gasActivation as "<GasActivation>" and passport as "<Passport>" and ejariCopy as "<EjariCopy>"		
Then verify that Vendor Details screen is displayed
When user select vendor name as "<VendorName>" and companyName as "<CompanyName>" and contactName as "<ContactName>" and contactNo as "<ContactNumber>" and email as "<Email>"
Then verify that request sent screen is displayed
Examples: 
|MoveIn|MoveInDate  |Slot          |MoveInStartDate|MoveInEndDate|TenantDeed |GasActivation|Passport|EjariCopy|VendorName|CompanyName|ContactName  |ContactNumber  |Email|
| yes  |auto        |1             |30             |     5       |Passport.jpg|Passport.jpg|Passport.jpg|Passport.jpg|Others    |company name|conatct name|+91 1234567890|abc@gmail|
    