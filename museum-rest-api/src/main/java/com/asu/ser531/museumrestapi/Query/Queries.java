package com.asu.ser531.museumrestapi.Query;

public final class Queries {

	public static final String GET_QUERY = "select * where {?Subject ?Predicate ?Object} LIMIT 1";
	public static final String FUSEKI_ENDPOINT = "http://3.82.93.91:3030/Artist/query";

	public static final String TEST_GET_QUERY = new StringBuilder()
			.append("PREFIX dbo: <http://dbpedia.org/ontology/>")
			.append("\nPREFIX dbr: <http://dbpedia.org/resource/>")
			.append("\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>")
			.append("\nSELECT DISTINCT ?name ?birth ?death")
			.append("WHERE {")
			.append("\n?person dbo:birthPlace dbr:Arizona .")
			.append("?person dbo:birthDate ?birth .")
			.append("\n?person rdfs:label ?name.")
			.append("OPTIONAL { ?person dbo:deathDate ?death . }")
			.append("}")
			.append("\nORDER BY (?birth)").toString();
	
	
	public static String getArtworkDetailsQuery(String beaconId) {
	 StringBuilder GET_ARTIST_DETAILS = new StringBuilder()
				.append("PREFIX beacon: <http://www.semanticweb.org/ishansarangi/ontologies/2019/10/beacon-team-9#>")
				.append("\nPREFIX artwork: <http://www.semanticweb.org/ishansarangi/ontologies/2019/10/artwork-team-9#>")
				.append("\nPREFIX artist: <http://www.semanticweb.org/ishansarangi/ontologies/2019/10/artist-team-9#>")
				.append("\nSELECT *")
				.append("\n{")
				.append("\nSERVICE <http://3.93.148.249:3030/beacon/query>")
				.append("\n{")
				.append("\nSELECT * WHERE {");
GET_ARTIST_DETAILS.append("\n?beacon beacon:Beacon_Id ").append("\"").append( beaconId).append("\"").append(";")
	 			.append("\nbeacon:AccessionNumber ?accessionNo;")
				.append("\nbeacon:Beacon_Id ?beaconID.")
				.append("\n}")
				.append("\n}")
				.append("\nSERVICE <http://3.88.39.98:3030/artwork/query>")
				.append("\n{")
				.append("\nSELECT * WHERE {")
				.append("\n?art artwork:AccessionNumber ?accessionNo;")
				.append("\nartwork:Title ?title;")
				.append("\nartwork:ThumbnailURL ?url;")
				.append("\nartwork:Date ?dateAcq;")
				.append("\nartwork:Medium ?medium;")
				.append("\nartwork:Classification ?class;")
				.append("\nartwork:ConstituentID ?const.")
				.append("\n}")
				.append("\n}")
				.append("\nSERVICE <http://3.82.93.91:3030/Artist/query>")
				.append("\n{")
				.append("\nSELECT * WHERE {")
				.append("\n?artist artist:ConstituentID ?const;")
				.append("\nartist:ArtistName ?name;")
				.append("\nartist:ArtistBio ?bio;")
				.append("\nartist:Gender ?gender;")
				.append("\nartist:BeginDate ?beginDate;")
				.append("\nartist:EndDate ?endDate.")
				.append("\n}")
				.append("\n}")
				.append("\n}");
	 
	 System.out.println("Query to fetch Artwork: \n"+GET_ARTIST_DETAILS);
	 return GET_ARTIST_DETAILS.toString();
	}
	


		 
	
}
