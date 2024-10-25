package com.wp.library.Book.domain.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public record BookMemento(String title, String description, Integer rate, String isbn) implements Serializable {

}
