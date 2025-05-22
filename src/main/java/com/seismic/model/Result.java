package com.seismic.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    private String address;
    private String area;
    private String floors;
    private String usage;
    private String eqStrength;
    private String eqGrade;
    private String eqType;

    @Column(nullable = false)
    private LocalDate date;

    private boolean isShared;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<Comment> comments;
} 