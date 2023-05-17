package fr.nice42.student.dkhatri.avaj;

class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public int getLatitude() {
		return (this.latitude);
	}

	public int getLongitude() {
		return (this.longitude);
	}

	public int getHeight() {
		return (this.height);
	}
}