Feature DigitalBank new saving

  Background:
    Given I am singed in on the DigitalBank page
    And I see the "Üdvözöljük, Boglárka"

  Rule: Open new saving successfully
    Scenario: Fill the fields correct
      When I ckick on "Megtakarítás" and "Új megtakarítás"
      And I create a new saving account with
        | TakarékszámlaTípusa | TakarékszámlaTípusa | SzámlaNeve | KezdetiBefizetés |
        | Megtakarítások      | Egyéni              | KeBo3      | 100              |
      And I click on "Elküldés"
      Then a message is shown with "Megtakarítási számlák megtekintése"
      And the success message is visible "Megerősítés"


  Rule: Open new saving unsuccessfully
    Scenario: Leave empty checkbox
      Given the user already loged in
      And see the Áttekintés
      When the user ckick on Megtakarítás
      And Új megtakarítás
      And leaves field ( Egyéni) empty
      Then a popup show the message "Válasszon egy adott opciót."

  Rule: Open new saving unsuccessfully
    Scenario: Leave empty field
      Given the user already loged in
      And see the Áttekintés
      When the user ckick on Megtakarítás
      And Új megtakarítás
      And leaves field (Számla neve) empty
      Then a popup show the message "Töltse ki a mezőt."

  Rule: Open new saving unsuccessfully
    Scenario: Fil the cost with <10$
      Given the user already loged in
      And see the Áttekintés
      When the user ckick on Megtakarítás
      And Új megtakarítás
      And fill Kezdeti befizetés as 9
      Then a popup show the message "The initial deposit ($9.00) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount."

