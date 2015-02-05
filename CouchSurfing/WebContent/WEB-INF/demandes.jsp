
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <h3>Mes demandes</h3>
	        	
			<div id="demandes">
			    <div id="infosDemandes">
			    <div id="ical"></div>
					<ol>
						<li>
							<div class="uneDemande" id="">
								<div class="detailsAnnonce">
									
									<h3>title</h3>
									<div class="uneImg">Img ?</div>
									<div class="txt">Some paragraphs here ....</div>
								</div>
							</div></li>
						<li>
							<div class="uneDemande" id="">
								<div class="detailsAnnonce" class="reçue">
									
									<h3>title</h3>
									<div class="uneImg">Img ?</div>
									<div class="txt">Some paragraphs here ....</div>
								</div>
								<div class="confirmation"><div class="fontello-cancel"></div></div>
							</div></li>
						<li>
							<div class="uneDemande" id="">
								<div class="detailsAnnonce">
									
									<h3>title</h3>
									<div class="uneImg">Img ?</div>
									<div class="txt">Some paragraphs here ....</div>
								</div>
							</div></li>
						</ol>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
