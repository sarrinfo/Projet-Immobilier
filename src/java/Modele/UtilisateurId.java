package Modele;
// Generated 2018-09-08 03:12:36 by Hibernate Tools 4.3.1



/**
 * UtilisateurId generated by hbm2java
 */
public class UtilisateurId  implements java.io.Serializable {


     private int utilisateurid;
     private String nom;

    public UtilisateurId() {
    }

    public UtilisateurId(int utilisateurid, String nom) {
       this.utilisateurid = utilisateurid;
       this.nom = nom;
    }
   
    public int getUtilisateurid() {
        return this.utilisateurid;
    }
    
    public void setUtilisateurid(int utilisateurid) {
        this.utilisateurid = utilisateurid;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UtilisateurId) ) return false;
		 UtilisateurId castOther = ( UtilisateurId ) other; 
         
		 return (this.getUtilisateurid()==castOther.getUtilisateurid())
 && ( (this.getNom()==castOther.getNom()) || ( this.getNom()!=null && castOther.getNom()!=null && this.getNom().equals(castOther.getNom()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUtilisateurid();
         result = 37 * result + ( getNom() == null ? 0 : this.getNom().hashCode() );
         return result;
   }   


}

