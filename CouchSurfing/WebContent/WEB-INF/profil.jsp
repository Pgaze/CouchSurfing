
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
			        	 <div id="infoSession_rigthContainer">
				            <div id = "container_img_profil">
					            <div id="img_profil"> 
					        	</div>
					        </div>
					        <p id="note_hebergeur_container" class="icon-star">
				        		<p id="note_hebergeur">13/20</p>
				        	</p>
				        	<p id="nbr_avis_hebergeur">
				        		( 200 avis )
				        	</p>
			            </div>
			        	<div id="infoSession_leftContainer">
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
			           
			            
			        </div>
			        	
			        <div class="infoSession">
			        	<div class = "infoSessionContainer">
			            	<p class="intitule_profil">Adresse</p><p class="info_profil">${ adresseLogement }</p>
			            </div>
			        </div>
			    </div>
			</div>
		</div>
    </body>
</html>
