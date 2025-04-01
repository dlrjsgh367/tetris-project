package com.geonho.tetris.service;

import com.geonho.tetris.dto.ScoreRequest;
import com.geonho.tetris.dto.ScoreResponse;
import com.geonho.tetris.entity.Score;
import com.geonho.tetris.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public void saveScore(ScoreRequest req) {
        Score score = Score.builder()
                .player(req.getPlayer())
                .score(req.getScore())
                .duration(req.getDuration())
                .createdAt(LocalDateTime.now())
                .build();
        scoreRepository.save(score);
    }

    public List<ScoreResponse> getTop10Scores() {
        return scoreRepository.findTop10ByOrderByScoreDesc()
                .stream()
                .map(score -> ScoreResponse.builder()
                        .player(score.getPlayer())
                        .score(score.getScore())
                        .duration(score.getDuration())
                        .build())
                .toList();
    }
}
