# Api Downloader

The project was created using Spring Framework with Maven on Java 17.

### How to prepare project using IntelliJ

You need to open project in IntelliJ.
Then you need to reload all maven project to download required libraries.
After that you can launch project using prepared launch option in IntelliJ.

### How to prepare project using terminal
Open terminal in project directory

First you need to download required maven libraries by entering below this command

``mvnw clean install -U``

Then you need to compile project

``mvnw package``

To launch the app u can use command below 

``mvnw spring-boot:run``

### How use created program.

After launching program open website browser on http://localhost:8080.
On the website you can click button to download data from API.
Downloaded data will be saved in user's file directory inside folder Posts.
