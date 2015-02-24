
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        
        <div id="profil_container" class="content-accueil">
	        <h1 id="titre_Profil">Profil de ${sessionUtilisateur.firstName} ${ sessionUtilisateur.name }</h1>
			<div id="profile" >
			    <div id="info">
			        <div class="infoSession">
			        	 <div id="infoSession_rigthContainer">
				            <div id = "container_img_profil">
				            	<div id="img_profil"> 
				            		<img id="img" src="${pageContext.request.contextPath}/ServletImageProfil" />
					        	</div>
					        </div>
					        <div id="containerNoteHerbergeur">
					        <p id="etoile_note_hebergeur" class="icon-star noteHebergeur"></p>
				        	<p id="note_hebergeur" class="noteHebergeur">13/20</p>
				        	</div>
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
			        		
			            	<p class="intitule_profil_service">Adresse</p><p class="info_profil_service">${ adresseLogement }</p>
			            	<p id="intituleService"> Service � proximit� </p>
			            	<div id="serviceContainer">
				            	<p class="icon-basket-1 intitule_profil_service"> Commerce</p><p class="info_profil_service"> Supermarch� � 300m</p>
								<p class="icon-h-sigh intitule_profil_service"> Soins</p><p class="info_profil_service"> Docteur en bas de la rue, hopital a 5min de metro</p>
								<p class="icon-food intitule_profil_service"> Restaurant </p><p class="info_profil_service"> 1 pizzeria, 1 macdo a 200m</p>
								<p class="icon-bus intitule_profil_service"> Transport</p><p class="info_profil_service"> le m�tro a 200m</p>
								<p class="icon-paw intitule_profil_service"> Animaux accept�s </p><p class="info_profil_service"> Oui </p>
								<p class="icon-signal intitule_profil_service"> Internet </p><p class="info_profil_service"> Oui </p>
							</div>
			            </div>
			        </div>
			    </div>
			</div>
		</div>
    </body>
</html>
