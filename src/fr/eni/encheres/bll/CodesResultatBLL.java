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
}
