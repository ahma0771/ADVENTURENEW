package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Room[] rooms = new Room[9];
        int currentRoom = 0;

        System.out.println("__//WELCOME TO THE LITTLE ADVENTURE\\\\__");

        Character sami = new Character(100, 2, 10, "Hand");
        sami.getInventoryString();
        Monster spider = new Monster(50,5,"spider");
        Monster snake = new Monster(60,10,"snake");
        Monster bear = new Monster(100, 15,"bear");
        Monster tiger = new Monster(40,20,"tiger");



        Room room1 = new Room("Room 1", true, "I see a huge dead monster in courtyard", "bow");
        Room room2 = new Room("Room 2", false, spider, "there is a yellow penguin in the room");
        Room room3 = new Room("Room 3", false, snake, "i see a couple of mega seeds on the ground");
        Room room4 = new Room("cake", "Room 4", false, "im inside a hut with a lot of books and i see a bundle of keys on the floor");
        Room room5 = new Room("Room 5", false, "there is a blue melon", "sword");
        Room room6 = new Room("Room 6", false, bear, "im inside a closet and there is a banana stickin out of a coat");
        Room room7 = new Room("pie", "Room 7", false, "inside the bathroom i see a scapel on the floor and a overflowing bathtub its crimson red water spilling out i bel");
        Room room8 = new Room("apple", "Room 8", false, "There is a spoon on the floor with my name on");
        Room room9 = new Room("Room 9", false, tiger, "There is a eggplant on the floor");

        room1.setDirections(null, room4, room2, null);
        room2.setDirections(null, room5, room3, room1);
        room3.setDirections(null, room6, null, room2);
        room4.setDirections(room1, room7, room5, null);
        room5.setDirections(room2, room8, room6, room4);
        room6.setDirections(room3, room9, null, room5);
        room7.setDirections(room4, null, room8, null);
        room8.setDirections(room5, null, room9, room7);
        room9.setDirections(room6, null, null, room8);

        rooms[0] = room1;
        rooms[1] = room2;
        rooms[2] = room3;
        rooms[3] = room4;
        rooms[4] = room5;
        rooms[5] = room6;
        rooms[6] = room7;
        rooms[7] = room8;
        rooms[8] = room9;

        while (true) {
            Scanner input = new Scanner(System.in);
            Room temptCurrentRoom = null;

            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].isCurrentRoom()) {
                    temptCurrentRoom = rooms[i];
                    break;
                }

            }

            if (!temptCurrentRoom.hasWeapon().equals("no weapon")){
                System.out.println("This room has a weapon: " + temptCurrentRoom.hasWeapon());
                System.out.print("Do you want to equip this weapon?");
                String inputUser = input.nextLine();

                switch (inputUser){
                    case "yes":
                        sami.equipWeapon(temptCurrentRoom.hasWeapon());
                    case "inventory":
                        String[] inventory = sami.getInventory();
                        for (int i = 0; i < inventory.length; i++){
                            if (inventory[i] == null){
                                inventory[i] = temptCurrentRoom.hasWeapon();
                                break;

                            }
                        }
                        sami.setInventory(sami.getInventory());
                }
            }

            if (!temptCurrentRoom.hasFood().equals("no food")){
                System.out.println("This room has food: " + temptCurrentRoom.hasFood());
                System.out.println("Do you want to eat this food?");
                System.out.println("type yes if you want to eat, type no if you are full health, type inventory if you want to put it in your inventory");
                String inputUser = input.nextLine();

                switch (inputUser){
                    case "yes":
                        sami.eat(temptCurrentRoom.hasFood());
                    case "inventory":
                        String[] inventory = sami.getInventory();
                        for (int i = 0; i < inventory.length; i++){
                            if (inventory[i] == null){
                                inventory[i] = temptCurrentRoom.hasFood();
                                break;

                            }
                        }
                        sami.setInventory(sami.getInventory());
                }
            }

            if (temptCurrentRoom.hasMonster()){
                System.out.println("This room has a monster: " + temptCurrentRoom.getMonster().getName());
                System.out.println("Do you want to attack or flee?");
                System.out.println("type attack, or flee");
                String inputUser = input.nextLine();

                switch (inputUser){
                    case "attack":
                        int numberOfAttacks = (temptCurrentRoom.getMonster().getHealth() / sami.getDamage())-1;
                        int fight = numberOfAttacks*temptCurrentRoom.getMonster().getDamage();
                        if (sami.getHealth()>fight){
                            System.out.println("You defeated " + temptCurrentRoom.getMonster().getName());
                            sami.damageTaken(fight);
                            System.out.println("your health is currently at " + sami.getHealth());
                        } else {
                            System.out.println("you're dead");
                            System.exit(0);
                        }


                    case "flee":
                        break;
                }
            }

            System.out.print("Where do you want to go?: ");
            String inputUser = input.nextLine();


            switch (inputUser) {
                case "inventory":
                    sami.getInventoryString();
                    System.out.print("what index do you want to use? ");
                    sami.useInventory(input.nextInt());
                    break;
                case "go n":
                case "go north":

                    for (int i = 0; i < rooms.length; i++) {
                        if (rooms[i].isCurrentRoom()) {
                            if (rooms[i].getNorth() == null) {
                                System.out.println("You can't go in that direction");
                            } else {
                                rooms[i].setCurrentRoom(false);
                                currentRoom = i-3;
                                rooms[i].getNorth().setCurrentRoom(true);
                                System.out.println("You are now in " + rooms[i].getNorth().getName());

                            }
                            break;
                        }

                    }
                    break;
                case "go s":
                case "go south":
                    for (int i = 0; i < rooms.length; i++) {
                        if (rooms[i].isCurrentRoom()) {

                            if (rooms[i].getSouth() == null) {
                                System.out.println("You can't go in that direction");
                            } else {

                                rooms[i].setCurrentRoom(false);
                                currentRoom = i+3;
                                rooms[i].getSouth().setCurrentRoom(true);
                                System.out.println("You are now in " + rooms[i].getSouth().getName());
                            }
                            break;
                        }

                    }
                    break;
                case "go w":
                case "go west":
                    for (int i = 0; i < rooms.length; i++) {
                        if (rooms[i].isCurrentRoom()) {

                            if (rooms[i].getWest() == null) {
                                System.out.println("You can't go in that direction");

                            } else {
                                rooms[i].setCurrentRoom(false);
                                currentRoom = i-1;
                                rooms[i].getWest().setCurrentRoom(true);
                                System.out.println("You are now in " + rooms[i].getWest().getName());
                                break;
                            }
                        }

                    }
                    break;
                case "go e":
                case "go east":
                    for (int i = 0; i < rooms.length; i++) {
                        if (rooms[i].isCurrentRoom()) {

                            if (rooms[i].getEast() == null) {
                                System.out.println("You can't go in that direction");
                            } else {
                                rooms[i].setCurrentRoom(false);
                                currentRoom = i+1;
                                rooms[i].getEast().setCurrentRoom(true);
                                System.out.println("You are now in " + rooms[i].getEast().getName());
                            }
                            break;
                        }

                    }
                    break;
            }
            switch (inputUser) {
                case "look":
                    System.out.println("You are now in " + rooms[currentRoom].getName());
                    System.out.println("Items: " + rooms[currentRoom].getItem());

                    break;
                case "help":
                    System.out.println("Commands:");
                    System.out.println("U can use one of the following commands to navigate around in the game 'go east/go north/go south/go west'.");
                    System.out.println("Type 'look' - Use the command to what is around you .");
                    System.out.println("Type 'exit' - to quit the game.");
                    break;
                case "exit":
                    break;
            }
        }
    }
}
