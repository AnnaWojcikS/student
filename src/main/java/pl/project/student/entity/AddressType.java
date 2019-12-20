package pl.project.student.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Wójcik on 09.12.2019.
 */
public enum AddressType {
    ZAMIESZKANIA("Zamieszkania"),
    ZAMELDOWANIA("Zameldowania"),
    KORESPONDENCYJNY("Korespondencyjny"),
    INNY("Inny");


    @Getter
    @Setter
    public String description;


    AddressType(String description) {
        this.description = description;
    }

}
