
import java.util.logging.Level;
import java.util.logging.Logger;

interface Contenu
{
	void encode(String texte);
	String toString();
}
class ContenuTexte implements Contenu
{
	protected String texte;
	public void encode(String texte)
	{
		this.texte = texte;
	}
	public String toString()
	{
		return (texte);
	}
}
class ContenuHtml implements Contenu
{
	protected String codeHtml;
	public void encode(String texte)
	{
		codeHtml = "<HTML>" + texte + "</HTML>";
	}
	public String toString()
	{
		return (codeHtml);
	}
}

class Courrier
{
	protected Contenu contenu;
	protected String destinataire;
        protected Class contenuClass;
        
        public Courrier(Class contenuClass){
            this.contenuClass = contenuClass;
        }

	protected Contenu nouveauContenu(){
            try {
                Contenu contenu = (Contenu)contenuClass.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Courrier.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Courrier.class.getName()).log(Level.SEVERE, null, ex);
            }
            return contenu;
        }

	public void prepare(String destinataire, String texte)
	{
		this.destinataire = destinataire;
		contenu = nouveauContenu();
		contenu.encode(texte);
	}
	public String toString()
	{
		String st = "destinataire : " + destinataire + "\n";
		st += "contenu : " + contenu.toString();
		return st;
	}
}


public class TestCourrier
{

	public static void main(String[] args)
	{
		Courrier courrierHtml = new Courrier(ContenuHtml.class);
		courrierHtml.prepare("adresse1@domaine", "texte1");
		System.out.println(courrierHtml);
		Courrier courrierTexte = new Courrier(ContenuTexte.class);
		courrierTexte.prepare("adresse2@domaine", "texte2");
		System.out.println(courrierTexte);
	}

}