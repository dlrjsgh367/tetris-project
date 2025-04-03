package com.geonho.tetris.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRequest {

    @NotBlank(message = "플레이어 이름은 필수 입니다.")
    private String player;

    @Min(value = 0, message = "점수는 0 이상이어야 합니다.")
    private int score;

    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "시간 형식은 HH:mm:ss 여야 합니다.")
    private String duration;
}
