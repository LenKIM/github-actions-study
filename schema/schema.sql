CREATE TABLE IF NOT EXISTS Users
(
    id BIGSERIAL PRIMARY KEY,
    user_name varchar(100),
    created_at TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW(),
    version BIGINT
    );

CREATE TABLE IF NOT EXISTS Company
(
    id BIGINT,
    user_id BIGINT,
    company_name varchar(100)
    )
