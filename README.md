# Dad Jokes stateside exercise
Dad Jokes API implementation for Stateside/Jane.com.
## Requirements:
- Create a publicly accessible GitHub Repo and share the link with Stateside.
- Implement the API for Random Joke and Joke Count: DadJokes.io
- Basic Free Plan will be sufficient for the exercise
- Presentation is up to you
The solution provided has some advantages and disadvantages. Here's a short list for both of them.
## Advantages:
* **Modularity and Separation of Concerns**: By structuring your code into separate classes like DadJokes, DadJokesSync, DadJokesAsync, and JSONParser, we're following the principles of modularity and separation of concerns. Each class has a specific responsibility, making your codebase more organized and maintainable.
* **Easy Testing**: The separation of concerns allows for easier unit testing. You can test each class in isolation by mocking or stubbing its dependencies. This helps ensure that each component functions correctly on its own.
* **Reusability**: The abstract DadJokes class serves as a common interface that can be extended to create different implementations (sync and async). This reusability can be helpful if you need to add more implementations in the future.
* **Flexibility**: By using inheritance, you can easily switch between sync and async implementations without affecting the overall structure of the code. This flexibility is especially useful when requirements change or when you need to optimize performance.
* **Encapsulation**: By encapsulating the logic related to fetching jokes and parsing responses within specific classes, you're adhering to the principles of encapsulation. This makes it easier to manage changes and updates to this logic in the future.
* **Visibility into Application Behavior**: Logs provide a real-time record of what's happening within your application. By examining the log messages, developers can understand the flow of execution, the values of variables, and the interactions between different components.
## Disadvantages:
* **Tight Coupling**: While the architecture promotes separation of concerns, it can still lead to tight coupling between classes, especially when inheritance is used extensively. Changes in the base class may affect its subclasses, potentially causing unintended consequences. This is specially related with the _JSONParser_ class
* **Single Responsibility Principle (SRP)**: Although you've separated the responsibilities into different classes, the DadJokesSync and DadJokesAsync classes still have multiple responsibilities. They handle both API requests and response parsing. This might violate the SRP and make the classes harder to maintain. For this specific use case a different approach was considered overkilling.
* **Synchronous vs. Asynchronous**: While offering both synchronous and asynchronous implementations is valuable, it can also introduce complexity. Developers need to be aware of the implications of using one approach over the other, and you may need to handle threading and concurrency concerns.
* **Testing Effort**: Unit testing is crucial, but it also requires additional effort. Not all classes has been properly tested. Code coverage is not enough for a production product.