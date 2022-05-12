CREATE TABLE IF NOT EXISTS public.languages
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    rules_id bigint NOT NULL,
    CONSTRAINT languages_pkey PRIMARY KEY (id),
    CONSTRAINT fk_languages_rules FOREIGN KEY (rules_id)
    REFERENCES public.rules (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.languages
    OWNER to postgres;