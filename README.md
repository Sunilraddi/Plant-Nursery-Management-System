#Before running the application :
Resolve the imports by adding the jar files from dist-> lib folder.


#For importing the database :
The database is created under MySQL 8.0. Simply extract the database by using MySQl Workbench. Name the new schema as "plantshop".

OR

a) Create a blank database named as "plantshop" in MySQL. b) Use that database; c) Open Command prompt. d) Open File explorer and copy the address of the bin folder of your MySQL file. e) Go to Command Prompt. Write cd and then paste the copied path.

eg. cd C:\Program Files\MySQL\MySQL Server 8.0\bin (The path or the version of the MySql may differ.)

f)Write command ->
mysql -h 127.0.0.1 -u root -p plantshop< and then paste the sql file's location.

eg: mysql -h 127.0.0.1 -u root -p plantshop<D:\DatabaseFile\Plantshop.sql

Here, "root" is the username and it may differ. Password can be "root" or user-side MySQL password.

If the prompt shows "The system cannot find the file specified.", check out if there is a space character in your filename. If thers is a space, rename that file or change the location of the SQL file. Or else look out if you are running the command prompt with admin privelege or not. If not, run command prompt with admin privelege.

You can refer : https://www.youtube.com/watch?v=sJ64ZiB6PUU
