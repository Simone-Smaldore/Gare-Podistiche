
    create table Arrivo (
        id int8 not null,
        orarioArrivo timestamp,
        atleta_id int8,
        gara_id int8,
        primary key (id)
    );

    create table Atleta (
        id int8 not null,
        citta varchar(255),
        cognome varchar(255),
        nome varchar(255),
        primary key (id)
    );

    create table Atleta_Sponsor (
        atletiSponsorizzati_id int8 not null,
        sponsorizzazioni_id int8 not null
    );

    create table Gara (
        id int8 not null,
        codice varchar(255) unique,
        dataGara timestamp,
        descrizione varchar(255),
        km float8 not null,
        primary key (id)
    );

    create table Sponsor (
        id int8 not null,
        italiano boolean not null,
        nome varchar(255),
        tipologia varchar(255),
        primary key (id)
    );

    alter table Arrivo 
        add constraint FK7566E3011B7EABC1 
        foreign key (atleta_id) 
        references Atleta;

    alter table Arrivo 
        add constraint FK7566E301A5757B81 
        foreign key (gara_id) 
        references Gara;

    alter table Atleta_Sponsor 
        add constraint FKC1B4513443B5FE84 
        foreign key (sponsorizzazioni_id) 
        references Sponsor;

    alter table Atleta_Sponsor 
        add constraint FKC1B451349998B394 
        foreign key (atletiSponsorizzati_id) 
        references Atleta;

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value int4 
    ) ;
