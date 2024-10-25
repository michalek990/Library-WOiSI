package com.wp.library.Book.domain.observer;

import com.wp.library.Book.domain.constants.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Event {

    private EventType eventType;
    private Object data;
}
