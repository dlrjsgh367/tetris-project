package com.geonho.tetris.controller;

import com.geonho.tetris.dto.ScoreRequest;
import com.geonho.tetris.dto.ScoreResponse;
import com.geonho.tetris.service.ScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

//    Valid 어노테이션을 붙여야  DTO 유효성 검사가 작동한다.
    @PostMapping("/score")
    public ResponseEntity<?> submitScore(@Valid @RequestBody ScoreRequest req) {
        scoreService.saveScore(req);
        // Todo: ok() 메서드 뭐지?
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rank")
    public ResponseEntity<List<ScoreResponse>> getTopScores() {
        return ResponseEntity.ok(scoreService.getTop10Scores());
    }
}
