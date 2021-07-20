package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Enchere {

	private LocalDate dateEnchere;
	private int montantEnchere;
	
	private Article article;
	private Utilisateur acheteur;
	
	public Enchere(Utilisateur acheteur, Article article, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.setAcheteur(acheteur);
		this.setArticle(article);
		this.setDateEnchere(dateEnchere);
		this.setMontantEnchere(montantEnchere);
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", article=" + article
				+ ", acheteur=" + acheteur + "]";
	}
	
	
}
