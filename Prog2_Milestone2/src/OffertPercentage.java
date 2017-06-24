
public class OffertPercentage extends Offer{
	private int perc, max;
	
	public OffertPercentage(int identifier, String kind, int perc, int max) {
		super(identifier, kind);
		this.perc=perc;
		this.max=max;
	}

	public int getPerc() {
		return perc;
	}

	public void setPerc(int perc) {
		this.perc = perc;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	public int getIdentifier() {
		return identifier;
	}

	
}
