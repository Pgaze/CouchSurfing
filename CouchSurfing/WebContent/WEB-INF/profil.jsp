
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
    <body>
        <p>Profil de ${prenom} ${ nom }</p>
        	
		<div id="profile">
		    <div id="info">
		        <div id="infoSession">
		            <p>Nom : ${ nom }</p>
		            <p>Prenom : ${ prenom }</p>
		            <p>Email : ${ mail }</p>
		            <p>Pseudo : ${ pseudo }</p>
		        </div>
		        <div id="infoSession">
		        	
		        </div>
		    </div>
		</div>
    </body>
</html>
