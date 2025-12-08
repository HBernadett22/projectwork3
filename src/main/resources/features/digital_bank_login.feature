Feature DigitalBank login page opening

  Backround:
  Given the user opens the DigitalBank page
  And accept cookies

  Rule: Login successfully
    Scenario: Fill the login fields correct
      Given the user opens the DigitalBank page
      And accept cookies
      When the user fill felhasználónév and jelszó ("KBoglarka and KeBo123456)
      And click on Belépés
      Then the Áttekintés is displayed

  Rule: Login unsuccessfully
    Scenario: Fill the login fields incorrect
      Given the user opens the DigitalBank page
      And accept cookies
      When the user fill felhasználónév and jelszó with typo ("KBoglarka and KEBo1234)
      And click on Belépés
      Then the login page is empty
      And message ist visible: 'Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, vagy létező felhasználó munkamenet miatt.'

