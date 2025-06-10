package com.myapp.training_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training_results")
public class TrainingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "pass_date")
    private LocalDate passDate;

    @Column(name = "number_protocol")
    private String numberProtocol;

    @Column(name = "card_id_changed")
    private Integer cardIdChanged;

    @Column(name = "changed_date")
    private LocalDate changedDate;

    @Column(name = "url_to_protocol_file", length = 1024)
    private String urlToProtocolFile;

    @Column(name = "certificate")
    private String certificate;

    @Column(name = "pass_next_date")
    private LocalDate passNextDate;

    @Column(name = "training_field")
    private Integer trainingField;

}