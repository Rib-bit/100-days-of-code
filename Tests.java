//Composition 1/12 - tests

//I lost the tests :( I'll recreate the methods real quick

Case theCase = new Case(_args_);
Monitor theMonitor = new Monitor (_args_);
Motherboard theMotherboard = new Motherboard(_args_);

PC thePC = new PC(theCase, theMonitor, theMotherboard); // assembling an object out of its components. Can have more than one class from which to inherit.

//****** exercises tests

Table whiteTable = new Table();
Drawer messDrawer = new Drawer();
Plant george = new Plant("schefflera", "George", false);
PC schnabelfear = new PC(theCase, theMonitor, theMotherboard);

LivingRoom livingRoom = new LivingRoom(4, true, "paved", 2, whiteTable, messDrawer, george, schnabelfear);

livingRoom.getTable().shapeTable(); //one way to call methods with components. Another one would be to create a public method in the LivingRoom class
livingRoom.doRandomStuff();// And call it like so

