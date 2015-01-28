
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <h1>Recherche d'un logement</h1>
			<div id="formRecherche">
	        	<form id="leFormRecherche" method="post">
					<div id="contenuFormRecherche">
			           	<input id="inputCherche" type="text" name="ville">
			           	<input class="date" type="text" name="">
			           	<input class="date" type="text" name="">
			            <input type="submit" value="GO !" id="btCherche">
			        </div>
    			</form>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
