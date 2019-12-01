package com.asu.ser531.museumrestapi.model;

import java.io.Serializable;

public class ArtistDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String accessionNo;
	private String beaconID;
	private String title;
	private String ThumbnailURL;
	private String dateAcq;
	private String medium;
	private String classification;
	private String constituentID;
	private String artistName;
	private String artistBio;
	private String gender;
	private String beginDate;
	private String endDate;

	public ArtistDetails(String accessionNo, String beaconID, String title, String thumbnailURL, String dateAcq,
			String medium, String classification, String constituentID, String artistName, String artistBio,
			String gender, String beginDate, String endDate) {
		super();
		this.accessionNo = accessionNo;
		this.beaconID = beaconID;
		this.title = title;
		ThumbnailURL = thumbnailURL;
		this.dateAcq = dateAcq;
		this.medium = medium;
		this.classification = classification;
		this.constituentID = constituentID;
		this.artistName = artistName;
		this.artistBio = artistBio;
		this.gender = gender;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public String getDateAcq() {
		return dateAcq;
	}

	public void setDateAcq(String dateAcq) {
		this.dateAcq = dateAcq;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAccessionNo() {
		return accessionNo;
	}

	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}

	public String getBeaconID() {
		return beaconID;
	}

	public void setBeaconID(String beaconID) {
		this.beaconID = beaconID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnailURL() {
		return ThumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		ThumbnailURL = thumbnailURL;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getConstituentID() {
		return constituentID;
	}

	public void setConstituentID(String constituentID) {
		this.constituentID = constituentID;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ArtistDetails [accessionNo=" + accessionNo + ", beaconID=" + beaconID + ", title=" + title
				+ ", ThumbnailURL=" + ThumbnailURL + ", dateAcq=" + dateAcq + ", medium=" + medium + ", classification="
				+ classification + ", constituentID=" + constituentID + ", artistName=" + artistName + ", artistBio="
				+ artistBio + ", gender=" + gender + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
	}

}
