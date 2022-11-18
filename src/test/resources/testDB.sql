DROP TABLE IF EXISTS seminarbuchung;
create table seminarbuchung
(
    buchungsnummer uuid not null
        primary key,
    buchungsdatum  date,
    seminarnummer  bigint
        constraint fkfd9vqk9wj6accuvfowyhi0lc6
            references seminar,
    person_id      bigint
        constraint fkdhsiadfyj9re3yf7nlslx8pjm
            references person
);