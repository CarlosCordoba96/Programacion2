
public class Offer {
protected int identifier;
protected String kind;

public Offer(int identifier, String kind){
	this.identifier=identifier;
	this.kind=kind;
}

public int getIdentifier() {
	return identifier;
}

public void setIdentifier(int identifier) {
	this.identifier = identifier;
}

public String getKind() {
	return kind;
}

public void setKind(String kind) {
	this.kind = kind;
}


}
