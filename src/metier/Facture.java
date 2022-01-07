package metier;

import java.time.LocalDate;

public class Facture
{
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */

	private Client nom;
	private LocalDate date;
	private int montant;
	private boolean estreglee;

	public Facture(Client nom, int montant, boolean estreglee, LocalDate date)
	{
		this.date = date;
		this.montant = montant;
		this.nom = nom;
		this.estreglee = estreglee;

	}

	public Client getClient()
	{
		return nom;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */

	public int getMontant()
	{
		return montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */

	public boolean estReglee()
	{
		return estreglee;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */

	public LocalDate getDate()
	{
		return date;
	}

	/**
	 * Supprime la facture
	 */

	public void delete()
	{
		getClient().getFactures().remove(this);
	}

	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */

	public Facture copie()
	{
		return getClient().createFacture(getMontant(), estReglee());
	}
}
