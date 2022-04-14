package io.wodo.walletsdk.domain;

import io.wodo.walletsdk.converter.EnumStatusConverter;
import io.wodo.walletsdk.enumtype.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wallet")
public class Wallet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idate", nullable = false)
    @CreatedDate
    private LocalDateTime insertDate;

    @Column(name = "udate")
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Convert(converter = EnumStatusConverter.class)
    @Column(name = "status", nullable = false, columnDefinition = "TINYINT")
    private EnumStatus status;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Wallet(EnumStatus status, BigDecimal amount) {
        this.status = status;
        this.amount = amount;
    }
}