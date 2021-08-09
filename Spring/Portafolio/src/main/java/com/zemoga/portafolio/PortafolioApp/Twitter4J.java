package com.zemoga.portafolio.PortafolioApp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service("twitter4J")
public class Twitter4J {
//	public static void main(String[] args) {
//		Twitter4J instTw = new Twitter4J();
//		//instTw.createTweet("creating baeldung API for Zemoga Test");
//		System.out.println(instTw.searchtweets());
//		System.out.println(instTw.getTimeLine());
//	}
	
	@Bean(name="getTwitterinstance")
	public Twitter getTwitterinstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(false)
				.setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
				.setOAuthConsumerSecret("X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
				.setOAuthAccessToken("1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
				.setOAuthAccessTokenSecret("tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}

	public List<String> getTimeLine() {
		Twitter twitter = getTwitterinstance();

		try {
			return (List<String>) twitter.getHomeTimeline().stream().map(item -> item.getText())
					.collect(Collectors.toList());
		} catch (TwitterException e1) {
			System.out.println("ERROR: " + e1);
			return Collections.emptyList();
		}
	}

	public String createTweet(String tweet) {
		Twitter twitter = getTwitterinstance();
		Status status = null;
		
		try {
			status = twitter.updateStatus(tweet);
		} catch (TwitterException e1) {
			System.out.println("ERROR: " + e1);
			return "";
		}
		
		return status.getText();
	}

	public List<String> searchtweets() {
		Twitter twitter = getTwitterinstance();
		Query query = new Query();
		QueryResult result = null;

		try {
			query = new Query("source:twitter4j baeldung");
			result = twitter.search(query);
		} catch (TwitterException e1) {
			System.out.println("ERROR: " + e1);
			return Collections.emptyList();
		}

		return result.getTweets().stream().map(item -> item.getText()).collect(Collectors.toList());
	}
}
