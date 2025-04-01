package com.geonho.tetris.controller;

import com.geonho.tetris.dto.ScoreRequest;
import com.geonho.tetris.dto.ScoreResponse;
import com.geonho.tetris.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping("/score")
    public ResponseEntity<?> submitScore(@RequestBody ScoreRequest req) {
        scoreService.saveScore(req);
        // Todo: ok() 메서드 뭐지?
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rank")
    public ResponseEntity<List<ScoreResponse>> getTopScores() {
        return ResponseEntity.ok(scoreService.getTop10Scores());
    }
}
