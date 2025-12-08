## DigitalBank user stories ##

    US1: login
Story1:
Én, mint <regisztrált ügyfél> azt akarom,
hogy <sikresen be tudjak jelentkezni>,
amire azért van szükség, hogy <online hozzáférjek folyószámlámhoz>.

Acceptance criteria (elfogadási kritérium):
Megjelenik a bejelentkezési oldal következő mezőkkel:
felhasználónév, jelszó, belépés

    Rule1.1: helyes adatok megadása + belépés
Exapmle1.1:
ügyfél helyesen beadja a felhasználónevet + jelszót + rányom a bejelentkezésre.
=> outcome: sikeres bejelentkezés.
Gherkin formátum1:     (given-when-then = adott-ha-akkor)
Adott bejelentkező mezőknél,
ha helyes adatok (felhasználónév és jelszó) kerülnek bevitelre
és rányom a belépés gombra,
akkor bejelentkezteti, az ügyfelet a kezdőlapra vezeti.

    Rule1.2: hibás adatok + belépés
Example1.2:
Ügyfél hibás adatokat (felhasználónév és/vagy jelszó) ad be + rányom a bejelentkezésre.
=> outcome: 'Hiba
Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, vagy létező felhasználó munkamenet miatt.'
Gherkin formátum2:
Adott bejelentkező mezőknél,
ha hibás adatokat (felhasználónév és/vagy jelszó) kerülnek bevitelre
és rányom a belépés gombra,
akkor sikertelen a bejelentkezés (erről infócsík jön)
és a bejelentkező mezők újra üresek.


    US2: Folyószámla/ folyószámla megtekintése:
Story2:
Én, mint <bejelentkezett ügyfél> azt akarom,
hogy <folyószámlámon meg tudjam tekinteni a tranzakciókat>,
amire azért van szükség, hogy <egyenlegem lássam és követhessem a bevételeim, kiadásaim>.

Acceptance criteria (elfogadási kritérium):
Folyószámla megtekintésére kattintva megjelenik az egyenleg és a tranzakciók.

    Rule2.1: Megjelennek a folyószámla információi
Example2.1:
Bejelentkezett ügyfél kiválasztja a folyószámla -> folyószámla megtekintése opciót
=> outcome: megjelennek a folyószámla adatai és a rajta található pénzösszeg és a legutóbbi tranzakciók.

Gherkin formátum2.1:
Adott bejelentkezett ügyfél,
ha kiválasztja folyószámla -> folyószámla megtekintése opciót,
akkor megjelenik az egyenlegen található összeg (folyószámla tulajdonságaival együtt)
és az elmúlt idők tranzakciói.

(Hiba: nem jelenik meg az egyenleg/tulajdonságok, nem jelennek meg a tranzakciók, egyik sem jelenik meg.)


    US3: Megtakarítás létrehozása:
Story3:
Én, mint <bejelentkezett ügyfél> azt akarom,
hogy <létre tudjak hozni megtakarítási számlát>,
amire azért van szükség, hogy <tudjam csoportosítani pénzem>.

Acceptance criteria (elfogadási kritérium):
Megtakarítás – új megtakarításra kattintva megjelenik a „Megtakarítási számla létrehozása’ oldal a meghatározott mezőkkel ( új megtakarítási számla, típus és tulajdonjog választások, számlanév megadása, kezdeti befizetés).

    Rule3.1:  Sikeres megtakarítási számla nyitása
Example3.1:
Bejelentkezett ügyfél kiválasztja a megtakarítás -> új megtakarítás opciót
Helyesen, kritériumoknak megfelően kitölti az ügyfél és rányom az elküld gombra.
=> outcome: megjelennek a meghatárpzott adatok/opciók

Gherkin formátum3.1:
Adott bejelentkezett ügyfél,
ha kiválasztja megtakarítás -> új megtakarítás opciót,
és megadja a megtakarítási számla kezdő adatait helyesen kitöltve (típus és tulajdonjog választások, számlanév megadása, kezdeti befizetés),
akkor megnyítil az új megtakarítási számlája és ez felhozza a rendszer.


    Rule3.2:  Sikertelen megtakarítási számla nyitása
Example3.2:
Bejelentkezett ügyfél kiválasztja a megtakarítás -> új megtakarítás opciót
Hiányosan, kritériumoknak nem megfelően kitölti az ügyfél és rányom az elküld gombra.
=> outcome: megjelenik az adott hiba:
A: típus, tulajdonjog hiánya: Válasszon egy adott opciót.
B: Számla neve, kezdeti befizetés: Töltse ki a mezőt.
C: Alacsony kezdeti befizetés: The initial deposit ($1.00) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount.

Gherkin formátum3.2:
Adott bejelentkezett ügyfél,
ha kiválasztja megtakarítás -> új megtakarítás opciót,
és hiányosan, kritériumoknak nem megfelelően tölti ki,
akkor megjelenik az információ, mit kell pótolni/javítani.


    US4: Átutalás számlák között
Story4:
Én, mint <bejelentkezett ügyfél> azt akarom,
hogy <számláim között tudjak utalni >,
amire azért van szükség, hogy <csoportosítani tudjam pénzemet >.

Acceptance criteria (elfogadási kritérium):
Létezik legalább 2 számla (folyószámla/megtakarítás) és ahonnan indul az utalás van pénz.

    Rule4.1: Sikeres átutalás
Example4.1:
Bejelentkezett ügyfél kiválasztja az átutalás opciót, megjelenik a választási lehetőség: induló és cél számla és az átutalás összege.
Az induló számlán megfelelő összeg van.
Outcome: sikeres utalás.

Gherkin formátum4.1:
Adott bejelentkezett ügyfél,
ha kiválasztja az átutalás opciót,
és kiválasztja mely számláról, melyik számláza és milyen összeget utalna,
akkor számlái között sikeres átutalást kezdeményezhet
és megjlenik a megtakarítási számlája, ahol látja az átutalt összeget.

    Rule4.2: Sikertelen átutalás
Example4.2:
Bejelentkezett ügyfél kiválasztja az átutalás opciót, megjelenik a választási lehetőség: induló és cél számla és az átutalás összege
Az induló számlán kisebb összeg szerepel, mint amennyit utalna.
Outcome: Sikertelen utalás (’Hiba The amount ($10000.00) requested for transfer is more than the available balance ($1586.38).)

Gherkin formátum4.2:
Adott bejelentkezett ügyfél,
ha kiválasztja az átutalás opciót,
és kiválasztja mely számláról, melyik számláza és milyen összeget utalna, ahol az összeg nagyobb, mint az induló számlán rendelekzésre álló összeg,
akkor az átutalás nem történik meg
és egy tájékoztató hibaüzenet jelenik meg.


    US5: Profil és frissítése
Story5:
Én, mint <bejelentkezett ügyfél> azt akarom,
hogy <profilom meg tudjam tekinteni és frissíteni>,
amire azért van szükség, hogy <online is ellenőrizhessem adataim és változtatni tudjam ezeket>.

Acceptance criteria (elfogadási kritérium):
Bejelentkezett ügyfél, saját profil betöltődik.

    Rule5.1: Profil adatai megjelennek
Example5.1: profil adatai megjelennek
Bejelentkezett ügyfél kiválasztja a saját profil opciót.

Gherkin formátum (given-when-then = adott-ha-akkor):
Adott bejelentkezett ügyfél,
ha kiválasztja a saját profilját,
akkor megjelennek regisztrációkor megadott adatai.

    Rule5.2: Sikeres frissítés
Example5.1: telefonszám frissítése
Bejelentkezett ügyfél kiválasztja a saját profil opciót és frissíti a telefonszámát (bármilyen adatot).

Gherkin formátum5.2:
Adott bejelentkezett ügyfél,
ha kiválasztja a saját profilját
és frissíti a telefonszámát,
és az elküld gombra nyom,
akkor megjelennek Profilja sikeresen frissül
és üzenetet kap: Siker Profil sikeresen frissítve.

    Rule5.3: Sikertelen frissítés
Example5.3: telefonszám frissítése
Bejelentkezett ügyfél kiválasztja a saját profil opciót és kitörli az cím mező adatait.

Gherkin formátum5.3:
Adott bejelentkezett ügyfél,
ha kiválasztja a saját profilját
és törli címét,
és az elküld gombra nyom,
akkor a egy üzenet jön, hogy ki kell tölteni az adott mezőt
és a frissítés nem történik meg.

    ///Tesztadtaaok létrehozása:
Bejelentkezés tesztelésénél:
Megadhatóak központilag a különböző tesztelendő kritériumoknak megfelelően.
Új megtakarítási számla létrehozásánál:
Megadható központilag a különböző tesztelendő kritériumoknak megfelelően.
Profil tesztelése:
Megadható központilag a különböző tesztelendő kritériumoknak megfelelően.



