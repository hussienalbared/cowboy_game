# **Cowboy Game** 🤠

## **Project Description**

The **Cowboy Game** is a simulation game where multiple
cowboys engage in a shooting game.


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


## Comments on the game fairness
The game is not entirely fair due to several factors:

1. **Shooting Direction**: The direction of shooting is determined by whether the shooter's HP is even or odd, creating a bias that could favor certain positions in the circle.
2. **Random Damage**: The random damage dealt (1-5 HP) can result in a cowboy being eliminated early due to bad luck, while another might survive longer with minimal damage.
3. **Shoot Again After a Kill**: A shooter gets another turn after eliminating a target, which increases their chances of winning by allowing them to attack multiple times in a row.
4. **Chance Over Strategy**: The game is largely driven by luck rather than strategy, with randomness in both shooting direction and damage dealt.

**Who’s Most Likely to Win?**
The first shooter has the initial advantage. If they get lucky with a kill, they can shoot again, increasing their chances. Cowboys who survive multiple rounds and get more turns also have a higher chance of winning. Overall, **the first shooter** and those who survive longer are most likely to win due to the game's heavy reliance on chance.