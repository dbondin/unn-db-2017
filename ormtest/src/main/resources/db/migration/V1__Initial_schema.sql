CREATE SEQUENCE cat_seq;

CREATE TABLE breed
(
  id serial NOT NULL,
  name character varying(32) NOT NULL,
  descr character varying(256),
  CONSTRAINT breed_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE cat
(
  id integer NOT NULL DEFAULT nextval('cat_seq'::regclass),
  name character varying(32) NOT NULL,
  age integer,
  breed_id integer,
  CONSTRAINT cat_pkey PRIMARY KEY (id),
  CONSTRAINT cat_breed_id_fkey FOREIGN KEY (breed_id)
      REFERENCES breed (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

