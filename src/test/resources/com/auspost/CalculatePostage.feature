@POSTAGE_CALCULATE
Feature: Open Postage Calculate page
  Test Postage calculation normal, special size, delivery date and combined

  Background: Navigate to Australia Post site
    Given the Australia Post Calculate Page

  @SPECIAL_SIZE
  Scenario: Open Post page, verify title/heading and check cost for customised size
    Then verify heading has text "Calculate postage & delivery times"
    And enter the from postcode as "2000" and select "SYDNEY NSW 2000" from dropdown
    And enter the to postcode as "2763" and select "ACACIA GARDENS NSW 2763" from dropdown
    And submit the form to calculate postage fee

    When the postage details page is loaded with heading "Compare domestic parcel services"
    And I click the link to enter size "100:10:10" and weight as 15
    And verify details page contains the below services with cost
      | service      | cost   |
      | Express Post | $26.50 |
      | Parcel Post  | $19.50 |

  @NORMAL_COST
  Scenario: Open Post page, verify title/heading for check for normal cost
    Then verify heading has text "Calculate postage & delivery times"
    And enter the from postcode as "2000" and select "SYDNEY NSW 2000" from dropdown
    And enter the to postcode as "2763" and select "ACACIA GARDENS NSW 2763" from dropdown
    And submit the form to calculate postage fee

    When the postage details page is loaded with heading "Compare domestic parcel services"
    And verify details page contains the below services with cost
      | service      | cost   |
      | Express Post | $11.95 |
      | Parcel Post  | $8.95  |

  @DELIVERY_DATE
  Scenario: Open Post page, verify title/heading and verify cost for a particular date
    Then verify heading has text "Calculate postage & delivery times"
    And enter the from postcode as "2000" and select "SYDNEY NSW 2000" from dropdown
    And enter the to postcode as "2763" and select "ACACIA GARDENS NSW 2763" from dropdown
    And submit the form to calculate postage fee

    When the postage details page is loaded with heading "Compare domestic parcel services"
    And I click the link to enter a 2 days later delivery
    And verify details page contains the below services with cost
      | service      | cost   |
      | Express Post | $11.95 |
      | Parcel Post  | $8.95  |

  @DELIVERY_AND_SPECIAL @DELIVERY_DATE @SPECIAL_SIZE
  Scenario: Open Post page, verify title/heading and verify cost for a particular date
    Then verify heading has text "Calculate postage & delivery times"
    And enter the from postcode as "2000" and select "SYDNEY NSW 2000" from dropdown
    And enter the to postcode as "2763" and select "ACACIA GARDENS NSW 2763" from dropdown
    And submit the form to calculate postage fee

    When the postage details page is loaded with heading "Compare domestic parcel services"
    And I click the link to enter size "30:10:5" and weight as 22
    And I click the link to enter a 2 days later delivery
    And verify details page contains the below services with cost
      | service      | cost   |
      | Express Post | $27.20 |
      | Parcel Post  | $20.20 |