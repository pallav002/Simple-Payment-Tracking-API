
package com.axipays.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Double amount;
    private String currency;
    private String description;

    @JsonIgnore
    private String cardNo;

    @JsonIgnore
    private String cardExpiry;

    @JsonIgnore
    private String cardCvc;

    private LocalDateTime createdAt = LocalDateTime.now();
}
