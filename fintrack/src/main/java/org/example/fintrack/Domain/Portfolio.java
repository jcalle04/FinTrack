package org.example.fintrack.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {

    private Long id;
    private String name;
    private Asset assets;
    private Float profit;
    private Float costBasis;

    private Boolean winLose;

}
