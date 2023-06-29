# jsp
 Digital Hanaro JSP Course

<i>JSP (JavaServer Pages) is a technology that allows the creation of dynamic web pages using Java. It combines HTML or XML templates with embedded Java code, enabling the development of server-side applications with dynamic content generation. JSP is part of the Java EE (Enterprise Edition) platform and is commonly used in web development.

some key aspects and concepts of JSP:

1. Dynamic Web Pages: JSP enables the creation of dynamic web pages by embedding Java code within HTML or XML templates. This allows the generation of content that can vary based on user input, database queries, or other factors.

2. Servlet-based Technology: Underneath the JSP technology, the Java code embedded in JSP pages is converted into servlets. Servlets are Java classes that handle HTTP requests and generate responses. JSP simplifies the process of creating servlets by providing a more convenient syntax for web page development.

3. JSP Tags: JSP pages utilize tags to encapsulate Java code and control the page's behavior. There are three types of tags in JSP:

 Directives: These are used to provide instructions to the JSP container during page translation and execution. For example, the <%@ page %> directive is used to define page-specific attributes.
 Declarations: Declarations are used to define variables and methods that can be accessed within the JSP page. They are typically placed outside the HTML template.
 Scriptlets and Expressions: Scriptlets (<% %>) allow the embedding of Java code directly within the HTML template. Expressions (<%= %>) are used to evaluate Java expressions and output their results directly into the HTML template.

4. Standard Actions: JSP provides a set of standard actions, which are XML-like tags used to perform common tasks such as including other files, looping over collections, conditionally displaying content, and forwarding requests to other resources. These actions simplify the development process by abstracting complex functionality into reusable components.

5. Tag Libraries: JSP allows the creation and use of custom tag libraries. Tag libraries provide a way to extend the functionality of JSP pages by defining custom tags with specific behavior. These tags encapsulate complex logic and can be used across multiple JSP pages, promoting modularity and code reuse.

6. JSP Expression Language (EL): JSP EL is a simplified syntax for accessing and manipulating data within JSP pages. It provides a convenient way to retrieve and display data from Java objects, session attributes, request parameters, and more. EL expressions are represented using ${} syntax.

7. MVC Architecture: JSP is often used in conjunction with the Model-View-Controller (MVC) architecture for building web applications. JSP pages are typically used as the view component, responsible for displaying data and capturing user input. The business logic and data manipulation are handled in the model and controller components, typically implemented using Java classes and servlets.

8. JSP Lifecycle: JSP pages have a well-defined lifecycle consisting of translation, initialization, request processing, and destruction phases. During the translation phase, JSP pages are converted into Java servlets. Initialization involves the creation of necessary objects and resources. Request processing handles the actual execution of the JSP page's code and generation of the response. Destruction releases any acquired resources when the JSP page is no longer needed.</i>
