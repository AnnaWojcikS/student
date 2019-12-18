package pl.project.student.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

/**
 * Created by A.Wójcik on 09.12.2019.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "pesel")
    private String pesel;


    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_address",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

    /*protected List<Address> getAddressesInternal() {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        return this.addresses;
    }

    protected void setAddressesInternal(List<Address> addresses) {
        this.addresses = addresses;
    }
    public void addAddress(Address address) {
        if (address.isNew()) {
            getAddressesInternal().add(address);
        }
        address.setStudent(this);
    }*/




}
