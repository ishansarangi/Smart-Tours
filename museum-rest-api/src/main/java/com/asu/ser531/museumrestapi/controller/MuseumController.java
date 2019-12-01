package com.asu.ser531.museumrestapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asu.ser531.museumrestapi.Query.Queries;
import com.asu.ser531.museumrestapi.model.ArtistDetails;
import com.asu.ser531.museumrestapi.model.ArtistDetailsBuilder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MuseumController {

	/**
	 * Get becon Details.
	 * 
	 * @param beaconId
	 * @return
	 */
	@RequestMapping(value = "/beacons/{beaconId}", method = RequestMethod.GET)
	public ResponseEntity<ArtistDetails> donationReport(@PathVariable("beaconId") String beaconId) {
		ResultSet result;
		try {
			result = queryEndpoint(Queries.getArtworkDetailsQuery(beaconId), beaconId);
			ArtistDetails artistDetails = transformToModel(result, beaconId);
			System.out.println("Transformed Model: " + artistDetails);
			return new ResponseEntity<>(artistDetails, HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Query an Endpoint using the given SPARQl query.
	 * 
	 * @param szQuery
	 * @param beaconId
	 * @return
	 * @throws Exception
	 */

	public ResultSet queryEndpoint(String szQuery, String beaconId) throws Exception {
		Query query = QueryFactory.create(szQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(Queries.FUSEKI_ENDPOINT, query);
		((QueryEngineHTTP) qexec).addParam("timeout", "10000");
		ResultSet rs = qexec.execSelect();
		// ResultSetFormatter.out(rs);
		return rs;
	}

	/**
	 * Transform result set to java model.
	 */
	private ArtistDetails transformToModel(ResultSet rs, String beaconId) throws ParseException, Exception {
		if(!rs.hasNext()) {
			throw new Exception("No artwork found for BeaconID");
		}
		
		ArtistDetailsBuilder artistBuilder = new ArtistDetailsBuilder(beaconId);
		while (rs.hasNext()) {
			// Get Result
			QuerySolution qs = rs.nextSolution();
			Literal accessionNo = qs.getLiteral("accessionNo");
			System.out.println("accessionNo: "+ accessionNo.toString());
			if (accessionNo.toString().isEmpty()) {
				throw new Exception("No artwork found for BeaconID");
			}
			artistBuilder.setAccessionNo(accessionNo.toString());

			Literal title = qs.getLiteral("title");
			artistBuilder.setTitle(title.toString());

			Literal thumbnailURL = qs.getLiteral("url");
			artistBuilder.setThumbnailURL(thumbnailURL.toString());

			Literal dateAcq = qs.getLiteral("dateAcq");
			artistBuilder.setDateAcq(dateAcq.toString());

			Literal medium = qs.getLiteral("medium");
			artistBuilder.setMedium(medium.toString());

			Literal classification = qs.getLiteral("class");
			artistBuilder.setClassification(classification.toString());

			Literal constituentID = qs.getLiteral("const");
			artistBuilder.setConstituentID(constituentID.toString());

			Literal artistName = qs.getLiteral("name");
			artistBuilder.setArtistName(artistName.toString());

			Literal artistBio = qs.getLiteral("bio");
			artistBuilder.setArtistBio(artistBio.toString());

			Literal gender = qs.getLiteral("gender");
			artistBuilder.setGender(gender.toString());

			Literal beginDate = qs.getLiteral("beginDate");
			artistBuilder.setBeginDate(beginDate.toString());

			Literal endDate = qs.getLiteral("endDate");
			artistBuilder.setEndDate(endDate.toString());
		}
		return artistBuilder.build();
	}

	public static void main(String[] args) throws IOException {

		try {
			MuseumController q = new MuseumController();
			Query query = QueryFactory.create(Queries.getArtworkDetailsQuery("3"));
			QueryExecution qexec = QueryExecutionFactory.sparqlService("http://3.82.93.91:3030/Artist/query", query);
			((QueryEngineHTTP) qexec).addParam("timeout", "10000");
			ResultSet rs = qexec.execSelect();
			System.out.println(q.transformToModel(rs, "3"));
			// ResultSetFormatter.out(rs);
			// sq.queryEndpoint(Queries.TEST_GET_QUERY);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
