# Handling Exceptions and Responses in Spring and REST Applications

This project showcases how to handle exceptions and responses in Spring and REST applications. It provides examples of best practices and patterns for creating robust and maintainable code that handles errors and communicates with clients in a clear and consistent manner.


## Features

* Error handling: catch and handle exceptions, return appropriate HTTP error codes and error messages.
* Response handling: return responses in a structured and consistent format, with a clear indication of success or failure.

## Technologies

* Spring Boot: a popular framework for building web applications with Spring.
* Spring Data JPA: a module of Spring that provides support for data access and persistence using Java Persistence API (JPA).
* Spring MVC: a module of Spring that provides support for building web applications with Spring.
* H2 Database: a lightweight and fast in-memory database for development and testing purposes.
* Lombok: a library that helps to reduce boilerplate code in Java classes.
* ModelMapper: a library that simplifies object mapping and conversion between different models.

## Getting Started

To get started with this project, clone the repository and open it in your favorite IDE. You can run the application using the command `mvn spring-boot:run.`

## Endpoints

* [GET] /posts
* [GET] /posts/{id}
* [POST] /posts
* [PUT] /posts/{id}
* [DELETE] /posts/{id}

## Demo

For demonstration purposes, this project includes two custom exceptions: `PostNotFoundException` and `LongMessageException`.

The `PostNotFoundException` exception is thrown when the user attempts to get, update, or delete a resource by its ID, but the specified resource is not present. This is a common scenario in web applications, where users may request resources that do not exist, either due to typos or because the resource has been deleted.

The `LongMessageException` exception is thrown when the user attempts to create or update a resource with a message that exceeds a maximum length of `MAX_CHARACTERS`, which is set to 144 characters in this project. This is a common validation rule in web applications that allows for concise and clear messages, while preventing users from submitting excessively long or verbose messages that may cause problems with the application or the user interface.

Simply creating and throwing a custom exception is not enough to provide users with the necessary information through the API.

![Screenshot_2](https://user-images.githubusercontent.com/50873897/233795590-32786a02-38d1-4a0b-b3f5-c3d949946068.png)

As you can observe, by default, Spring doesn't have a predefined behavior for handling custom exceptions, and it will return the same response as before the exception was created.

![Screenshot_4](https://user-images.githubusercontent.com/50873897/233795604-73c125e7-7a97-4300-ab08-acc7c6c7afd5.png)

To address this issue, we need to create a class that handles specific exceptions and defines the appropriate behavior for our application when those exceptions are thrown. We can accomplish this by annotating the class with `@RestControllerAdvice`.

![Screenshot_5](https://user-images.githubusercontent.com/50873897/233796044-37740afa-6637-43d7-90bc-14675c5a9292.png)

Once we have done that, we can precisely define how our application should respond when it encounters the exception that we are targeting.

![Screenshot_7](https://user-images.githubusercontent.com/50873897/233796295-d051f1d3-7a1e-4e05-834a-55c3b51caf86.png)

In addition, I have created a custom `ErrorResponse` class to ensure that the existing error format provided to the user is preserved.

![Screenshot_8](https://user-images.githubusercontent.com/50873897/233796381-3acf8b60-5c4d-45b0-beb8-8cdd95948726.png)

By using `RestExceptionHandler` and `ErrorResponse`, we can achieve the desired result.

![Screenshot_9](https://user-images.githubusercontent.com/50873897/233796456-ec58baba-1720-45c1-9242-639c84aad24a.png)


## Contributing
If you find a bug or have a suggestion for improvement, please create a GitHub issue or submit a pull request. Contributions are welcome and I'll review and respond to your feedback as soon as possible.

## License
This project is licensed under the MIT License.
