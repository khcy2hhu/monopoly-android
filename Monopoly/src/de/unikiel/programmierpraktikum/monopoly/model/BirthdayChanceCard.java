/**
 * 
 */
package de.unikiel.programmierpraktikum.monopoly.model;

/**
 * @author johan_000
 *
 */
public class BirthdayChanceCard extends ChanceCard {
	private static final long serialVersionUID = -11989111947849631L;
	private double amount;

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
