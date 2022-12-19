# Travel_Website
Website calatorii - planificare si rezervare calatorii
Database (MySQL) + Spring Boot (Backend) - prezentare 06.12.2022
Tabele:
User
- user_id
- role_id
- username
- parola
- cnp
- adresa
- telefon
- email
- gen - M, F, Other
- level_discount - 10%, 15%, 20%
Role
- role_id
- nume - Admin, AgentTuristic, Client, AngajatHotel
Rezervare
- rezervare_id
- user_id
- hotel_id
- nr_camere
- nr_persoane
- pret
- regim_masa - mic dejun, demipensiune, all inclusive, fara masa
- start_date
- end_date
- data_creare_rezervare
- pret_suplimentar_facilitati
Hotel
- hotel_id
- poza_hotel
- oras
- nr_total_camere
- regim_mase - poate fi una sau mai multe acceptate
- pret_per_noapte
- spa - da/nu
- gym - da/nu
- transfer_hotel_aeroport - da/nu

1.
1.
2.
3.
2.
3.
4.
5.
6.
7.
1.
2.
3.
4.
5.
6.
7.
8.
9.
10.
11.
12.
8.
1.
2.
3.
4.
5.
9.
–
Relatiile dintre tabele sunt:
Un User poate avea mai un singur rol, un rol poate fi asignat la mai
multi useri
Un User poate avea mai multe rezervari si o anumita rezervare
poate fi facuta de un singur user
Un hotel poate avea mai multe rezervari, intr-o rezervare poate fi
un singur hotel
Creati clasele de model ca si entitati in java, in pachetul numit model
Creati interfetele pentru level-ul de repository
Creati DTOs (Data Transfer Objects) pentru clasele de model
Creati clasele de Service + Interfetele
Creati clasele pentru layer-ul de controller
In layer-ul de controller vom avea expuse urmatoarele endpointuri
Creare user
Editare user dupa id
Afisare userii
Creare rezervare
Creare hotel
Editare rezervare
Stergere rezervare
Afisare hoteluri din sistem
Afisare rezervari pentru un anumit user id
Afisare hotel dupa hotel id
Afisare pret total a tuturor rezervarilor pentru un anumit user id
Afisarea tuturor rezervarilor unui anumit hotel dupa id
Mentiuni
aplicati discountul asupra unei rezervari in functie de level-ul
fiecarui utilizator
parola se genereaza automat (max 12 caractere, un caracter
special si un numar)
validare sa fie email valid
validate sa fie cnp valid (validare sa fie doar cifre si nr max si min
de caractere)
optional se poate adauga un enum cu mai multe monede posibile
(RON, EUR, USD)
Toate endpointurile vor fi testate initial din postman
