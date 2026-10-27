import java.util.Scanner;
import java.util.Random;

class Combat {
    public static void main(String[] args) {

    // System objects
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    // Game Variable
    String[] enemies = {"Skeleton", "Zombie", "Ghoul", "Goblin"};
    int maxEnemyHealth = 75;
    int enemyAttackDamage = 25;

    // Player Variables
    int health = 100;
    int attackDamage = 50;
    int numHealthPotions = 3;
    int healthPotionsHealAmount = 30;
    int healthPotionDropAmount = 50; // Percentage
    int score = 0;

    boolean running = true;

    System.out.println("Welcome to the Dungeon!");

    GAME: while (running) {
      System.out.println("--------------------------------------------");

      int enemyHealth = rand.nextInt(maxEnemyHealth); // Appearance of enemy
      String enemy = enemies[rand.nextInt(enemies.length)];
      System.out.println("\t# " + enemy + " has appeared! #");

      while (enemyHealth > 0) { // Encounter sequence
        System.out.println("\nYour HP: " + health);
        System.out.println("The " + enemy + "'s HP: " + enemyHealth);
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Drink health potion");
        System.out.println("3. Run!");

        String input = in.nextLine(); // Combat sequence
        if (input.equals("1")) {
          int damageDealt = rand.nextInt(attackDamage);
          int damageTaken = rand.nextInt(enemyAttackDamage);

          enemyHealth -= damageDealt;
          health -= damageTaken;

          System.out.println("\n> You strike the " + enemy + " for " + damageDealt + " damage.");
          System.out.println("> You receive " + damageTaken + " in retaliation!");

          if (health < 1) { // Death Sequence
            System.out.println("> You have taken too much damage, you are too weak to continue fighting!");
            break;
          }
        }

        else if (input.equals("2")) { // Drinks Health potion
          if (numHealthPotions > 0) {
            health += healthPotionsHealAmount;
            numHealthPotions--;
            System.out.println("> You drink a health potion, healing yourself for " + healthPotionsHealAmount + "."
                + "\n> You now have " + health + " HP." + "\n\t> You have " + numHealthPotions
                + " health potions left.\n");
          }

          else { // No health potions remaining.
            System.out.println("> You have no health potions left! Defeat enemies for a chance to get one!");
          }
        }

        else if (input.equals("3")) { // Run Sequence
          System.out.println("You run away from the " + enemy + "!");
          continue GAME;
        }

        else { // Invalid Input command
          System.out.println("Invalid command!");
        }
      }

      if (health < 1) { // End Death Sequence
        System.out.println("> You fall in battle, killed by a " + enemy + ".");
        System.out.println("> Your final score is " + score);
        break;
      }

      // Successful Combat Sequence
      System.out.println("\n--------------------------------------------");
      score++;
      System.out.println(" # " + enemy + " was defeated! # ");
      System.out.println(" # You have " + health + " HP left. #");
      System.out.println(" # Your score has increased to " + score);
      if (rand.nextInt(100) > healthPotionDropAmount) {
        numHealthPotions++;
        System.out.println("# The " + enemy + " has dropped a health potion! #");
        System.out.println("# You now have " + numHealthPotions + " health potions(s). # ");
      }
      System.out.println("--------------------------------------------");
      System.out.println("What would you like to do now?");
      System.out.println("1. Continue fighting");
      System.out.println("2. Exit dungeon");

      String input = in.nextLine();
      while (!input.equals("1") && !input.equals("2")) {
        System.out.println("Invalid command!");
        input = in.nextLine();
      }
      if (input.equals("1")) {
        System.out.println("\nYou continue with your adventures!");
      } 
      else if (input.equals("2")) {
        System.out.println("\n> You exit the dungeon, successful with your adventures!");
        System.out.println("> You have killed " + score + " monsters.");
        
        System.out.println("\nWould you like to play again(Your score will be reset)?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        
        input = in.nextLine();
        while (!input.equals("1") && !input.equals("2")) {
        System.out.println("Invalid command");
        input = in.nextLine();
        }
        
        if (input.equals("1")) {
            System.out.println("\nWelcome to the Dungeon!");

            score = 0;
            health = 100;
            numHealthPotions = 3;
            continue GAME;
        }
        else 
            in.close();
            break;
      }
    }

    System.out.println("\n######################");
    System.out.println("# THANKS FOR PLAYING #");
    System.out.println("######################");
  }
}