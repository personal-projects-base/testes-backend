--Entities

CREATE TABLE IF NOT EXISTS pessoa(

                                     id serial,
                                     name varchar,
                                     created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS pessoa_juridica(

                                              id serial,
                                              cnpj varchar,
                                              pessoa integer,
                                              created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS city(

                                   id uuid,
                                   name varchar,
                                   code varchar,
                                   state uuid,
                                   created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS state(

                                    id uuid,
                                    name varchar,
                                    code varchar,
                                    country uuid,
                                    created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS country(

                                      id uuid,
                                      name varchar,
                                      code varchar,
                                      created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS fiscal(

                                     id serial,
                                     optante_simples boolean,
                                     mod_tributacao varchar,
                                     cod_regime_tributario integer,
                                     created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

CREATE TABLE IF NOT EXISTS pessoa_telefone(

                                              id serial,
                                              fone varchar,
                                              pessoa integer,
                                              created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

-- PKs

ALTER TABLE pessoa  ADD CONSTRAINT ok_bdYQiMeF4CAH1Fmj0Pix  PRIMARY KEY (id);
ALTER TABLE pessoa_juridica  ADD CONSTRAINT ok_AJaAQlqjDzKPASIiGt6n  PRIMARY KEY (id);
ALTER TABLE city  ADD CONSTRAINT ok_1oXp6vxKVaJBz253KrIx  PRIMARY KEY (id);
ALTER TABLE state  ADD CONSTRAINT ok_LIva4BzPOLnXyDuP4kji  PRIMARY KEY (id);
ALTER TABLE country  ADD CONSTRAINT ok_a2S8IlLl7AH1bMtnJUF1  PRIMARY KEY (id);
ALTER TABLE fiscal  ADD CONSTRAINT ok_lqLJ1RlJRXM5bbL6firv  PRIMARY KEY (id);
ALTER TABLE pessoa_telefone  ADD CONSTRAINT ok_nrfsXPvONrppNguXYKuQ  PRIMARY KEY (id);
-- Fks

ALTER TABLE pessoa_juridica ADD CONSTRAINT fk_Z6Y0dAh3oMYoq53MmuvB FOREIGN KEY (pessoa) REFERENCES pessoa(id);
ALTER TABLE city ADD CONSTRAINT fk_cu9r6gbuqNVkXenoDrzV FOREIGN KEY (state) REFERENCES state(id);
ALTER TABLE state ADD CONSTRAINT fk_cVzEugGAETs8d4WVOviF FOREIGN KEY (country) REFERENCES country(id);
ALTER TABLE pessoa_telefone ADD CONSTRAINT fk_FiTTMre9cNpEktqshAtD FOREIGN KEY (pessoa) REFERENCES pessoa(id);
--RelationShips

