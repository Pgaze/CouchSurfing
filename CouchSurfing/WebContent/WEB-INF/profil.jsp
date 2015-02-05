
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        
        <div id="profil_container" class="content-accueil">
	        <h1 id="titre_Profil">Profil de ${sessionUtilisateur.firstName} ${ sessionUtilisateur.name }</h1>
			<div id="profile" >
			    <div id="info">
			    	${ adresse }
			        <div class="infoSession">
			        	<div class = "infoSessionContainer">
			            <p class="intitule_profil">Nom</p><p class="info_profil"> ${sessionUtilisateur.name}</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Prenom</p><p class="info_profil"> ${ sessionUtilisateur.firstName }</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Email</p><p class="info_profil">${ sessionUtilisateur.mail }</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Pseudo</p><p class="info_profil">${ sessionUtilisateur.pseudo }</p>
			            </div>
			        </div>
			        <div class="infoSession">
			        	<div class = "infoSessionContainer">
			            	<p class="intitule_profil">Adresse</p>${ adresseLogement }
			            </div>
			        </div>
			    </div>
			</div>
		</div>
    </body>
</html>
