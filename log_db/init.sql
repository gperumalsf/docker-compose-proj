DROP DATABASE IF EXISTS docker;
DROP ROLE IF EXISTS docker;

CREATE USER docker;
CREATE DATABASE docker;
GRANT ALL PRIVILEGES ON DATABASE docker TO docker;
GRANT ALL PRIVILEGES ON DATABASE docker TO postgres;

\c docker;

CREATE TABLE logs (
    id SERIAL PRIMARY KEY,
    timestamp VARCHAR,
    eventType VARCHAR,
    content VARCHAR
)