package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client
{
	public String nom;
	private static List<Client> Client = new ArrayList<Client>();
	private List<Facture> factures = new ArrayList<Facture>();

	/**
	 * Crée un client.
	 * 
	 * @param nom le nom du client.
	 */
	public Client(String nom)
	{
		this.nom = nom;
		Client.add(this);
	}
	/**
	 * Retourne le nom du client.
	 * 
	 * @return le nom du client.
	 */
	public String getNom()
	{
		return nom;
	}
	/**
	 * Modifie le nom du client.
	 * 
	 * @param nom le nom du client.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	/**
	 * Créé une facture.
	 * 
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	public Facture createFacture(int montant)
	{
		if (montant < 0)
		{
			System.out.println("Le montant d'une facture ne peut pas être négatif.");
			return null;
		} else {
			Facture facture = new Facture(this, montant, false, LocalDate.now());
			factures.add(facture);
			return facture;
		}
	}
	/**
	 * Retourne une copie de la liste des factures du client.
	 * 
	 * @return une copie de la liste des factures du client.
	 */
	public List<Facture> getFactures()
	{
		List<Facture> Facture = new ArrayList<Facture>(factures);

		return Facture;
	}
	/**
	 * Retourne la somme des montants des factures.
	 * 
	 * @return la somme des montants des factures.
	 */
	public int sommeMontants()
	{
		int montant = 0;
		for (int i = 0; i < factures.size(); i++)
		{
			montant = montant + factures.get(i).getMontant();
		}
		return montant;
	}
	/**
	 * Créé une facture en précisant si elle est reglée. param montant Le montant de
	 * la facture. param estreglee() Vrai si la facture est reglée.
	 * 
	 * @return la facture créée.
	 */
	public Facture createFacture(int montant, boolean estreglee)
	{
		if (montant <= 0) 
		{
			System.out.println("Le montant d'une facture ne peut pas être négatif.");
			return null;
		} 
		else 
		{
			Facture facture = new Facture(this, montant, estreglee, LocalDate.now());
			factures.add(facture);
			return facture;
		}
	}
	/**
	 * Retourne la liste des factures reglées.
	 * 
	 * @return la liste des factures reglées.
	 */
	public List<Facture> facturesReglees()
	{
		List<Facture> Facture = new ArrayList<Facture>();
		for (int i = 0; i<factures.size(); i++) {
			if (factures.get(i).estReglee()) {
				Facture.add(factures.get(i));
			}
		}
		return Facture;
	}
	/**
	 * Retourne tous les Client créés.
	 * 
	 * @return une copie de la liste de tous les Client.
	 */
	public static List<Client> tous()
	{
		return new ArrayList<Client>(Client);
	}
	/**
	 * Supprime le client.
	 */
	public void delete()
	{
		Client.remove(this);
	}
}
