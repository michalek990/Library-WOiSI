package com.wp.library.Book.domain.contract;

public record BookResponse(String result) {

    public static BookResponse success(){
        return new BookResponse("SUCCESS");
    }
}
