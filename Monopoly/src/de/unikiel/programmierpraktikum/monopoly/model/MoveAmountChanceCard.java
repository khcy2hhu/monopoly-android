/**
 * 
 */
package de.unikiel.programmierpraktikum.monopoly.model;

/**
 * @author johan_000
 *
 */
public class MoveAmountChanceCard extends ChanceCard {
	private static final long serialVersionUID = -6451999155066376394L;
	private int amount;

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
