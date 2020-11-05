## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Service with doc files

## Technologies
Project is created with:
* Java EE version: 8
* EJB version: 3.1
* JSP
* Hibernate version: 5.4.12
* Apache Commons IO version: 2.2
* Apache Derby version: 10.14.2
* Maven version: 3.6.3
* jQuery version: 3.4.1
* Bootstrap version: 4.4.1
* Font Awesome version: 5.12.1
* Payara Server version: 5.193
* Apache NetBeans version: 11.2

## Setup
1. Install Java 8 Development Kit
2. Download and install Apache NetBeans 11.2
3. [Add Payara Server to NetBeans](https://blog.payara.fish/adding-payara-server-to-netbeans)
4. Clone this repository
5. [Configure JavaDB in NetBeans](https://web.csulb.edu/~mopkins/cecs323/netbeans.shtml)  
in *Java DB Installation*: **_Payara_Server_location\javadb_**  
in *Database Location*: **_..\docsrepo\derby_**
6. Start Java DB server
7. Open *docsrepo* (select option *Open Required Projects*) in NetBeans
8. Build *docsrepo*
9. Deploy *docsrepo-ear*
10. Open *docsrepo-web* in a web browser on *http://localhost:8080/docsrepo-web/*
