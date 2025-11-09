package com.taip.reportservice.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private Long id;
    private String name;
    private String content;
    private LocalDate generatedAt;
}
