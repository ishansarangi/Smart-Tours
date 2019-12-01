package com.asu.ser531.museumrestapi.model;

public class ArtistDetailsBuilder {

	private final String beaconID;
	private String accessionNo;
	private String title;
	private String thumbnailURL;
	private String dateAcq;
	private String medium;
	private String classification;
	private String constituentID;
	private String artistName;
	private String artistBio;
	private String gender;
	private String beginDate;
	private String endDate;

	public ArtistDetailsBuilder(String beaconID) {
		super();
		this.beaconID = beaconID;
	}

	public ArtistDetailsBuilder setBeginDate(String beginDate) {
		this.beginDate = beginDate;
		return this;
	}

	public ArtistDetailsBuilder setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}

	public ArtistDetailsBuilder setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
		return this;
	}

	public ArtistDetailsBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public ArtistDetailsBuilder setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
		return this;
	}

	public ArtistDetailsBuilder setDateAcq(String dateAcq) {
		this.dateAcq = dateAcq;
		return this;
	}

	public ArtistDetailsBuilder setMedium(String medium) {
		this.medium = medium;
		return this;
	}

	public ArtistDetailsBuilder setClassification(String classification) {
		this.classification = classification;
		return this;
	}

	public ArtistDetailsBuilder setConstituentID(String constituentID) {
		this.constituentID = constituentID;
		return this;
	}

	public ArtistDetailsBuilder setArtistName(String artistName) {
		this.artistName = artistName;
		return this;
	}

	public ArtistDetailsBuilder setArtistBio(String artistBio) {
		this.artistBio = artistBio;
		return this;
	}

	public ArtistDetailsBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public ArtistDetails build() {
		return new ArtistDetails(accessionNo, beaconID, title, thumbnailURL, dateAcq, medium, classification,
				constituentID, artistName, artistBio, gender, beginDate, endDate);
	}
}
