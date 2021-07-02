package com.ikramdg.pia.team.caseStudy.dto;

import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.Position;

public class FootballPlayerDTO {

	private String firstName;

	private String lastName;

	private Position position;

	private String number;

	private boolean isHomegrown;

	private FootballTeam footballTeam;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public boolean isHomegrown() {
		return isHomegrown;
	}

	public void setHomegrown(boolean isHomegrown) {
		this.isHomegrown = isHomegrown;
	}

	public FootballTeam getFootballTeam() {
		return footballTeam;
	}

	public void setFootballTeam(FootballTeam footballTeam) {
		this.footballTeam = footballTeam;
	}

}
