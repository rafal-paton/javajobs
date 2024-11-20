package com.javajobs.domain.login;

import lombok.Builder;

@Builder
record User(String id,
            String username,
            String password
) {
}