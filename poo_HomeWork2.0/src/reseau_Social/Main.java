package reseau_Social;

import java.util.Scanner;


/**
 * Created by aero on 10/10/15.
 */




public class Main {

    //l'ID
    public static String identite() {
        System.out.print("/*Inserez l' Identificateur : ");
        Scanner scanString = new Scanner(System.in);
        String iD = scanString.nextLine();
        while (((iD.charAt(0) >= '0') & (iD.charAt(0) <= '9')) | (iD.charAt(0) == '-')) {
            System.out.println("votre Identificateur doit commencer par un caractere ^^' (reessayez) ");
            iD = scanString.nextLine();
        }
        return iD;
    }

    //l'age
    public static int age(){
        System.out.print("/*Inserez l' Age : ");
        Scanner scanInt = new Scanner(System.in);
        int age = scanInt.nextInt();
        while ( age<1 ) {
            System.out.println("veullez entrer un age valide ");
            age = scanInt.nextInt();
        }
        {
            if (age>0)
                if (age < 7)
                    System.out.println("Umpeut trop jeune la pour avoir un compte Linkme a " + age + " ansvous ne trouvez pas XD !!");

                else if (age>100)
                    System.out.println("Serieusement  " + age + " ans (-_-)* . Enfin c vous qui voyez.........");
        }
        return age;
    }

    //le pay
    public static String country() {
        System.out.print("/*Inserez le pay : ");
        Scanner scanString = new Scanner(System.in);
        String country = scanString.nextLine();
        while (testCountry(country)) {
            System.out.println("Meme un pay inventé ne peut contenir un chifre dans son nom x) (reessayez) ! ");
            country = scanString.nextLine();
        }
        return country;
    }

    //si le mot contient un chifre ou non
    public static boolean testCountry(String mot){
        boolean v = false;
        for (int i = 0; i <mot.length() ; i++) {
            if ( (mot.charAt(i)>='0') & (mot.charAt(i)<='9') )
                v = true;
        }

        return v;
    }

    public static void main(String[] args) {

        Scanner scanInt = new Scanner(System.in);

        //page d'acueil
        ;
        System.out.println("\n\t\tBienvenu dans LinkMe :) !! \n\n\tCher utilisateur nous allons commencer par vous inscrire :\n");
        User me = new User(identite(),age(),country());
        System.out.println("\n\tBravo votre compte a etait cree avec succes :) ");
        ;

        //choix de l'action a effectuer
        ;
        System.out.println("\n\tBinvenue dans LinkMe "+me.getId());
        int choix,choix2;
       do {
           System.out.println("\n\tQue desirez vous faire ?" +
                   "\n\n-pour afficher votre profile(1)" +
                   "\n-pour ajouter un amie tappez(2)" +
                   "\n-pour supprimer un amie tappez(3)" +
                   "\n-pour afficher votre liste d'amie tappez(4)" +
                   "\n-pour quiter tappez (0)");
           choix = scanInt.nextInt();
           while( (choix <0)|(choix >4) ){
               System.out.println("veullez entrer un choix valide ");
               choix = scanInt.nextInt();
           }

            switch (choix){
                case 1:System.out.print("\tVotre profile est :\n\n" + me.toString() + "\n");
                    break;

                case 2:me.ajoutAmie(new User(identite(),age(),country()));
                    break;

                case 3:me.supprimAmie(identite());
                    break;

                case 4:do {
                    System.out.print("\n\tQue desirez vous Afficher :" +
                            "\n\n-pour afficher votre liste d'amie tappez(1)" +
                            "\n-pour afficher votre liste d'amie ayant une nationalité precise tappez(2)" +
                            "\n-pour quiter tappez (0)\n");

                    choix2 = scanInt.nextInt();
                    while ((choix2 < 0) | (choix2 > 2)) {
                            System.out.println("veullez entrer un choix valide ");
                            choix2 = scanInt.nextInt();
                        }

                    switch (choix2) {
                        case 1:me.affichAmie();
                            break;

                        case 2:me.affichAmie_deNation(country());
                            break;

                        case 0:
                            break;
                    }

                    }while (choix2 !=0);
                    break;

                case 0:
                    break;
            }
        }while( choix != 0 );
        ;


        scanInt.close();
    }
}
