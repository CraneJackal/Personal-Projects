import java.util.Scanner;

public class Player {
   private String name;
   private int health;
   private int level;
   private int strength;
   private int defense;
   private int points;

    void newStats(){
        name = "Player";
        health = 100;
        level = 1;
        strength = 10;
        defense = 10;
        points = 0;
    }

    void resetStats(){
        points = level;
        health = 100;
        level = 1;
        strength = 10;
        defense = 10;
    }
    
    void getStats(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Level: " + level);
        System.out.println("Strength: " + strength);
        System.out.println("Defense: " + defense);
    }

    void upgradeStats(Scanner input){
        if (points == 0){
            System.out.println("You have no points to use");
            return;
        }

        int num = input.nextInt();

        while (points != 0){
            switch (num) {
                case 1:
                    health = health + (int)Math.round(10 + 1.1 * level);
                    points--;
                    break;
                
                case 2:
                    strength = strength + 10;
                    points--;
                    break;
                
                case 3: 
                    defense = defense + 2;
                    points--;
                    break;
                
                case 4:
                    return;
            
                default:
                     //check input. If input doesn't match option, repeat, if it does, execute based on option selected.
                    System.out.println("What stat would you like to upgrade?");
                    System.out.println("1. Health");
                    System.out.println("2. Strength");
                    System.out.println("3. Defense");
                    System.out.println("4. Return");
                    break;
            }
        }

        System.out.println("You have no more points left to use!");
    }

    void setName(String n){
        name = n;
    }
}
