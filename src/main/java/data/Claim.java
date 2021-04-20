package data;

public class Claim {

        private int id;
        private String vaittama;

        public int getId() {
		return id;
	}
        public void setId(int id) {
		this.id = id;
	}
	public String getClaim() {
		return vaittama;
	}
        public void setClaim(String vaittama) {
		this.vaittama = vaittama;
        }

        public String toString() {
		return id+" "+vaittama;
	}
}
