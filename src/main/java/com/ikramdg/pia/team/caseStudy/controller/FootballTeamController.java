package com.ikramdg.pia.team.caseStudy.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikramdg.pia.team.caseStudy.dto.FootballPlayerDTO;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballPlayer;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.service.FootballTeamService;

@RestController
@RequestMapping("/federation")
public class FootballTeamController {

	@Autowired
	FootballTeamService footballTeamService;

	@PostMapping("/add-football-team")
	public void addFootballTeam(@RequestBody FootballTeam footballTeam) {
		footballTeamService.addTeam(footballTeam);
	}

	@GetMapping("/get-players")
	public Set<FootballPlayer> getPlayersByTeamId(@PathVariable("teamId") Long teamId) {
		return footballTeamService.getAllPlayers(teamId);
	}

	@PatchMapping("/update-team")
	public FootballTeam updateFootballTeam(@PathVariable("teamId") Long teamId,
			FootballTeamBuilder footballTeamBuilder) {
		return footballTeamService.updateTeam(teamId, footballTeamBuilder);
	}

	@DeleteMapping("/delete-team")
	public void deleteFootballTEam(@RequestBody Long footballTeamId) {
		footballTeamService.deleteTeam(footballTeamId);
	}

	@PostMapping("/add-player")
	public FootballPlayer addFootballPlayer(FootballPlayerDTO playerDTO) {
		return footballTeamService.addFootbalPlayer(playerDTO);
	}

	@DeleteMapping("/delete-player")
	public void deleteFootballPlayer(Long footBallPlayerId) {
		footballTeamService.deletePlayer(footBallPlayerId);
	}

}
