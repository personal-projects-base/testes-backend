--Entities

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

CREATE TABLE IF NOT EXISTS pessoas(

                                      id uuid,
                                      name varchar,
                                      logradouro varchar,
                                      bairo varchar,
                                      cep varchar,
                                      cidade uuid,
                                      created_by varchar(80),
    created_date timestamp,
    last_modified_by varchar(80),
    last_modified_date timestamp
    );

-- PKs

ALTER TABLE city  ADD CONSTRAINT ok_fttCY65PRHT4rqfbbmcb  PRIMARY KEY (id);
ALTER TABLE state  ADD CONSTRAINT ok_bfoSUhDX21Knqoqsboe4  PRIMARY KEY (id);
ALTER TABLE country  ADD CONSTRAINT ok_yuRL3pMuVQghqcwRr68f  PRIMARY KEY (id);
ALTER TABLE pessoas  ADD CONSTRAINT ok_ld8iiDM7Lisdqbwjgeuw  PRIMARY KEY (id);
-- Fks

ALTER TABLE city ADD CONSTRAINT fk_C4fpyh3CJewUG8bSi2mU FOREIGN KEY (state) REFERENCES state(id);
ALTER TABLE state ADD CONSTRAINT fk_nwlhOUZKgGE8oHEDG31o FOREIGN KEY (country) REFERENCES country(id);
ALTER TABLE pessoas ADD CONSTRAINT fk_3rMU08d3P6rMZutwZd2Y FOREIGN KEY (cidade) REFERENCES city(id);
