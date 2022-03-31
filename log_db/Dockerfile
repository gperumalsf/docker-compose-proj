FROM postgres:12.2-alpine

USER postgres

EXPOSE 5432

COPY init.sql /docker-entrypoint-initdb.d/

FROM library/postgres
ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB docker