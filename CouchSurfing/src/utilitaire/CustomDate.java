package utilitaire;

import java.sql.Date;

import javax.naming.directory.InvalidAttributeValueException;

import modele.Offre;

public class CustomDate {

	/** Verifie l'integrite des dates debut et fin renseignées
	 * @param strDateDebut
	 * @param strDateFin
	 * @throws InvalidAttributeValueException
	 */
	public static void checkIntegriteDates(String strDateDebut, String strDateFin) throws InvalidAttributeValueException {
		//reformatage de la date
		Date newDateDebut,newDateFin;
		newDateDebut = Date.valueOf(strDateDebut);
		newDateFin = Date.valueOf(strDateFin);
		//vérifications
		if(!newDateFin.after(newDateDebut))
			throw new InvalidAttributeValueException("La date de fin n'est pas posterieure a la date de debut");
		Date dateCourante = new Date(System.currentTimeMillis());
		if(newDateDebut.before(dateCourante)) {
			//clean plein de truc dégueux
			Offre.cleanAllLogementByPostulePerimees();
			throw new InvalidAttributeValueException("La date de debut est anterieure ou egale a la date actuelle");
		}
	}

	/**
	 * @param year
	 * @param month
	 * @param day
	 * @return "yyyy-mm-dd"
	 * @throws InvalidAttributeValueException
	 */
	public static String creerStringDate(int year, int month, int day) throws InvalidAttributeValueException {
		String res = null;
		//vérification sommaire
		if(month <= 0 || day <= 0 || year <= 0 || day > 31 || month > 12){
			throw new InvalidAttributeValueException("La date avant changement de format est invalide");
		}else{
			res = "" + year + "-" + month + "-" + day;
		}
		return res;
	}

	/** Reformate si necessaire
	 * @param date
	 * @return yyyy-mm-dd
	 */
	public static String checkFormatDate(String date) {
		if(date.length()==0) return null;
		String res;
		String[] splited = null;
		if(date.contains("/")){
			splited = date.split("/");
		}else if (date.contains("-")){
			splited = date.split("-");
		}
		if(splited[0].length() < 4){
			res = splited[2] + "-" + splited[0] + "-" + splited[1];
		}else{
			res = splited[0] + "-" + splited[1] + "-" + splited[2];
		}
			
		return res;
	}

}
