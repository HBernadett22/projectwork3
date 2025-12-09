Feature: DigitalBank login page opening

  As a registreted DigitalBank customer, I would like to login successfully, so that I can check bank infos online.

  Backround:
  Given I open the DigitalBank page
  And accept cookies

  Rule: Login successfully
    Scenario: Fill the login fields correct
      When I sign in using "KBoglarka" and "KeBo123456"
      Then a message is show with "Üdvözöljük, Boglárka"

  Rule: Login unsuccessfully
    Scenario Outline: Fill the login fields incorrect
      When I sign in using "<felhasználónév>" and "<jelszó>"
      Then an error message is visible "Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, vagy létező felhasználó munkamenet miatt."

      Examples:
        | felhasználónév | jelszó     |
        | KBogi          | KeBo123456 |
        | KBoglarka      | KeBo654321 |
        |                | KeBo123456 |
        | KBogi          |            |

