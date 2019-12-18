package pl.project.student.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by A.Wójcik on 09.12.2019.
 */
public enum AddressType {
    ZAMIESZK("Zamieszkania"),
    ZAMELD("Zameldowania"),
    KORESP("Korespondencyjny"),
    INNY("Inny");

    @Getter
    @Setter
    String description;

    AddressType(String description) {
        this.description = description;
    }

}
