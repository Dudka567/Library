CREATE TABLE IF NOT EXISTS public.rules
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    pattern character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT rules_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rules
    OWNER to postgres;