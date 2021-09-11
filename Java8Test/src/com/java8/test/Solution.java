package com.java8.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {

		Map<String, List> ratingsHap = new HashMap<>();

		@Override
		public void putNewRating(String app, int rating) {
			List<Integer> ratingsList = ratingsHap.get(app);
			
			if (ratingsList == null) ratingsList = new ArrayList<>();
			
			ratingsList.add(rating);
			ratingsHap.put(app, ratingsList);
		}

		@Override
		public double getAverageRating(String app) {
			List<Integer> ratingsList = ratingsHap.get(app);						
			return ratingsList.stream().mapToDouble(a -> a).average().getAsDouble();
		}

		@Override
		public int getRatingsCount(String app) {
			return ratingsHap.get(app).size();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
			final Set<String> apps = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String app = tokens[0];
				apps.add(app);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewRating(app, runs);

			}

			for (String app : apps) {
				System.out.println(
						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
			}

		}
		scanner.close();

	}
}