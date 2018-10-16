/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author User
 */


import DAO.UtilisateurDAO;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static  boolean VALIDE_PWD   = false;

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        
        Utilisateur utilisateur = new Utilisateur();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }


        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
 

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
     
           Utilisateur user  =UtilisateurDAO.verifyPWD(motDePasse, email);
           if(user != null)
           {
                if(user.getMotdepasse().equals(motDePasse) && 
                    user.getId().getCourriel().equals(email))
             {
                 utilisateur = user;
                 resultat = "Connexion reussie.";
                 VALIDE_PWD = true;
             }
               
           }
            
            
        } else {
            resultat = "Identifiant ou mot de passe incorrect.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 8 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 8 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    public boolean getVALIDE_PWD() {
      
            return VALIDE_PWD;
        }
       
 }
     
