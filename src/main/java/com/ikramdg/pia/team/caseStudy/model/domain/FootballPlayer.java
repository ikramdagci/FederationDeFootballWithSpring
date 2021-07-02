package com.ikramdg.pia.team.caseStudy.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "t_football_player")
public class FootballPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "position")
	@Enumerated
	private Position position;

	@Column(name = "number")
	private String number;

	public FootballTeam getFootballTeam() {
		return footballTeam;
	}

	public void setFootballTeam(FootballTeam footballTeam) {
		this.footballTeam = footballTeam;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setHomegrown(boolean isHomegrown) {
		this.isHomegrown = isHomegrown;
	}

	@Column(name = "is_homegrown")
	private boolean isHomegrown;

	@ManyToOne
	@JoinColumn(name = "player_team_id")
	private FootballTeam footballTeam;

	public FootballPlayer(String firstName, String lastName, Position position, String number, boolean isHomegrown) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.number = number;
		this.isHomegrown = isHomegrown;
	}

	public FootballPlayer() {
		this("UNKNOWN", "UNKNOWN", null, "0", false);
	}

	public Long getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "FootballPlayer [firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", number=" + number + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FootballPlayer) {
			FootballPlayer otherPlayer = (FootballPlayer) obj;
			return otherPlayer.id == this.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	public boolean isHomegrown() {
		return isHomegrown;
	}

}
