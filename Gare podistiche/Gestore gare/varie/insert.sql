begin transaction;

insert into Atleta(id, citta, nome, cognome) values(1, 'Potenza', 'Simone', 'Smaldore');
insert into Atleta(id, citta, nome, cognome) values(2, 'Giamaica', 'Usain', 'Bolt');
insert into Atleta(id, citta, nome, cognome) values(3, 'Parigi', 'Charles', 'Leclerc');
insert into Atleta(id, citta, nome, cognome) values(4, 'Roma', 'Mario', 'Rossi');

insert into Gara(id, codice, dataGara, descrizione, km) values(1, '20km', '2020-03-27 15:00:00', 'gara sui 20 chilometri', 20.0);
insert into Gara(id, codice, dataGara, descrizione, km) values(2, '10km', '2020-07-2 16:30:00', 'gara sui 10 chilometri', 10.0);

insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(1, '2020-03-27 17:00:00', 1, 1);
insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(2, '2020-03-27 16:30:00', 2, 1);
insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(3, '2020-03-27 15:39:00', 3, 1);
insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(4, '2020-03-27 17:30:00', 1, 2);
insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(5, '2020-03-27 17:00:00', 2, 2);
insert into Arrivo(id, orarioArrivo, atleta_id, gara_id) values(6, '2020-03-27 16:55:00', 3, 2);

insert into Sponsor(id, italiano, nome, tipologia) values(1, true, 'Svelto', 'Programmazione');
insert into Sponsor(id, italiano, nome, tipologia) values(2, false, 'ErbaLight', 'Droga');
insert into Sponsor(id, italiano, nome, tipologia) values(3, true, 'Sartiani SRL', 'Programmazione');

insert into Atleta_Sponsor values(1,1);
insert into Atleta_Sponsor values(1,3);
insert into Atleta_Sponsor values(2,2);
insert into Atleta_Sponsor values(3,3);

insert into hibernate_sequences values ('Gara', 1);
insert into hibernate_sequences values ('Atleta', 1);
insert into hibernate_sequences values ('Sponsor', 1);
insert into hibernate_sequences values ('Arrivo', 1);
    
commit;