package fr.eni.encheres.bll;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
//import fr.eni.encheres.dal.UserNotFoundException;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur seConnecter(String id, String mdp) throws DALException {

		Utilisateur utilisateur = utilisateurDAO.selectIdentifiant(id, mdp);

		return utilisateur;

	}

	public Utilisateur getUserById(int id) throws DALException {
		return utilisateurDAO.selectById(id);
	}

	public Utilisateur add(Utilisateur utilisateur) throws DALException, BusinessException {
		BusinessException businessException = new BusinessException();
		validation(utilisateur, businessException);

		if (!businessException.hasErreurs()) {
			return utilisateurDAO.insert(utilisateur);
		} else {
			throw businessException;
		}
	}

	public Utilisateur update(Utilisateur utilisateur) throws DALException{
//		BusinessException businessException = new BusinessException();
//		this.validation(utilisateur, businessException);
//
//		if (!businessException.hasErreurs()) {
			return utilisateurDAO.update(utilisateur);
//		} else {
//			throw businessException;
//		}
}

	public String delete(Utilisateur utilisateur) throws DALException {

		utilisateurDAO.deleteByUser(utilisateur);
		return "utilisateur : "+ utilisateur.getNoUtilisateur()+" bien supprimé";

	}
	
	public String getPseudoVendeur(int id) throws DALException {
		if (null != utilisateurDAO.selectById(id)) {
			return utilisateurDAO.selectById(id).getPseudo();
		}
		return null;
	}

	private void validation(Utilisateur utilisateur, BusinessException businessException) {
		System.out.println("test");
		
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_NULL,
					"Le pseudo est obligatoire.");
		} else {
			if (utilisateur.getPseudo().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR, "Pseudo trop long.");
			}
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_NULL,
					"Le nom de l'utilisateur est obligatoire.");
		} else {
			if (utilisateur.getNom().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR,
						"Le nom de l'utilisateur est trop long.");
			}
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_NULL,
					"Le prénom de l'utilisateur est obligatoire.");
		} else {
			if (utilisateur.getPrenom().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR,
						"Le prénom de l'utilisateur est trop long.");
			}
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_NULL,
					"L'email de l'utilisateur est obligatoire.");
		} else {
			if (utilisateur.getEmail().length() > 20) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR, "Email trop long.");
			}
		}
		if (utilisateur.getTelephone().length() > 15) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TEL_ERREUR, "Téléphone trop long.");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().equals(""))

		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_NULL, "La rue est obligatoire.");
		} else {
			if (utilisateur.getRue().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_ERREUR,
						"Le champs rue est trop long.");
			}
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().equals(""))

		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODE_POSTAL_NULL,
					"Le code postal est obligatoire.");
		} else {
			if (utilisateur.getCodePostal().length() > 10) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR,
						"Code postal trop long.");
			}
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().equals(""))

		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_NULL, "La ville est obligatoire.");
		} else {
			if (utilisateur.getVille().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_ERREUR, "Ville trop long.");
			}
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().equals(""))

		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOT_DE_PASSE_NULL,
					"Le mot de passe est obligatoire.");
		} else {
			if (utilisateur.getMotDePasse().length() > 30) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR,
						"Mot de passe trop long.");
			}
		}
		//Initialisation du crédit de l'utilisateur à 0
		utilisateur.setCredit(0);

		//Verification mot de passe
		System.out.println(utilisateur.getMotDePasse());
		System.out.println(utilisateur.getMotDePasseConfirmation());
		if (utilisateur.getMotDePasse() != null && utilisateur.getMotDePasseConfirmation() != null) {
			if (!utilisateur.getMotDePasse().equals(utilisateur.getMotDePasseConfirmation())) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR_CONFIRMATION,
						"Les mots de passe entrés sont differents.");
				
			}
			
		//Verification du pseudo en caractères alphanumériques
		if(utilisateur.getPseudo() != null && !utilisateur.getPseudo().matches("^[a-zA-Z0-9]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ALPHANUMERIQUE,
					"Le pseudo doit uniquement contenir des caractères alphanumériques ((A à Z) (0 à 9)");
		}
		
		}
	}
	
	
}
