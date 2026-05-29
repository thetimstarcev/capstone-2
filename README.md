#  🥪 DELIcious Sandwich Shop
A command-line (CLI) point-of-sale application built in Java
for DELI-cious, a custom sandwich shop. The app is designed
for in-store order management, allowing customers to fully
customize their sandwich orders, add drinks and chips, review
their order, and receive a receipt.
---
## ✨ App Features
### Core Features
- 🥪 **Custom Sandwich Builder:** choose size, bread, meat, cheese, toppings, sauces, and sides
- 🥤 **Add Drinks:** select small, medium, or large fountain drink
- 🍟 **Add Chips:** choose from Doritos, Lays, Cheetos, or Pringles
- 🧾 **Checkout:** review full order with itemized pricing before confirming
- 📄 **Receipt Generation:** saves a .txt receipt file named by date and time
- ❌ **Cancel Order:** cancel at any point and return to home screen

### Bonus Features
- ⭐ **Signature Sandwiches:** order a pre-built BLT or Philly Cheese Steak with one click
---
## ⚙️ Setup & Installation
### Prerequisites
- Java 17 or higher
- IntelliJ IDEA (recommended)
- Maven
### Steps
1. Clone the repository:
```bash
git clone https://github.com/thetimstarcev/capstone-2.git
```
2. Open the project in your IDE (IntelliJ recommended)
3. Make sure you have Java installed (JDK 17+)
4. Run the `App.java` file
---
## 📁 Project Structure
```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/pluralsight/
│   │       ├── enums/
│   │       │   ├── BreadType
│   │       │   ├── CheeseType
│   │       │   ├── MeatType
│   │       │   ├── SaucesType
│   │       │   ├── SidesType
│   │       │   ├── Size
│   │       │   └── ToppingsType
│   │       ├── App
│   │       ├── Cheese
│   │       ├── Chips
│   │       ├── Colors
│   │       ├── Drink
│   │       └── ...
│   └── resources/
│       └── receipts/
└── test/
```
---
## 📐 Class Diagram
### Original

### Latest

---
## 💡 Code Highlight
One of my favorite pieces of code is the **duplicate topping
validation** in `Sandwich.java`. The requirements state that
toppings, sauces, and sides cannot be duplicated on a sandwich.
To enforce this, I used Java streams with a lambda expression
to check if a topping already exists before adding it.

```java
public void addIngredients(Ingredients ingredient) {
    boolean alreadyAdded = regularIngredients.stream().anyMatch(i -> i.getName().equalsIgnoreCase(ingredient.getName()));
    if (alreadyAdded) {
        System.out.println("Yo, what's up with the " + ingredient.getName() + "? Lettuce escort you out of our sandwich shop.");
    } else regularIngredients.add(ingredient);
}
```
The `.anyMatch()` method with a lambda expression scans every existing topping and returns`true` if any name matches what the customer 
is trying to add — preventing duplicates cleanly
without needing a loop.
---
## 🚧 Challenges I Faced

**User Input Validation**
One of the biggest challenges was managing user input validation without crashing the app. Handling every possible wrong input 
while keeping the flow of the app smooth required careful use of loops and null checks throughout the program. For example, 
when selecting sandwich size or bread type, the app had to keep prompting the user until a valid option was chosen rather than
crashing or skipping ahead with a null value.
---
## 🚀 Future Improvements
- **GUI Interface:** Replace the CLI with a graphical interface for a more modern experience
- **More Signature Sandwiches:** Expand the pre-configured sandwich menu with more options
- **Loyalty & Rewards System:** Allow customers to earn and redeem points on every order
- **Order History:** Let customers quickly reorder their favorite previous meals
- **Calorie Tracking:** Display calorie information for each topping and sandwich
- **Multiple Language Support:** Make the app accessible to non-English speaking customers
---
## 📸 Screenshots

---
## 👤 Author
**Tim Startsev**, Year Up United — Spring 2026

