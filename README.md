# avaj-launcher

Project itself is to design a Simulation for different type of aircraft and their interaction with the weather. A UML diagram is provided with all the minimum classes and attributes needed to be implemented. After we had to account for a few rules which are:


* Coordinates are positive numbers.
* The height is in the 0-100 range.
* If an aircraft needs to pass the upper limit height it remains at 100.
* Each time an aircraft is created, it receives a unique ID. There can’t be 2 aircrafts
with the same ID.
* If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters
from the weather tower and logs its current coordinates.
* When a weather change occurs, each aircraft type needs to log a message, as seen in
the example. The message format is: TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.
A funny message will be appreciated during the correction.
* Each time an aircraft registers or unregisters to/from the weather tower, a message
will be logged.
