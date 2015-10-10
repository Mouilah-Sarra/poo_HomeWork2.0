package reseau_Social;
import java.util.ArrayList;
/**
 * Created by aero on 10/10/15.
 */


//J'ai une ERREUR dans la methode (affichAmie_deNation) <la Condition>
//J' une autre ERREUR dans la metthode de (Suppretion d'amie) <dans le nouvelle affichage apres Suppretion l'amie Supprimé s'affiche>

public class User {
    private String iD;
    private int age;
    private String country;
    private ArrayList<User> listeAmie;
    
    //Constructor
    ;
    public User (String pseudo,int ag,String country){
        iD = pseudo;
        age = ag;
        this.country = country;
        listeAmie = new ArrayList();
    }
    ;

    //setter
    ;
    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    ;

    //getters
    ;
    public String getId() {
        return iD;
    }
    
    public int getAge(){
        return age;
    }

    public String getCountry() {
        return country;
    }

    public java.util.ArrayList<User> getListeAmie() {
        return listeAmie;
    }
    ;

    ;
    //afficher list d'amie
    public void affichAmie(){
        if(listeAmie.size() == 0)
            System.out.print("\n\tVous n'avez pas d'amie :( \n");
        else{
            System.out.println("\n\tVos amie sont :\n");
            for (int i = 0; i < listeAmie.size(); i++) {
                System.out.println("*" + listeAmie.get(i).iD+" agé de "+listeAmie.get(i).age+" est un habitant de(d') "+listeAmie.get(i).country);
            }
        }
    }

    //affiche liste d'amie de nationalité ( X )
    public void affichAmie_deNation(String nation){
        if(this.listeAmie.size() == 0)
            System.out.print("\n\tVous n'avez pas d'amie :( \n");
        else{
            System.out.println("\n\tVos amie de(d') "+nation+" sont :\n");
            int j=0;
            for (int i = 0; i < this.listeAmie.size(); i++) {
                if (this.listeAmie.get(i).country == nation) {       /*ERREUR incomprehensible*/
                    System.out.println("*" + listeAmie.get(i).iD + " agé de " + listeAmie.get(i).age + " est un habitant de(d') " + listeAmie.get(i).country);
                    j++;
                }
            }
            if (j==0)
                System.out.println("\n\tEn fait vous n'avez pas d'amie de(d')"+country+":\n");

        }
    }

    //ajouter un amie
    public void ajoutAmie (User amie){
        if (amiOu_pas(amie))
           System.out.print("\n\tVous etes deja amie avec "+amie.iD);
        else
            listeAmie.add(amie);
    }

    //supprimer un amie
    public void supprimAmie (String amie){
        if (amiOu_pas(amie))
            listeAmie.remove(indiceAmie(amie));
        else
        System.out.print("\n\tVous n'etes pas amie avec " + amie+" pour le supprimer de votre liste\n");
    }

    //chercher un amie existant apartir des info de son compt
    public boolean amiOu_pas(User user){
        int i = 0;
        boolean v = false;
        while ( i<listeAmie.size()  ) {
            if (listeAmie.get(i).iD == user.iD)
                v = true;
            i++;
        }
        return v;
    }

    //chercher un amie existant apartire de son nom
    public boolean amiOu_pas(String idUser){
        int i = 0;
        boolean v = false;
        while ( i<listeAmie.size() ) {
            if (listeAmie.get(i).iD == idUser)
                v = true;
            i++;
        }
        return v;
    }

    //l'utilisateur qui a cette iD (retourne l'utilisateur de l'Identificateur)
    public int indiceAmie(String amie){
        int i = 0;
        int j = 0;
        while ( i<listeAmie.size()) {
            if (listeAmie.get(i).iD == amie)
                j = i;
            i++;
        }
        return j;
    }

    ;

    //toString
    ;
    @Override
    public String toString() {
        return iD+" agé(e) de "+age+" ans , est un(e) habitant de(d') "+country;
    }
    ;

}
