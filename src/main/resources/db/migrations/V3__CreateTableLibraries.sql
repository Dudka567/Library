CREATE TABLE IF NOT EXISTS public.libraries
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    source_language bigint NOT NULL,
    target_language bigint NOT NULL,
    CONSTRAINT library_pkey PRIMARY KEY (id),
    CONSTRAINT fk_libraries_source_language FOREIGN KEY (source_language)
    REFERENCES public.languages (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fk_libraries_target_language FOREIGN KEY (target_language)
    REFERENCES public.languages (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.libraries
    OWNER to postgres;