CREATE TABLE IF NOT EXISTS public.words
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    languages_first_id bigint NOT NULL,
    word_first_id bigint NOT NULL,
    languages_second_id bigint,
    word_second_id bigint,
    CONSTRAINT words_pkey PRIMARY KEY (id),
    CONSTRAINT fk_words_languages1 FOREIGN KEY (languages_first_id)
    REFERENCES public.languages (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fk_words_languages2 FOREIGN KEY (languages_second_id)
    REFERENCES public.languages (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID,
    CONSTRAINT fk_words_word1 FOREIGN KEY (word_first_id)
    REFERENCES public.word (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fk_words_word2 FOREIGN KEY (word_second_id)
    REFERENCES public.word (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.words
    OWNER to postgres ;