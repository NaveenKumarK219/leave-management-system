# Leave Management System
## Simple Application For Managing Employee Leaves.

### Description
Leave Management System is a web application for managing employee leaves. This application provides all the things that a project/team needs. Through this application one can easily manage leaves. Application maintenance is easy.

### Requirements
* Java 7 or higher.
* Maven
* Postgres Database
* Run on Tomcat 7 (you can run on later versions)

### How To Run
* As it's a Maven Project, you can call `mvn install` in terminal(in project directory) to get a war file.(You can find it in **target** folder)
* You need to have Postgres database to import tables from app-DB-Script.sql (`psql -U postgres lms < app-DB-Script.sql`).
* Default username is `manager@email.com` and password is `123456`.
* You can find the file **app-DB-Script.sql**  in **resources** folder.
* Deploy the war file to the tomcat server and visit localhost:8080/leave-management-system

## Application Overview
### Login Page (Initial Opening Page)
![Login Page](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Leave%20Management%20System.png)

### Home Page (Options provided for data variation)
![Home Page](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Home.png)

![Home Page](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Home(1).png)

![Home Page](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Home(2).png)

![Home Page](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Home(3).png)

### Manage Users
![Manage Users](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Manage%20Users.png)

### Edit User
![Edit User](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Edit%20User.png)

### Manage Leaves
![Manage Leaves](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Manage%20Leaves.png)

### Apply Leave
![Apply Leave](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Apply%20Leave.png)

### My Leaves
![My Leaves](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20My%20Leaves.png)
![My Leaves](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20My%20Leaves(1).png)

### Change Password
![Change Password](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Change%20Password.png)

![Change Password](https://github.com/NaveenKumarK219/leave-management-system/blob/master/resources/screenshots/Screenshot_2018-11-12%20Change%20Password(1).png)
