
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        
        <div id="profil_container" class="content-accueil">
	        <h1 id="titre_Profil">Profil de ${prenom} ${ nom }</h1>
			<div id="profile" >
			    <div id="info">
			        <div class="infoSession">
			        	<div class = "infoSessionContainer">
			            <p class="intitule_profil">Nom</p><p class="info_profil"> ${ nom }</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Prenom</p><p class="info_profil"> ${ prenom }</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Email</p><p class="info_profil">${ mail }</p>
			            </div>
			            <div class = "infoSessionContainer">
			            <p class="intitule_profil">Pseudo</p><p class="info_profil">${ pseudo }</p>
			            </div>
			        </div>
			        <div class="infoSession">
			        	
			        </div>
			    </div>
			</div>
		</div>
    </body>
</html>
