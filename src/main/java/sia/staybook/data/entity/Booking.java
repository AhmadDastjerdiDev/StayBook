package sia.staybook.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {

    public Booking(User guest, Accommodation accommodation,  LocalDateTime checkIn, LocalDateTime checkOut, BigDecimal totalPrice, Status status){
        this.guest = guest;
        this.accommodation = accommodation;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.status = status;;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime checkIn;

    @Column(nullable = false)
    private LocalDateTime checkOut;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private Status status;

    public enum Status{
        PENDING, CONFIRMED, CANCELLED
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;
}
