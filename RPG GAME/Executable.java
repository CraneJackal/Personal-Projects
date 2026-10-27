import java.util.Scanner;

class Executable {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Player pc = new Player();
        pc.newStats();
        
        System.out.print("What is the name of your character: ");
        String newName = scan.nextLine();

        pc.setName(newName);
        pc.getStats();

        scan.close();
     }
}

