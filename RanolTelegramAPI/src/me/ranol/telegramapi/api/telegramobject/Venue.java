package me.ranol.telegramapi.api.telegramobject;

public class Venue {
	private Location location;
	private String title;
	private String address;
	@Optional
	private String foursquare_id;

	public Location getLocation() {
		return location;
	}

	public String getTitle() {
		return title;
	}

	public String getAddress() {
		return address;
	}

	public String getFourSquareId() {
		return foursquare_id;
	}
}
