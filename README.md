 # Kotlin RESTEasy (JAX-RS) PoC
 This project is a PoC of using Kotlin and RESTEasy (JAX-RS), it showcases the following features:
 * Defining GET, POST, DELETE, and PUT endpoints using annotations 
 and the possibility of defining the following parameters using annotations:
    * Query parameters
    * Header parameters
    * Path parameters
 * Serializing objects to JSON and de-serializing JSON to objects
 
 Note: It is assumed that you have basic knowledge of Kotlin and JAX-RS.
 
## Installation
 1. Clone this repository

## Running the project
Run the following command in the root directory of the project: `gradlew appRun`. This will download gradle, download the required dependencies and run the project in Tomcat.

## About

### Defining endpoints
Defining endpoints is no different from defining endpoints in Java. As you can see in `PersonEndpoint.kt` and `HeaderEndpoint.kt` endpoints and parameters are easily defined using JAX-RS annotations.

### (de-)Serialization
When it comes to (de-)serialization with RESTEasy, it is common to make use of the Jackson library. In Java it is as easy as adding Jackson as a dependency, in Kotlin some extra work is required. 
The reason for this is the fact that Kotlin data classes don't have default constructors (which Jackson requires for de-serialization). 
To solve this, an additional library has been added `jackson-module-kotlin` which has to be registered as the ObjectMapper for JSON de-serialization. In this case this has been done using the JAX-RS @Provider annotation, see `JSONConsumer.kt` for the implementation.

 

 
 
 
  
 
 
