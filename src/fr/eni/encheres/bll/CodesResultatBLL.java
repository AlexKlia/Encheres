package fr.eni.encheres.bll;

public class CodesResultatBLL {
	/**
	 * Echec quand le nom de l'article est null.
	 */
	public static final int REGLE_ARTICLE_NOM_NULL=20000;

	/**
	 * Echec quand le nom de l'article est en erreur.
	 */
	public static final int REGLE_ARTICLE_NOM_ERREUR=20001;

	/**
	 * Echec quand la description de l'article est null.
	 */
	public static final int REGLE_ARTICLE_DESCRIPTION_NULL=20002;
	
	/**
	 * Echec quand la description de l'article est en erreur.
	 */
	public static final int REGLE_ARTICLE_DESCRIPTION_ERREUR=20003;

	/**
	 * Echec quand la date de debut de l'article est null.
	 */
	public static final int REGLE_ARTICLE_DATE_DEBUT_NULL=20004;
	
	/**
	 * Echec quand la date de debut de l'article est en erreur.
	 */
	public static final int REGLE_ARTICLE_DATE_DEBUT_ERREUR=20005;
	
	/**
	 * Echec quand la date de fin de l'article est null.
	 */
	public static final int REGLE_ARTICLE_DATE_FIN_NULL=20006;
	
	/**
	 * Echec quand la date de fin de l'article est avant la date d'aujourd'hui.
	 */
	public static final int REGLE_ARTICLE_DATE_FIN_BEFORE_NOW=20007;
	
	/**
	 *  Echec quand la date de fin de l'article est avant la date de debut.
	 */
	public static final int REGLE_ARTICLE_DATE_FIN_BEFORE_DEBUT=20008;
	
	
	public static final int REGLE_UTILISATEUR_PSEUDO_NULL=20009;
	
	
	public static final int REGLE_UTILISATEUR_PSEUDO_ERREUR=20010;
	
	public static final int REGLE_UTILISATEUR_NOM_NULL=20011;
	
	public static final int REGLE_UTILISATEUR_NOM_ERREUR=20012;
	
	public static final int REGLE_UTILISATEUR_PRENOM_NULL=20013;
	
	public static final int REGLE_UTILISATEUR_PRENOM_ERREUR=20014;
	
	public static final int REGLE_UTILISATEUR_EMAIL_NULL=20015;
	
	public static final int REGLE_UTILISATEUR_EMAIL_ERREUR=20016;
	
	public static final int REGLE_UTILISATEUR_TEL_ERREUR=20017;
	
	public static final int REGLE_UTILISATEUR_RUE_NULL=20018;
	
	public static final int REGLE_UTILISATEUR_RUE_ERREUR=20019;
	
	public static final int REGLE_UTILISATEUR_CODE_POSTAL_NULL=20020;
	
	public static final int REGLE_UTILISATEUR_CODE_POSTAL_ERREUR=20021;
	
	public static final int REGLE_UTILISATEUR_VILLE_NULL=20022;
	
	public static final int REGLE_UTILISATEUR_VILLE_ERREUR=20023;
	
	public static final int REGLE_UTILISATEUR_MOT_DE_PASSE_NULL=20024;
	
	public static final int REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR=20025;
	
	public static final int REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR_CONFIRMATION=20026;
	
	public static final int REGLE_UTILISATEUR_PSEUDO_ALPHANUMERIQUE=20027;
	
}
