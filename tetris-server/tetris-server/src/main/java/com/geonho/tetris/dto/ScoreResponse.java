package com.geonho.tetris.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreResponse {
    private String player;
    private int score;
    private String duration;
}
