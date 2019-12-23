package pl.project.student.entity;

import lombok.*;
import pl.project.student.validation.ZipCodeConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by A.Wójcik on 09.12.2019.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Street is mandatory.")
    @Column(name = "street")
    private String street;

    @NotBlank(message = "City is mandatory.")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Zip Code is mandatory.")
    @ZipCodeConstraint
    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType;

    public boolean isNew() {
        return this.id == null;
    }
}
