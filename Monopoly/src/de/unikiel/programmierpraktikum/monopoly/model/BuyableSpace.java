package de.unikiel.programmierpraktikum.monopoly.model;

public abstract class BuyableSpace extends Space {
	private Player owner;
	private boolean mortgage; //Hypothek
	
	public abstract double getRent(Player player);
	public abstract double getPurchasePrice();
	public double getMortgageValue() {
		return getPurchasePrice() / 2;
	}
	
	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	/**
	 * @return the mortgage
	 */
	public boolean isMortgage() {
		return mortgage;
	}
	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(boolean mortgage) {
		this.mortgage = mortgage;
	}
}