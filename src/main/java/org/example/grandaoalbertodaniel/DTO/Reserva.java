package org.example.grandaoalbertodaniel.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reservas", schema = "CineClub")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "miembro_id", nullable = false)
    private Miembro miembro;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_reserva")
    private Instant fechaReserva;

    @NotNull
    @Column(name = "fecha_funcion", nullable = false)
    private LocalDate fechaFuncion;

}