# CandySpace Challenge
## Business Logic
The API service handles obtaining max 20 results and sorting in alphabetical order. The data is displayed without caching since the data do not require to be reaccessed or stored. The obtained data is maintained throughout the application using singleton dependency injection and view state is maintained using view model indepe
### Setting the Interfaces
### Deciding on the components
## The Architecture 
The project uses MVI(Model -View -Intent) which is basically an extension of the MVVM architecture. Since the data do not required to be saved to the memory, the Room intent has not been used for caching. The project was created in the following order.

### Model
Two data objects for User for viewing the user and for the List to include in the recyclerview were created.
### Retrofit
Retrofit API Services for both the data objects and entitiy-domain mappers were created to obtain mapped data. The mapping was done by using 
### View
### ViewModel
### Dependency Injection
### Repository

### Utilities
## Handling async network calls
My preferred method of handing network calls is via Coroutines. However, since the project required using RXJava2, I have used 
Use Retrofit2 for http requests
Use Kotlin instead of Java
Bonus points if you write any form of documentation (wiki, request for comments, readme, etc.)
Bonus points if you write any UI tests
