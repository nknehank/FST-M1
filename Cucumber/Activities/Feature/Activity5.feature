@Activity5
  Feature:"Login Test"
    Scenario Outline:"Testing Login with Example"
    GIVEN: User is on Login page
    WHEN: User enters "<username>" and "<password>"
    THEN: Read the page title and confirmation message
    AND: Close the Browser
      Examples:
        | username  | password |
        | admin     | password |
        | adminUser | 12345    |
