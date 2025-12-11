Feature: DigitalBank login page opening

  As a registreted DigitalBank customer, I would like to login successfully, so that I can check bank infos online.

  Background:
    Given I open the DigitalBank page
    And accept cookies

  Rule: Login successfully
    Scenario: Fill the login fields correct
      When I sign in using "KBoglarka" and "KeBo123456"
      Then a message is shown with "Üdvözöljük, Boglárka"

  Rule: Login unsuccessfully
    Scenario Outline: Fill the login fields incorrect
      When I sign in using "<felhasználónév>" and "<jelszó>"
      Then a login error message is visible

      Examples:
        | felhasználónév | jelszó     |
        | KBogi          | KeBo123456 |
        | KBoglarka      | KeBo654321 |
        |                | KeBo123456 |
        | KBogi          |            |
