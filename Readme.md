Here's an enhanced version of your **README** with more details, clarity, and formatting improvements.

---

# **Cowboy Game** 🤠🎯

## **Project Packaging**
To build the project and create a JAR file, run:

```sh
mvn clean package
```

This will generate the **`cowboy_game.jar`** file inside the `target/` directory.

## **Running the Game**
Execute the JAR file with the required argument:

```sh
java -jar cowboy_game.jar <number_of_cowboys>
```

### **Example**
To run the game with 5 cowboys:

```sh
java -jar cowboy_game.jar 5
```

## **Requirements**
- **Java 17+** (Check with `java -version`)
- **Maven** (Ensure it's installed with `mvn -version`)

## **Additional Commands**


### **Clean the Project**
To remove compiled files and reset the project state:
```sh
mvn clean
```