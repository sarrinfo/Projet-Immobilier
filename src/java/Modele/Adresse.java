package Modele;
// Generated 2018-09-14 01:24:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Adresse generated by hbm2java
 */
public class Adresse  implements java.io.Serializable {


     private AdresseId id;
     private String rue;
     private String localite;
     private String ville;
     private Set immeubles = new HashSet(0);

    public Adresse() {
    }

	
    public Adresse(AdresseId id, String rue) {
        this.id = id;
        this.rue = rue;
    }
    public Adresse(AdresseId id, String rue, String localite, String ville, Set immeubles) {
       this.id = id;
       this.rue = rue;
       this.localite = localite;
       this.ville = ville;
       this.immeubles = immeubles;
    }
      public Adresse(AdresseId id, String rue, String localite, String ville) {
       this.id = id;
       this.rue = rue;
       this.localite = localite;
       this.ville = ville;
    }
   
    public AdresseId getId() {
        return this.id;
    }
    
    public void setId(AdresseId id) {
        this.id = id;
    }
    public String getRue() {
        return this.rue;
    }
    
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getLocalite() {
        return this.localite;
    }
    
    public void setLocalite(String localite) {
        this.localite = localite;
    }
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    public Set getImmeubles() {
        return this.immeubles;
    }
    
    public void setImmeubles(Set immeubles) {
        this.immeubles = immeubles;
    }




}


