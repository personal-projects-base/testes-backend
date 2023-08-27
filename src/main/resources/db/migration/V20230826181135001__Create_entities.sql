--Entities

CREATE TABLE IF NOT EXISTS city(

                                   id uuid,
                                   name varchar,
                                   code varchar,
                                   state uuid
);

CREATE TABLE IF NOT EXISTS state(

                                    id uuid,
                                    name varchar,
                                    code varchar,
                                    country uuid
);

CREATE TABLE IF NOT EXISTS country(

                                      id uuid,
                                      name varchar,
                                      code varchar
);

CREATE TABLE IF NOT EXISTS pessoas(

                                      id uuid,
                                      name varchar,
                                      logradouro varchar,
                                      bairo varchar,
                                      cep varchar,
                                      cidade uuid
);

-- PKs

ALTER TABLE city  ADD CONSTRAINT ok_R7ovNX5RemDU5BymT0jC  PRIMARY KEY (id);
ALTER TABLE state  ADD CONSTRAINT ok_TxgAVcSxBh93FvGKdJ9c  PRIMARY KEY (id);
ALTER TABLE country  ADD CONSTRAINT ok_6sfFnBWzagBzouzgogQM  PRIMARY KEY (id);
ALTER TABLE pessoas  ADD CONSTRAINT ok_P98a7gPnaUK07LRKlS9H  PRIMARY KEY (id);
-- Fks

ALTER TABLE city ADD CONSTRAINT fk_ymFLLjTe92Nnn24ZaQBO FOREIGN KEY (state) REFERENCES state(id);
ALTER TABLE state ADD CONSTRAINT fk_KORZ3yRBXby6Bb83cXMI FOREIGN KEY (country) REFERENCES country(id);
ALTER TABLE pessoas ADD CONSTRAINT fk_Lnj17Z6OAznsmKWEIC8D FOREIGN KEY (cidade) REFERENCES city(id);
