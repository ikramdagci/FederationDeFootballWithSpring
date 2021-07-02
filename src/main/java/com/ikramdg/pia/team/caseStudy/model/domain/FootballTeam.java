package com.ikramdg.pia.team.caseStudy.model.domain;

import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_football_team")
public class FootballTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "league")
	@Enumerated
	private League league;

	@Column(name = "team_logo_url")
	private String teamLogoURL;

	@Column(name = "home_city")
	private String homeCity;

	@Column(name = "foundatiton_year")
	private Year foundationYear;

	@Column(name = "colors")
	@ElementCollection
	private List<Color> colors;

	@Column(name = "non-homegrown_players_number")
	private int nonHomeGrownPlayerNumber;

	@Column(name = "goalkeeper_number")
	private int goalKeeperNumber;

	@OneToMany(mappedBy = "footballTeam")
	@JoinColumn(name = "football_team_id")
	private Set<FootballPlayer> footballPlayers = new HashSet<FootballPlayer>();

	public FootballTeam(String name, League league, String teamLogoURL, String homeCity, Year foundationYear,
			List<Color> colors) {
		this.name = name;
		this.league = league;
		this.teamLogoURL = teamLogoURL;
		this.homeCity = homeCity;
		this.foundationYear = foundationYear;
		this.colors = colors;
	}

	public FootballTeam(FootballTeamBuilder footballTeamBuilder) {
		this.name = footballTeamBuilder.name;
		this.league = footballTeamBuilder.league;
		this.teamLogoURL = footballTeamBuilder.teamLogoURL;
		this.homeCity = footballTeamBuilder.homeCity;
		this.foundationYear = footballTeamBuilder.foundationYear;
		this.colors = footballTeamBuilder.colors;
	}

	public FootballTeam() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public String getTeamLogoURL() {
		return teamLogoURL;
	}

	public void setTeamLogoURL(String teamLogoURL) {
		this.teamLogoURL = teamLogoURL;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public Year getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Year foundationYear) {
		this.foundationYear = foundationYear;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public void increaseGoalkeeperNumber() {
		goalKeeperNumber++;
	}

	public void increaseNonHomegrownPlayerNumber() {
		nonHomeGrownPlayerNumber++;
	}

	public boolean ensureTeamCount() {
		return footballPlayers.size() + 1 <= 18;
	}

	public boolean ensureNonHomegrownPlayerNumber() {
		return nonHomeGrownPlayerNumber < 6;
	}

	public boolean ensureGoalkeeperNumber() {
		return goalKeeperNumber < 2;
	}

	public Set<FootballPlayer> getFootballPlayers() {
		return footballPlayers;
	}

	public static class FootballTeamBuilder {
		private String name;
		private League league;
		private String teamLogoURL;
		private String homeCity;
		private Year foundationYear;
		private List<Color> colors;
		private int nonHomeGrownPlayerNumber;

		public void setName(String name) {
			this.name = name;
		}

		public void setLeague(League league) {
			this.league = league;
		}

		public void setTeamLogoURL(String teamLogoURL) {
			this.teamLogoURL = teamLogoURL;
		}

		public void setHomeCity(String homeCity) {
			this.homeCity = homeCity;
		}

		public void setFoundationYear(Year foundationYear) {
			this.foundationYear = foundationYear;
		}

		public void setColors(List<Color> colors) {
			this.colors = colors;
		}

		public void setNonHomeGrownPlayerNumber(int nonHomeGrownPlayerNumber) {
			this.nonHomeGrownPlayerNumber = nonHomeGrownPlayerNumber;
		}

	}

}
