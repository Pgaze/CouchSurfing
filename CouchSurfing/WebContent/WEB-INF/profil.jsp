
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <p>Profil de ${sessionScope.sessionUtilisateur.name} ${sessionScope.sessionUtilisateur.firstName}</p>
	        	
			<div id="profile">
			    <div id="info">
			        <div id="infoSession">
			        	<p>Vous êtes connecté avec l'adresse ${sessionScope.sessionUtilisateur.mail} </p>
			        </div>
			        <div id="infoSession">
			        	
			        </div>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
