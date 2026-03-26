-- V2__add_verification_tokens.sql
ALTER TABLE users ADD COLUMN verified BOOLEAN NOT NULL DEFAULT FALSE;

CREATE TABLE verification_tokens (
    token VARCHAR(255) PRIMARY KEY,
    user_id UUID NOT NULL
);
