# Harvest Hills Game
This is a simulation game where you can run your own farm and grow crops, rear animals, and manage your farm economy. The game runs on a cycle-based system, with each cycle consisting of a day and a night. You earn passive income every day by selling crops or animal products, and you can earn more by hiring farmers and investing in crop and animal affinities.

# Design patterns

## Factory Pattern:

I would use the Factory pattern to create new farms when the capacity of the existing farm is reached. The Factory pattern would help to decouple the creation of the farms from the clients and provide flexibility in creating new farms.

## Decorator Pattern:

I would use the Decorator pattern to add new affinities to farmers, animals, and crops. This pattern would help to dynamically add new functionalities to the objects without modifying their core functionalities.

## Singleton Pattern

## Mediator Pattern:

I would use the Mediator pattern to handle the simulation's tick-based events. This pattern would help to centralize the control of events and manage the interdependencies between different components.

# Requirements
+ Gradle
+ Java JDK 15 or higher