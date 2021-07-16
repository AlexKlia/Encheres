	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%@include file="../fragment/entete.jspf" %>
	
	<a href="connexion.jsp">S'inscrire - Se connecter</a>
	
	<p>Liste des ench�res</p>
	
	<p>Filtres : </p>
	
	<form method="get" action="/Encheres/ServletListeEnchereEnCours">
	
	<p>
	<input type="text" name="recherche" id="recherche" placeholder="Le nom de l'article contient" size="100" maxlength="100" autofocus /> 
	</p>
	<label for="categorie">Cat�gorie : </label>
	<select name="categorie" size="1"> 
	    <option value="toutes" selected="selected">Toutes</option> 
	    <option value="informatique">Informatique</option>
	    <option value="ameubleument">Ameubleument</option>
	    <option value="vetement">Vetement</option>
	    <option value="sportLoisir">Sport&Loisirs</option>
	</select>
	<br/>
		
	<input type="radio" name="mode" value="achats"/>Achats<br/> 
    <input type="radio" name="mode" value="ventes"/>Mes ventes<br/> 
    
  
    <input type="checkbox" name="achats" value="encheresOuvertes"/>ench�res ouvertes<br/> 
    <input type="checkbox" name="achats"  value="mesEncheresOuvertes"/>mes ench�res en cours<br/> 
    <input type="checkbox" name="achats"  value="mesEncheresRemportees"/>mes ench�res remport�es<br/>
  
    <input type="checkbox" name="ventes"  value="ventesEnCours"/>mes ventes en cours<br/>
 	<input type="checkbox" name="ventes"  value="ventesNonDebutees"/>ventes non debut�es<br/> 
    <input type="checkbox" name="ventes"  value="ventesTerminees"/>ventes termin�es<br/>
  
	<input type="submit" value="Rechercher" />
	</form>
	
	
		
	
	
	
	// La liste des encheres
	<br/><br/>
	${encheres.photoArticle} <br/>
	${encheres.nomArticle}<br/>
	Prix : ${encheres.meilleureOffre} point - y a pas encore<br/>
	Fin de l'enchere : ${encheres.finEnchere}<br/>
	Vendeur : ${encheres.vendeur} - y a pas encore<br/>
	
	
	
	
<%@include file="../fragment/piedDePage.jspf" %>