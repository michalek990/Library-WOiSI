package com.wp.library.Library.domain.contract;

public record BookResponse(String result) {

    public static BookResponse success(){
        return new BookResponse("SUCCESS");
    }
}
