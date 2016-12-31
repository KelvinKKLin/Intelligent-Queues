# Intelligent Queues
Intelligent Queues is a simulation that simulates queues in a shopping mall. It was created in order to experiment with different properties of queues, and how changing different parameters (i.e. the number of queues, the duration of queues available, the amount of time customers spend shopping) affect the length of the queue and the amount of overtime needed to process all of the customers in the store.

**Note: ** As of December 29<sup>th</sup>, this project is still a work in progress. Users of this project may expect updates as more features are added to this program.

## Goals
The goal of this project is to make a comprehensive simulation of queues in shopping malls. This program will attempt to capture as many aspect of shopping mall queues as possible.

After the simulation is deemed "complete", a genetic algorithm will be made to optimize certain parameters of shopping mall queues. Doing so will yield near-optimal solutions to questions such as:

1. Assume that opening a lane (queue) costs money at a given rate (e.g. $1 per minute), and it can be determined beforehand how long shoppers shop at the store before checking out. Given a schedule of shoppers (i.e. the likelihood that a shopper will enter a store at any given point in time), what is the minimum amount of money needed to be spent in order to process all shoppers while minimizing the amount of overtime?
2. Assume that constructing a lane requires a one time fee; however, the lane may be used indefinitely for free afterwards. How will this change the results found in the question above. That is, given a schedule of shoppers (i.e. the likelihood that a shopper will enter a store at any given point in time), what is the minimum amount of money needed to be spent in order to process all shoppers while minimizing the amount of overtime?
3. Assume that constructing a lane requires a one time fee; however, the lane may be used indefinitely for free afterwards. Moreover, customers do not like waiting in long lines. How many lanes should be constructed such that the average length of the lane is minimized, as well as the cost to construct all of the lanes?

Note that this project is not limited to answering the above questions, but instead, is interested in tackling the properties of queues as a whole.

## Compiling the Source Code
The source code can be compiled using the provided Makefile.

Type `make` to compile the source code. To run the source code, type `./run.sh` in the terminal.

## Progress of the Project
No customizations are available at this point in time; however, users will be able to enter their own parameters in future releases. The project is still currently focused on creating a comprehensive queue simulation, ideally with a basic GUI.

The Genetic Algorithm will be introduced once a GUI has been made.

## Authors
1. Kelvin Lin (Software Engineering and Management, Level 3)

