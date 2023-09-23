DROP TABLE IF EXISTS patients CASCADE;
DROP TABLE IF EXISTS doctors CASCADE;
DROP TABLE IF EXISTS tickets CASCADE;

CREATE TABLE IF NOT EXISTS patients (
    id_patient BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    uuid_patient UUID NOT NULL,
    fullname_patient VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    UNIQUE (id_patient)
);

CREATE TABLE IF NOT EXISTS doctors (
    id_doctor BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    uuid_doctor UUID NOT NULL,
    fullname_doctor VARCHAR(255) NOT NULL,
    specialty_doctor VARCHAR(255) NOT NULL,
    UNIQUE (id_doctor)
);

CREATE TABLE IF NOT EXISTS tickets (
    id_ticket BIGINT GENERATED ALWAYS AS IDENTITY,
    id_p BIGINT NOT NULL,
    id_d BIGINT NOT NULL,
    duration_t INTEGER,
    start_time TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    FOREIGN KEY (id_p) REFERENCES patients (id_patient),
    FOREIGN KEY (id_d) REFERENCES doctors (id_doctor)
);

-- Индекс для ускорения запросов на поиск свободных слотов времени
CREATE INDEX idx_free_slots ON tickets (id_d, start_time);