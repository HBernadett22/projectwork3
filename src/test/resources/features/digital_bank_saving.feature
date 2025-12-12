Feature: DigitalBank new saving

  Background:
    Given I am signed in on the DigitalBank page

  Rule: Open new saving successfully
    Scenario: Fill the fields correct
      When I navigate to New Savings page
      And I create a new saving account with
        | TakarékszámlaTípusa | TakarékszámlaTulajdonjoga | SzámlaNeve | KezdetiBefizetés |
        | Megtakarítások      | Egyéni                    | KeBo3      | 100              |
      Then a message is shown on the savings page with "Megtakarítási számlák megtekintése"
      And the success message is visible "Megerősítés"
