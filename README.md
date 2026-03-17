# Transportation System - Activity 3

## Project Description
This Java program simulates a bus transportation system where users can enter bus and passenger details, book tickets, and manage transactions. It demonstrates OOP concepts and exception handling.

## How It Works
1. User enters bus details (number, capacity, route, driver)
2. User enters passenger details (name, phone)
3. User adds money to wallet and books a ticket
4. System displays all operations performed

## Exceptions Implemented

| Exception | Location | Cause | Handling |
|-----------|----------|-------|----------|
| **InputMismatchException** | Main.java (scanner) | User enters text instead of numbers | Displays error message, program continues |
| **IllegalArgumentException** | Constructors, addMoney() | Empty fields, negative values, invalid data | Prevents object creation with invalid state |
| **IllegalStateException** | Bus.start(), Passenger.book() | Wrong operation order (starting running bus) | Ensures valid operation sequence |
| **ArithmeticException** | Ticket.calcFare() | Invalid price calculation | Returns 0, displays error |

## Code Structure
- **Abstract Classes:** Vehicle, Person
- **Interfaces:** Bookable, Maintainable
- **Concrete Classes:** Bus, Passenger, Driver, Ticket

## How to Run
```bash
javac *.java
java Main
