<<<<<<< HEAD

<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <p>Mes demandes</p>
	        	
			<div id="demandes">
			    <div id="infosDemandes">
			        <div class="uneDemande"">
			        	
			        </div>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
=======

<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <p>Mes demandes</p>
	        	
			<div id="profile">
			    <div id="info">
			        <div id="infoSession">
			        	<p>Vous �tes connect� avec l'adresse ${sessionScope.sessionUtilisateur.mail} </p>
			        </div>
			        <div id="infoSession">
			        	
			        </div>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
>>>>>>> branch 'master' of git@192.168.1.11:~/leBonRepo.git
