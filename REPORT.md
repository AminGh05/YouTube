# Reports on the project YouTube
![Static Badge](https://img.shields.io/badge/SBU_University-b?logo=bookstack&logoColor=red&labelColor=black&color=green)
![powered by](https://img.shields.io/badge/Powered_By-JAVA-blue)

## Table of contents 🧾

- [Introduction 💁](https://github.com/Amin-Gh-05/YouTube/new/Reports.md#first-of-all)
- [Objectives 🎯](https://github.com/Amin-Gh-05/YouTube/new/Reports.md#objectives-)
- [UML Designs 🧭](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#uml-design)
- [The Process ♟](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#the-process)
  - [Phase 1](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#phase-1)
  - [Phase 2](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#phase-2)
  - [Phase 3](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#phase-3)
- [Ideas And Chalenges 🧠](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#ideas-and-chalenges)
- [Creators 👩🏽‍💻](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#program-made-by)
- [Special Thanks to...🙏](https://github.com/Amin-Gh-05/YouTube/edit/Reports/Report.md#special-thanks-to)
- [Resources 📚](https://github.com/Amin-Gh-05/YouTube/new/Reports.md#resources)

## First of all💁‍♂️

<p align="center">
  <img src = "https://github.com/Amin-Gh-05/YouTube/blob/Reports/logo.png">
</p>


This app is our final project for [Advanced Programming](https://github.com/Advanced-Programming-1402) course at Shahid Beheshti University. The program is based on Java and we also used some other languages such as CSS and Html.
<br>The design pattern used for this project is MVC. For further information on this design pattern check the ***The Process*** section.

## Objectives🎯

- Object Oriented Programming(OOP) Concepts
- Database Design
- Multithreading Concepts
- Socket Programming
- Designing Graphical User Interface With JavaFX
- Data Encryption
- Design Patterns

## UML Designs🧭
<p align="center">
  <img src = "https://github.com/Amin-Gh-05/YouTube/blob/Reports/client-uml.png">
  <img src = "https://github.com/Amin-Gh-05/YouTube/blob/Reports/server-uml.png">
</p>

## The Process♟
### Phase 1
At the beggining of the projects, we had several meetings discussing different subjects such as:
1. Which design pattern should we use?
<br>There was a wide range of patterns we could use, patterns like Bridge, Abstract factory, Composite and so on. At last we picked MVC design pattern(short for model-view-controler).
<br>MVC separates the different aspects of an application (data, UI, and logic), making the code easier to understand, maintain, and modify.
Since the components are independent, changes to one component do not affect the others, allowing for easier updates and modifications and since the parts are seperated, multiple developers can work on different components simultaneously, which makes this pattern our finest option to work on as a group.
2. How to create our API?
<br>We used gson library to send request and recieve response which let us exchange different objects easier and faster than normal string.
4. How should we manage the database?
<br>Our database has been rewritten almost three times, adding new objects and attributes in each time. This database uses CRUD designing, short for create-read-update-delete.
<br>We also used DTOs which is short for "Data Transfer Object" to make data exchange faster and more efficient.
6. Basic map of the program and division of labour
<br>On this phase, the program was divided into Backend and Frontend. But in the process, we had a lot of time working on the same file or debuging two parts which were connected in functionality.

### Phase 2
On this phase, we started designing all FXML views in the project, filling them with buttons and setting alerts and notifications. 
1. Mediaplayer
<br>FIRST we used javafx mediaPlayer and expand it to the point that in video display, the slidebar on the bottom will fade automatically after a few seconds. You can also change video's rate or mute it.
2. Connecting controllers using fxmlLoader
<br>About half of the program is being executed on our main panel. On this panel, we load other panels such as video view, channels, profile etc.
4. Alerts and notifications
<br>In case to show some alerts, we used java's own notification class from controsfx library. 

### Phase 3

And besides our frontend, the connection our sockets and different part of program have is quite fascinating. The data exchange between server and client was a part where we could show our socket programming skills.

### Phase 4
Bonus Features:
1. server log
<br>Every interaction that server does is being saved and written into a file so you can always access all we have done from the beginning till now.
2. Short videos
<br>The difference between short and video is in size and the media player that plays the clip.
3. Comment like
4. Some studio features

### Ideas And Chalenges🧠

#### MVC design pattern
As said before, our design pattern is in MVC format. This design is built based on connections, like UI, interface with functions, and functions with database.<br>In client package, we have a Controller package which is full of controllers connected to our fxml View files. Also, there is a Model package including all DTOs and a network folder which includes classes that connect client to server using Request class as API, Downloader as a reciever for video files, FileTransfer thread, and Uploader class which is designed to send videos to server.
<br>Since the server doesn't have anything to do with UI in this program, there is no voice 

#### Database
<p align="center">
  <img src = "https://github.com/Amin-Gh-05/YouTube/blob/Reports/Erd.png">
</p>
CRUD is an acronym for CREATE, READ(SELECT), UPDATE, and DELETE statements in SQL Server. CRUD in database terms can be mentioned as Data Manipulation Language (DML) Statements as well. Data Manipulation Language is used to manage or manipulate the data present inside database Tables.
<br>DTO stands for Data Transfer Object which is a design pattern. It is one of the EPA patterns which we call when we need to use such objects that encapsulate and aggregate data for transfer. A DTO is similar to a data structure, but like a data structure, it doesn't contain any business logic.

#### Download and send files
We use byte arrays to exchange videos between server and client. Every file transfer needs a FileTransfer thread which will be running parallel to our main threads, this system will let us load videos and images while loading an fxml panel.
<br>However, since the server has nothing to do with user and view, the only package we have for server is a Model package including DTOs, a network package(kind of similiar to client network package), and a database including DatabaseManager and ClientService which connects and translates json objects sent by Request class.

#### API
Our API is built based on gson library which is a library for serializing/deserializing java objects to JSON and back.

#### FXML loader
In this program, we normally don't change scenes, most of panels are being loaded on the main panel and studio panel using FXMLLoader and passing controllers. 

#### History
Each time the user logins, program builds(or if it already exists, reads) a file from program's cache. With each click on any thumbnail, updating the file using serialization.<br>Serialization in Java allows us to convert an Object to stream that we can save as file for later usage.
<br>While a video is playing, every five second the file updates the video's last seen second.


## Program Made By👩🏽‍💻
- Amin Ghoorchian
- AmirAli Araghi
- Sepide Hoseini

## Special thanks to🙏
- Teacher: Dr.SaeedReza Kheradpishe
- Head TA: Mahan Madani
- Mentor: Shayan Shahrabi

## Resources📚

- https://refactoring.guru/design-patterns
- https://www.geeksforgeeks.org
- https://sqlbolt.com/



