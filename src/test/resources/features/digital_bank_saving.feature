Feature DigitalBank new saving

  Backround:
  Given the user is loged in to the DigitalBank page
  And see the Áttekintés

  Rule: Open new saving successfully
    Scenario: Fill the fields correct
      Given the user already loged in
      And see the Áttekintés
      When the user ckick on Megtakarítás
      And Új megtakarítás
      And fill the boxes
      Then new Megtakarítás megtekintése will open and show all Megtakarítás
      And the new one is activ

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

