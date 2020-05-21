# Spring MVC

## 目录

* [1. Wiki](#1-wiki)
  + [1.1 What is Spring mvc?](#11-what-is-spring-mvc-)
  + [1.2 Understanding the flow of Spring Web MVC](#12-understanding-the-flow-of-spring-web-mvc)
  + [1.3 Advantages of Spring MVC Framework](#13-advantages-of-spring-mvc-framework)
* [2. Quickstart](#2-quickstart)



## 1. Wiki

### 1.1 What is Spring mvc?

A Spring MVC is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern. It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.

A Spring MVC provides an elegant solution to use MVC in spring framework by the help of  **DispatcherServlet**. Here, **DispatcherServlet** is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.



<div align="center"> <img src="spring-web-model-view-controller.png" width="70%"/> </div><br>





### 1.2 Understanding the flow of Spring Web MVC
<div align="center"> <img src="1.png" width="70%"/> </div><br>

- As displayed in the figure, all the incoming request is intercepted by the DispatcherServlet that works as the front controller.
- The DispatcherServlet gets an entry of handler mapping from the XML file and forwards the request to the controller.
- The controller returns an object of ModelAndView.
- The DispatcherServlet checks the entry of view resolver in the XML file and invokes the specified view component.



### 1.3 Advantages of Spring MVC Framework

- **Separate roles** - The Spring MVC separates each role, where the model object, controller, command object, view resolver, DispatcherServlet, validator, etc. can be fulfilled by a specialized object.
- **Light-weight** - It uses light-weight servlet container to develop and deploy your application.
- **Powerful Configuration** - It provides a robust configuration for both framework and application classes that includes easy referencing across contexts, such as from web controllers to business objects and validators.
- **Rapid development** - The Spring MVC facilitates fast and parallel development.
- **Reusable business code** - Instead of creating new objects, it allows us to use the existing business objects.
- **Easy to test** - In Spring, generally we create JavaBeans classes that enable you to inject test data using the setter methods.
- **Flexible Mapping** - It provides the specific annotations that easily redirect the page.



## 2. Quickstart



