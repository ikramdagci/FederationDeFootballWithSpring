package com.ikramdg.pia.team.caseStudy.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikramdg.pia.team.caseStudy.dto.FootballPlayerDTO;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballPlayer;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.Position;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.model.exception.FootballPlayerNotExistsException;
import com.ikramdg.pia.team.caseStudy.model.exception.FootballTeamNotExistException;
import com.ikramdg.pia.team.caseStudy.model.exception.GoalKeeperCountExceededException;
import com.ikramdg.pia.team.caseStudy.model.exception.NonHomeGrownPlayerCountExceededException;
import com.ikramdg.pia.team.caseStudy.model.exception.PlayerCountExceededException;
import com.ikramdg.pia.team.caseStudy.repository.FootballPlayerRepository;
import com.ikramdg.pia.team.caseStudy.repository.FootballTeamRepository;

@Service
public class FootballTeamService {

	@Autowired
	FootballPlayerRepository playerRepository;
	FootballTeamRepository teamRepository;

	public FootballPlayer addFootbalPlayer(FootballPlayerDTO playerDTO) {

		FootballTeam footballTeam = teamRepository.getById(playerDTO.getFootballTeam().getId());

		FootballPlayer footballPlayer = new FootballPlayer();
		footballPlayer.setFirstName(playerDTO.getFirstName());
		footballPlayer.setLastName(playerDTO.getLastName());
		footballPlayer.setHomegrown(playerDTO.isHomegrown());
		footballPlayer.setFootballTeam(playerDTO.getFootballTeam());
		footballPlayer.setNumber(playerDTO.getNumber());
		footballPlayer.setPosition(playerDTO.getPosition());

		// check constraints
		// consistency can be ensured in the database

		if (!footballTeam.ensureTeamCount()) {
			throw new PlayerCountExceededException();
		}

		if (!footballPlayer.isHomegrown()) {
			if (!footballTeam.ensureNonHomegrownPlayerNumber()) {
				throw new NonHomeGrownPlayerCountExceededException();
			}
		}

		if (footballPlayer.getPosition() == Position.GOALKEEPER) {
			if (!footballTeam.ensureGoalkeeperNumber()) {
				throw new GoalKeeperCountExceededException();
			}
		}

		playerRepository.save(footballPlayer);

		return footballPlayer;
	}

	public void deletePlayer(Long footBallPlayerId) {

		if (!playerRepository.existsById(footBallPlayerId)) {
			throw new FootballPlayerNotExistsException();
		}

		playerRepository.deleteById(footBallPlayerId);

	}

	public FootballTeam addTeam(FootballTeam footballTeam) {

		teamRepository.save(footballTeam);

		return footballTeam;
	}

	public void deleteTeam(Long footballTeamId) {

		if (!teamRepository.existsById(footballTeamId)) {
			throw new FootballTeamNotExistException();
		}

		teamRepository.deleteById(footballTeamId);

	}

	public FootballTeam updateTeam(Long footballTeamId, FootballTeamBuilder footballTeamBuilder) {

		if (!teamRepository.existsById(footballTeamId)) {
			throw new FootballTeamNotExistException();
		}

		FootballTeam footballTeam = new FootballTeam(footballTeamBuilder);

		teamRepository.save(footballTeam);

		return footballTeam;

	}

	public Set<FootballPlayer> getAllPlayers(Long footballTeamId) {
		FootballTeam footballTeam = teamRepository.getById(footballTeamId);
		return footballTeam.getFootballPlayers();
	}

}
